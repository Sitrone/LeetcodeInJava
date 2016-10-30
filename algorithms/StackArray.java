package com.algs;

import java.util.Iterator;

public class StackArray<Item> implements Iterable<Item> {
	private Item[] arr = (Item[]) new Object[1];  // Java�޷������������飬ֻ��ʹ��ת������
	private int N = 0;
	
	public boolean isEmpty(){
		return 0 == N;
	}
	
	public int size(){
		return N;
	}
	
	/**
	 * ���ջ�Ƿ�Ϊ��
	 * @return
	 */
	public Item pop(){
		if(N < 0){
			throw new IllegalArgumentException();
		}
		Item result = arr[N--];
		arr[N--] = null;    // �����ڴ������Ҳ����������
		if(N > 0 && N == arr.length / 4){
			resize(arr.length/2);
		}
		return result;
	}
	
	/**
	 * ��Ҫ���ջ�Ƿ�����
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
	 * ջ�Ǻ���ȳ��������������
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
