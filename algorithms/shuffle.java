package com.algs;

import java.util.Random;

public class Shuffle {
	public static void shuffle(int[] nums) {
		// Fisher�CYates shuffle
		// ÿ�δ�ʣ������������ȡ��һ���������һ��������
		// Ĭ��rand�ǰ�ȫ��
		Random rd = new Random();
		int len = nums.length;
		int j = len - 1;
		while (j-- > 1) {
			int index = rd.nextInt(j + 1);
			int a = nums[index];
			nums[index] = nums[j];
			nums[j] = a;
		}
	}
}
