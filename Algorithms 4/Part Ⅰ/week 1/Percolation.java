package com.algs4.hw1;

public class Percolation
{
    private int[] arr;
    public Percolation(int n)
    {
        for(int i = 0; i < n; i++)
        {
            arr[i] = i;
        }
    }
    
    public boolean isOpen(int i, int j)
    {
        return false;
    }
    
    public boolean isFull(int i, int j)
    {
        return false;
    }
    
    public void open(int i, int j)
    {
        
    }
    
    public boolean percolates()
    {
        return false;
    }
}
