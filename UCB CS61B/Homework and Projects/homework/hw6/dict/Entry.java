/* Entry.java */

package com.cs61b.hw6.dict;

/**
 *  A class for dictionary entries.
 *
 *  DO NOT CHANGE THIS FILE.  It is part of the interface of the
 *  Dictionary ADT.
 **/

public class Entry
{

    protected Object key;
    protected Object value;

    public Entry(Object key, Object value)
    {
        this.key = key;
        this.value = value;
    }
    
    public Entry()
    {
        this(null, null);
    }

    public Object key()
    {
        return key;
    }

    public Object value()
    {
        return value;
    }
    
    @Override
    public String toString()
    {
        return "Entry [key=" + key + ", value=" + value + "]";
    }
}
