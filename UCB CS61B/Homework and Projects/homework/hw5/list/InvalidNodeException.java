/* InvalidNodeException.java */

package com.cs61b.hw5;

/**
 * Implements an Exception that signals an attempt to use an invalid ListNode.
 */

public class InvalidNodeException extends Exception
{
    /**
     * 
     */
    private static final long serialVersionUID = 2951087980504259392L;

    protected InvalidNodeException()
    {
        super();
    }

    protected InvalidNodeException(String s)
    {
        super(s);
    }
}
