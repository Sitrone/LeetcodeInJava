package com.test;

public class CountChange {
	private final static int[] nums = new int[]{1, 5, 10, 25, 50};//零钱的种类

	public static int countChange(int amount) {
		return helper(amount, 5);
	}

	/**
	 * sum = 没有使用第一种零钱的方式 + 用了第一种换钱方式
	 * @param amount
	 * @param kindsOfCoins
	 * @return 找零的方法数目
	 */
	private static int helper(int amount, int kindsOfCoins) {
		if (amount == 0) {
			return 1;
		} else if (amount < 0 || kindsOfCoins == 0) {
			return 0;
		}else{
			return helper(amount, kindsOfCoins - 1)
					+ helper((amount - nums[kindsOfCoins -1]), kindsOfCoins);
		}
	}
}
