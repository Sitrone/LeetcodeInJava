package com.algs4.hw1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation1
{
    private int size;
    private boolean[][] status;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF ufToTop;
    private int top, bottom;

    // 关键，多设一个top和bottom节点，用来关联top row和bottom row
    // 另外，i,代表行，j，代表列
    // 有backwash问题
    
    public Percolation1(int n)
    {
        if (n <= 0)
        {
            throw new IllegalArgumentException("can not be negtive " + n);
        }

        size = n;
        top = 0;
        bottom = n * n + 1;
        uf = new WeightedQuickUnionUF(n * n + 2);
        ufToTop = new WeightedQuickUnionUF(n * n + 1);
        status = new boolean[n][n];
    }

    public boolean isOpen(int i, int j)
    {
        assertBounds(i);
        assertBounds(j);

        return status[i - 1][j - 1];
    }

    public boolean isFull(int i, int j)
    {
        assertBounds(i);
        assertBounds(j);
        return ufToTop.connected(top, xyToPos(i, j));
    }

    public void open(int i, int j)
    {
        assertBounds(i);
        assertBounds(j);
        
        status[i - 1][j - 1] = true;
        if (i == 1)
        {
            uf.union(top, xyToPos(i, j));
            ufToTop.union(top, xyToPos(i, j));
        }

        if (!percolates())
        {
            if (i == size) uf.union(bottom, xyToPos(i, j));
        }

        int center = xyToPos(i, j);
        if (i > 1 && isOpen(i - 1, j))
        {
            uf.union(center, xyToPos(i - 1, j));
            ufToTop.union(center, xyToPos(i - 1, j));
        }
        if (i < size && isOpen(i + 1, j))
        {
            uf.union(center, xyToPos(i + 1, j));
            ufToTop.union(center, xyToPos(i + 1, j));
        }
        if (j > 1 && isOpen(i, j - 1))
        {
            uf.union(center, xyToPos(i, j - 1));
            ufToTop.union(center, xyToPos(i, j - 1));
        }
        if (j < size && isOpen(i, j + 1))
        {
            uf.union(center, xyToPos(i, j + 1));
            ufToTop.union(center, xyToPos(i, j + 1));
        }
    }

    public boolean percolates()
    {
        return uf.connected(top, bottom);
    }

    private int xyToPos(int i, int j)
    {
        return size * (i - 1) + j;
    }

    private void assertBounds(int i)
    {
        if (i < 1 || i > size)
        {
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
    }

    public static void main(final String[] args)
    {
        Percolation p = new Percolation(4);
        p.open(4, 1);
        p.open(3, 1);
        p.open(2, 1);
        p.open(1, 1);
        p.open(1, 4);
        p.open(2, 4);
        p.open(4, 4);
        System.out.println("Does it percolates? " + p.percolates());

    }
}
