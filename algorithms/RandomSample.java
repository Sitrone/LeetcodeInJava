package com.algs;

import java.util.Random;

public class RandomSample {
	/**
	 * �������Ҳ��Ϊˮ�س���, �����ǴӴ�СΪ n �����������ѡ�� m ��������Ҫ��ÿ��Ԫ�ر�ѡ�еĸ�����ͬ
	 * wiki���ܣ�https://en.wikipedia.org/wiki/Reservoir_sampling
	 * @param nums
	 * @param m
	 * @return sample
	 */
    public static int[] randomSample(int[] nums, int m) {
        if (null == nums || 0 == nums.length || m <= 0){
        	return new int[]{};
        }
        
        // ��������nums�е�ǰm��Ԫ�ص�sample��
        int[] sample = new int[m];
        for (int i = 0; i < m; i++) {
            sample[i] = nums[i];
        }

        Random random = new Random();
        for (int i = m; i < nums.length; i++) {
            int k = random.nextInt(i + 1); // 0~i(inclusive)
            if (k < m) {
                sample[k] = nums[i];
            }
        }

        return sample;
    }
}
