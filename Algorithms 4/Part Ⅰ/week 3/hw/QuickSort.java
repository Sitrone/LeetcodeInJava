package com.algs4.hw3;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort
{
	private QuickSort()
	{
		throw new AssertionError();
	}
	
	public static void sort(Comparable[] a)
	{
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi)
	{
		if(hi <= lo) return;
		int mid = partition(a, lo, hi);
		sort(a, lo, mid - 1);
		sort(a, mid + 1, hi);
		
	}
	
	private static int partition(Comparable[] a, int lo, int hi)
	{
		int i = lo, j = hi + 1;
		Comparable pivot = a[lo];
		while(true)
		{
			while(less(a[++i], pivot)) 
				if(i == hi) break;
			while(less(pivot, a[--j]))
				if(j == lo) break;
			if(i >= j) break;
			swap(a, i, j);
		}
		swap(a, lo, j);
		return j;
	}
	
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	
	private static void swap(Comparable[] a, int i, int j)
	{
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void quicksort(Comparable[] a)
	{
		quicksort(a, 0, a.length - 1);
	}
	
	
	public static void quicksort(Comparable[] a, int lo, int hi)
	{
		if(hi <= lo) return;
		int i = quickpart(a, lo, hi);
		quicksort(a, lo, i - 1);
		quicksort(a, i + 1, hi);
	}
	
	private static int quickpart(Comparable[] a, int lo, int hi)
	{
		int pivotIndex = StdRandom.uniform(lo, hi + 1);
		Comparable pivot = a[pivotIndex];
		swap(a, hi, pivotIndex);
		
		int i = lo -1, j = hi;
		do{
			while(less(a[++i], pivot));
			while(j > lo && less(pivot, a[--j]));
			if(i < j) swap(a, i, j);
		}while(i < j);
		
		swap(a, i, hi);
		return i;
	}

	public static void main(String[] args)
	{
		Integer[] a = new Integer[10];
		for(int i = 0; i < a.length; i++)
		{
			a[i] = i;
		}
		QuickSort.sort(a);
		System.out.println(Arrays.toString(a));
		
		StdRandom.shuffle(a);
		QuickSort.quicksort(a);
		System.out.println(Arrays.toString(a));
		
		System.out.println(get(1, 2));
	}
	
	private static double get(int a, int b)
	{
		return (double)a/b;
	}

}
