package com.cs61b.hw4;

public class LockDList extends DList
{
    @Override
    protected DListNode newNode(Object item, DListNode prev, DListNode next)
    {
        return new LockDListNode(item, (LockDListNode) prev, (LockDListNode) next);
    }

    /**
     * LockDList() constructor for an empty DList.
     */
    public LockDList()
    {
        head = new LockDListNode(null, null, null);
        head.next = head;
        head.prev = head;
        ((LockDListNode) head).isLocked = true;
        size = 0;
    }

    public void lockNode(DListNode node)
    {
        ((LockDListNode) node).isLocked = true;
    }

    @Override
    public void remove(DListNode node)
    {
        if (((LockDListNode) node).isLocked == true)
        {
            return;
        }
        super.remove(node);
    }

}
