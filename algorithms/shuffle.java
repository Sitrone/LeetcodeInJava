package com.algs;

import java.util.Random;

public class Shuffle {
	public static void shuffle(int[] nums) {
		// Fisher–Yates shuffle
		// 每次从剩余的数组中随机取出一个数与最后一个数交换
		// 默认rand是安全的
		Random rd = new Random();
		int len = nums.length;
		int j = len;
		while (j-- > 1) {
			int index = rd.nextInt(j + 1);
			int a = nums[index];
			nums[index] = nums[j];
			nums[j] = a;
		}
	}
}
