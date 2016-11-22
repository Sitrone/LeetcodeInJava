package com.algs;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MinPQ<Key extends Comparable<Key>>
{
    private Key[] pq;
    private int N;
    
    public MinPQ()
    {
        this(1 << 4);
    }
    
    @SuppressWarnings("unchecked")
    public MinPQ(int capacity)
    {
        pq = (Key[]) new Comparable[capacity];
        N = 0;
    }
    
    public MinPQ(Key[] keys)
    {
        
    }
    
    public boolean isEmpty()
    {
        return N == 0;
    }
    
    public int size()
    {
        return N;
    }
    
    public void insert(Key key)
    {
        if(N > 0 && N == pq.length) resize(2 * pq.length);
        pq[++N] = key;
        swin(N);
        
        assert isMinPQ();
    }
    
    public Key min()
    {
        return pq[1];
    }
    
    public Key delMin()
    {
        Key min = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        if(N > 0 && N == pq.length / 4) resize(pq.length / 2);
        sink(1);
        
        assert isMinPQ();
        return min;
    }
    
    public void sink(int k)
    {
        while(2 * k < N)
        {
            int j = 2 * k;
            if(j < N && less(j + 1, j)) j++;
            if(less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    
    public void swin(int k)
    {
        while(k > 1 && less(k, k/2))
        {
            exch(k/2, k);
            k = k/2;
        }
    }
    
    public boolean isMinPQ()
    {
        return isMinPQ(1);
    }
    
    public boolean isMinPQ(int k)
    {
        if(k > N) return true;
        
        int left = 2 * k, right = 2 * k + 1;
        if(left > N && less(left, k)) return false;
        if(left > N && less(right, k)) return false;
        
        return isMinPQ(left) && isMinPQ(right);
    }
    
    private void resize(int capacity)
    {
        assert capacity > N;
        @SuppressWarnings("unchecked")
        Key[] temp = (Key[]) new Comparable[capacity + 1];
        System.arraycopy(pq, 0, temp, 0, N);
        pq = temp;
    }

    private boolean less(int i, int j)
    {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j)
    {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    
    public Iterator<Key> iterator()
    {
        return new HeapIterator();
    }
    
    public class HeapIterator implements Iterator<Key>
    {

        private MinPQ<Key> clone;
        
        public HeapIterator()
        {
            clone = new MinPQ<>(size());
            for(int i = 1; i < size(); i++) clone.insert(pq[i]);
        }
        @Override
        public boolean hasNext()
        {
            return !clone.isEmpty();
        }

        @Override
        public Key next()
        {
            if(!hasNext()) throw new UnsupportedOperationException(); ;
            return clone.delMin();
        }
        
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
    
    /**
     * A test client.
     */
    public static void main(String[] args) {
        MinPQ<String> pq = new MinPQ<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")){
                pq.insert(item);
            }
            else if (!pq.isEmpty()){
                StdOut.print(pq.delMin() + " ");
            }
        }
        StdOut.println("(" + pq.size() + " left on pq)");
    }
}
