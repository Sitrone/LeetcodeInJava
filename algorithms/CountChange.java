package com.test;

public class CountChange {
	private final static int[] nums = new int[]{1, 5, 10, 25, 50};//��Ǯ������

	public static int countChange(int amount) {
		return helper(amount, 5);
	}

	/**
	 * sum = û��ʹ�õ�һ����Ǯ�ķ�ʽ + ���˵�һ�ֻ�Ǯ��ʽ
	 * @param amount
	 * @param kindsOfCoins
	 * @return ����ķ�����Ŀ
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
