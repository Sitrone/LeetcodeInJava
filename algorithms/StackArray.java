package com.algs;

import java.util.Iterator;

public class StackArray<Item> implements Iterable<Item> {
	private Item[] arr = (Item[]) new Object[1];  // Java无法创建泛型数组，只能使用转换类型
	private int N = 0;
	
	public boolean isEmpty(){
		return 0 == N;
	}
	
	public int size(){
		return N;
	}
	
	/**
	 * 检测栈是否为空
	 * @return
	 */
	public Item pop(){
		if(N < 0){
			throw new IllegalArgumentException();
		}
		Item result = arr[N--];
		arr[N--] = null;    // 避免内存溢出，也即对象游离
		if(N > 0 && N == arr.length / 4){
			resize(arr.length/2);
		}
		return result;
	}
	
	/**
	 * 需要检测栈是否已满
	 * @param item
	 */
	public void push(Item item){
		if(N == arr.length){
			resize(2 * arr.length);
		}
		arr[N++] = item;
	}
	
	/**
	 * 
	 * @param newSize
	 */
	private void resize(int newSize){
		Item[] newArr = (Item[]) new Object[newSize];
		for(int i = 0; i < N; i++){
			newArr[i] = arr[i];
		}
		arr = newArr;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	/**
	 * 栈是后进先出，逆序遍历数组
	 * @author Administrator
	 *
	 */
	private class ReverseArrayIterator implements Iterator<Item>{
		private int i = N;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return arr[--i];
		}

	}

}
