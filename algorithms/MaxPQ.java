package com.algs;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * 优先队列基于二叉堆实现，数据存储在数组pq[1 ... N]中，其中pq[0]不使用
 */
public class MaxPQ<Key extends Comparable<Key>> implements Iterable<Key>
{
    private static final int DEFAULT_LENGTH = 1 << 4;

    private Key[] pq;
    private int N = 0;

    public MaxPQ()
    {
        this(DEFAULT_LENGTH);
    }

    @SuppressWarnings("unchecked")
    public MaxPQ(int capacity)
    {
        pq = (Key[]) new Comparable[capacity + 1];
    }
    
    @SuppressWarnings("unchecked")
    public MaxPQ(Key[] keys)
    {
        int N = keys.length;
        pq = (Key[]) new Comparable[N + 1];
        for(int i = 0; i < N; i++) pq[i + 1] = keys[i];
        for(int k = N/2; k > 1; k--) swin(k);  // 堆有序
        
        assert isMaxPQ();
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    public void insert(Key v)
    {
        if(N == pq.length - 1) resize(N + N / 2);
        pq[++N] = v;
        swin(N);
        
        assert isMaxPQ();
    }

    public Key delMax()
    {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null; // 防止对象游离
        if(N > 0 && N == pq.length / 4) resize(pq.length / 2);
        sink(1);
        
        assert isMaxPQ();
        return max;
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

    private void swin(int k)
    {
        while (k > 1 && less(k / 2, k))
        {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k)
    {
        while (2 * k <= N)
        {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;  // 找到两个子节点中较大的
            if (!less(k, j)) break;  // 若父节点大于较大的子节点，则两者交换
            exch(k, j);
            k = j;
        }
    }
    
    private void resize(int capacity)
    {
        assert capacity > N;
        @SuppressWarnings("unchecked")
        Key[] temp = (Key[]) new Comparable[capacity + 1];
        System.arraycopy(getClass(), 0, temp, 0, N);
        pq = temp;
    }
    
    private boolean isMaxPQ()
    {
        return isMaxPQ(1);
    }
    
    private boolean isMaxPQ(int k)
    {
        if(k > N) return true;
        int left = 2 * k, right = 2 * k + 1;
        
        if(left < N && less(k, left)) return false;
        if(left < N && less(k, right)) return false;
        
        return isMaxPQ(left) && isMaxPQ(right);
    }
    
    @Override
    public Iterator<Key> iterator()
    {
        return new HeapIterator();
    }
    
    public class HeapIterator implements Iterator<Key>
    {
        private MaxPQ<Key> clone;
        
        public HeapIterator()
        {
            clone = new MaxPQ<>(size());
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
            return clone.delMax();
        }
        
        public void remove()
        {
            throw new UnsupportedOperationException(); 
        }
    }
    
    public static void main(String[] args)
    {
        MaxPQ<String> pq = new MaxPQ<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) pq.insert(item);
            else if (!pq.isEmpty()) StdOut.print(pq.delMax() + " ");
        }
        StdOut.println("(" + pq.size() + " left on pq)");
    }
}
