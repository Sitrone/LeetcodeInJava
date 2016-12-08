/* HashTableChained.java */

package com.cs61b.hw6.dict;

import java.util.Random;

import com.cs61b.hw5.DList;
import com.cs61b.hw5.InvalidNodeException;
import com.cs61b.hw5.List;
import com.cs61b.hw5.ListNode;

/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

  /**
   *  Place any data fields here.
   **/
    private int size;
    private int entryNumber;
    private List[] hashTable;
    private int collisions = 0;


  /** 
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/

    public HashTableChained(int sizeEstimate)
    {
        // Your solution here.
        size = getPrimer(sizeEstimate);
        initHashTable();
    }
    
    private int getPrimer(int input)
    {
        for(int i = input; ;i++)
        {
            if(isPrimer(i)) return i;
        }
    }
    
    private boolean isPrimer(int input)
    {
        for(int i = 2; i < Math.sqrt(input); i++)
        {
            if(input % i == 0) return false;
        }
        return true;
    }

  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

    public HashTableChained()
    {
        // Your solution here.
        size = 101;
        initHashTable();
    }
    
    private void initHashTable()
    {
        hashTable = new DList[size];
        for(int i = 0; i < size; i++)
        {
            hashTable[i] = new DList();
        }
    }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

    int compFunction(int code)
    {
        // Replace the following line with your solution.
        int a = 3, b = 5, p = 16908799;
        return (Math.abs((a * code + b)) % p) % hashTable.length;
    }

  /** 
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

    public int size()
    {
        // Replace the following line with your solution.
        return entryNumber;
    }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

    public boolean isEmpty()
    {
        // Replace the following line with your solution.
        return entryNumber == 0;
    }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

    public Entry insert(Object key, Object value)
    {
        // Replace the following line with your solution.
        Entry entry = new Entry(key, value);
        int bucket = compFunction(key.hashCode());
        if(hashTable[bucket].length() != 0)
        {
            collisions++;
        }
        hashTable[bucket].insertFront(entry);
        entryNumber++;
        return entry;
    }

  /** 
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
 * @throws InvalidNodeException 
   **/

    public Entry find(Object key) throws InvalidNodeException
    {
        // Replace the following line with your solution.
        int bucket = compFunction(key.hashCode());
        if(hashTable[bucket].length() != 0)
        {
            ListNode cur = hashTable[bucket].front();
            while(cur.isValidNode())
            {
                if(((Entry)(cur.item())).key.equals(key))
                {
                    return (Entry) cur.item();
                }
                cur = cur.next();
            }
        }
        return null;
    }

  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
 * @throws InvalidNodeException 
   */

    public Entry remove(Object key) throws InvalidNodeException
    {
        // Replace the following line with your solution.
        int bucket = compFunction(key.hashCode());
        if(hashTable[bucket].length() != 0)
        {
            ListNode cur = hashTable[bucket].front();
            while(cur.isValidNode())
            {
                if(((Entry)(cur.item())).key.equals(key))
                {
                    Entry entry = (Entry) cur.item();
                    cur.remove();
                    entryNumber--;
                    return entry;
                }
                cur = cur.next();
            }
        }
        return null;
    }

  /**
   *  Remove all entries from the dictionary.
 * @throws InvalidNodeException 
   */
    public void makeEmpty() throws InvalidNodeException
    {
        // Your solution here.
        for(int i = 0; i < size; i++)
        {
            makeBucketEmpty(hashTable[i]);
        }
    }
    
    private void makeBucketEmpty(List list) throws InvalidNodeException
    {
        ListNode cur = list.front(), temp;
        while(cur.isValidNode())
        {
            cur = list.front();
            temp = cur;
            cur = cur.next();
            temp.remove();
            entryNumber--;
        }
    }
    
    @Override
    public String toString()
    {
        String hashString = "";
        for (int i = 0; i < size; i++)
        {
            if (!hashTable[i].isEmpty())
            {
                hashString += i + " :" + hashTable[i].length() + "\n";
            }
        }
        return hashString;
    }
    
    public double expectedRate() {
        int n = entryNumber;
        int N = size;
        return n - N + N * Math.pow(1 - 1 / (double) N, n);
    }

    public static void main(String[] args) throws InvalidNodeException {
        HashTableChained hash = new HashTableChained(100);
        Random rand = new Random(1);
        for (int i = 20; i > 0; i--) {
            hash.insert(Math.abs(rand.nextInt()), i);
        }

        System.out.println(hash);
        System.out.println(hash.collisions);
        System.out.printf("%.2f", hash.expectedRate());
        System.out.println("1".hashCode());
        
        HashTableChained table = new HashTableChained(100);
        System.out.println("=====================size, isEmpty=========================");
        System.out.println("table's size is: " + table.size());
        System.out.println("table is Empty: " + table.isEmpty());
        
        System.out.println("=====================insert================================");
        table.insert("1", "The first one");
        table.insert("2", "The second one");
        table.insert("3", "The third one");
        table.insert("what", "nani?");
        table.insert("the","Eh-heng");
        table.insert("hell!","impolite");
        System.out.println("table's size is: " + table.size());
        System.out.println("table is Empty: " + table.isEmpty());

        System.out.println("====================find, remove===========================");
        Entry e1 = table.find("6");
        if(e1 != null)
                System.out.println("The item found is: [ " + e1.toString() + " ]");
        else
                System.out.println("The is no such item in the table to be found.");
        
        Entry e2 = table.remove("hell!");
        if(e2 != null)
                System.out.println("The item deleted is: [ " + e2.toString() + " ]");
        else
                System.out.println("The is no such item in the table to be deleted.");
        
        System.out.println("=====================makeEmpty=============================");
        table.makeEmpty();
        System.out.println(table.size());

    }
}
