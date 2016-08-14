package com.algs;

import java.util.Random;

public class RandomSample {
	/**
	 * 随机抽样也称为水池抽样, 大意是从大小为 n 的数组中随机选出 m 个整数，要求每个元素被选中的概率相同
	 * wiki介绍：https://en.wikipedia.org/wiki/Reservoir_sampling
	 * @param nums
	 * @param m
	 * @return sample
	 */
    public static int[] randomSample(int[] nums, int m) {
        if (null == nums || 0 == nums.length || m <= 0){
        	return new int[]{};
        }
        
        // 复制数组nums中的前m个元素到sample中
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
