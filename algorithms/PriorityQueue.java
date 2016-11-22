package com.algs;

public class PriorityQueue<Key extends Comparable<Key>>
{
    private static final int DEFAULT_LENGTH = 1 << 4;

    private Key[] pq;
    private int N = 0;

    public PriorityQueue()
    {
        this(DEFAULT_LENGTH);
    }

    @SuppressWarnings("unchecked")
    public PriorityQueue(int max)
    {
        pq = (Key[]) new Comparable[max + 1];
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
        pq[++N] = v;
        swin(N);
    }

    public Key delMax()
    {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null; // ��ֹ��������
        sink(1);
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
            if (j < N && less(j, j + 1)) j++;  // �ҵ������ӽڵ��нϴ��
            if (!less(k, j)) break;  // �����ڵ���ڽϴ���ӽڵ㣬�����߽���
            exch(k, j);
            k = j;
        }
    }
}
