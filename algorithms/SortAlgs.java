package com.algs;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;

public class SortAlgs {

	// 算法可视化网站：https://visualgo.net/sorting
	public static void main(String[] str) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		// Integer, Double String, File and URL have implements Comparable interface
		Integer[] a = new Integer[10];
		for(Integer i = 0; i < 10; i++){
			a[i] = i;
		}
		
		Class classType = Class.forName("com.algs.SortAlgs");

		Method[] methods = classType.getDeclaredMethods();
		
		for (Method methed : methods) {
/*			Collections.shuffle(Arrays.asList(a));
			methed.invoke(classType.newInstance(), a);*/
			System.out.println(methed);

			System.out.println(methed.getName());

		}
		
		Collections.shuffle(Arrays.asList(a));
		bubble(a);
		System.out.println(isSorted(a));
		System.out.println(Arrays.toString(a));
		
		Collections.shuffle(Arrays.asList(a));
		select(a);
		System.out.println(isSorted(a));
		System.out.println(Arrays.toString(a));
		
		Collections.shuffle(Arrays.asList(a));
		insertion(a);
		System.out.println(isSorted(a));
		System.out.println(Arrays.toString(a));
		
		Collections.shuffle(Arrays.asList(a));
		shell(a);
		System.out.println(isSorted(a));
		System.out.println(Arrays.toString(a));
		
		Collections.shuffle(Arrays.asList(a));
		sortMerge(a);
		System.out.println(isSorted(a));
		System.out.println(Arrays.toString(a));
	}

	public static void exch(Comparable[] arr, int i, int j) {
		Comparable t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static boolean isSorted(Comparable[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (less(arr[i], arr[i - 1])) {
				return false;
			}
		}
		return true;
	}

	// bubble sort
	/**
	 * 每次将最大的值下沉到最下面 时间复杂度：O(n^2)，空间复杂度：O(n)
	 * 
	 * @param arr
	 */
	public static void bubble(Comparable[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (less(arr[j], arr[j - 1])) {
					exch(arr, j, j - 1);
				}
			}
		}
	}

	// selection sort
	/**
	 * 每次选择最小的一个数排在最前面 时间复杂度：O(n^2)，空间复杂度：O(n)
	 * 
	 * @param arr
	 */
	public static void select(Comparable[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (less(arr[j], arr[min])) {
					min = j;
				}
			}
			exch(arr, i, min); // 和最小的元素交换
		}
	}

	// insertion sort
	/**
	 * 当前索引左边的所有元素都是有序的，但最终位置不确定，将当前元素与索引左边的元素比较，直到移动到合适的位置
	 * 时间复杂度：O(n^2)，空间复杂度：O(n)
	 * 
	 * @param arr
	 */
	public static void insertion(Comparable[] arr) {
		for (int i = 1; i < arr.length; i++) {
			// 将arr[i], 插入到前面已经排序好的数组中
			for (int j = i; j > 0; j--) {
				if (less(arr[j], arr[j - 1])) {
					exch(arr, j, j - 1);
				}
			}
		}
	}

	// shell sort
	/**
	 * 基于插入排序的快速排序算法
	 * 
	 * @param arr
	 */
	public static void shell(Comparable[] arr) {
		int N = arr.length;
		int h = 1;
		while (h < N / 3) {
			h = 3 * h + 1;
		}

		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h; j--) {
					if (less(arr[j], arr[j - h])) {
						exch(arr, j, j - h);
					}
				}
			}
			h = h / 3;
		}
	}

	private static Comparable[] aux;
	// merge sort, 归并排序
	/**
	 * 
	 * @param arr
	 */
	private static void sortMerge(Comparable[] arr) {
		aux = new Comparable[arr.length];
		sortMerge(arr, 0, arr.length - 1);
	}
	
	private static void sortMerge(Comparable[] arr, int lo, int hi){
		if(hi <= lo){
			return;
		}
		int mid = lo + (hi - lo)/2;
		sortMerge(arr, lo, mid);
		sortMerge(arr, mid + 1, hi);
		merge(arr, lo, mid, hi);
	}
	
	public static void merge(Comparable[] arr, int lo, int mid, int hi){
		int i = lo, j = mid + 1;
		
		for(int k = lo; k <= hi; k++){
			aux[k] = arr[k];
		}
		
		for(int k = lo; k <= hi; k++){
			if (i > mid)        			    arr[k] = aux[j++];
			else if (j > hi)     				arr[k] = aux[i++];
			else if (less(aux[j], aux[i])) 	    arr[k] = aux[j++];
			else 								arr[k] = aux[i++];
		}
	}

	// quick sort
	/**
	 * 
	 * @param arr
	 */
	public static void quick(Comparable[] arr) {

	}

	// heap sort
	public static void heap(Comparable[] arr) {

	}
}
