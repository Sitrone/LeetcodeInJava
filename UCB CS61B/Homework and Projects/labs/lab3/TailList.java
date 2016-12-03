package com.cs61b.handout;

public class TailList extends SList
{
    private SListNode tail;
    
    public TailList()
    {
        super();
        tail = null;
    }
    
    @Override
    public void insertFront(Object obj)
    {
        head = new SListNode(obj, head);
        if(tail == null)
        {
            tail = head;
        }
        size++;
    }
    
    @Override
    public void insertEnd(Object obj)
    {
        if(tail == null)
        {
            head = new SListNode(obj);
            tail = head;
        }
        else
        {
            tail.next = new SListNode(obj);
            tail = tail.next;
        }
    }
    
    public static void main(String[] args)
    {
        SList s = new TailList();
        s.insertEnd(3);                 // Calls TailList.insertEnd()
        s.insertEnd(4);                 // Calls SList.insertEnd()
        System.out.println(s);
    }
}
