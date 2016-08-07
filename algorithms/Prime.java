package com.test;

import java.util.Random;

public class Prime {

	// ������⣬���n�������������Ȼ����һ��С�ڻ����sqrt(n)������
	public static boolean isPrime(int n) {
		return (maxDivisor(n) == n) ? true : false;
	}

	private static int maxDivisor(int n) {
		// TODO Auto-generated method stub
		int test = 2;
		while (Math.pow(test, 2) < n) {
			if ((n % test) == 0) {
				return test;
			}
			test++;
		}
		return n;
	}

	// ������
	public static boolean fermatTest(int n, int times) {
		if (times < 0) {
			System.out.println("times is ERROR!");
		}
		Random rand = new Random();
		while (times-- > 0) {
			int testRandom = rand.nextInt(n);
			int testMod = expmod(testRandom, n, n);
			if (testMod != testRandom) {
				return false;
			}
		}
		return true;
	}

	// ����ƽ�������ݴε�ģ
	// ��ÿ�γ��ݵĽ��������ģ������������
	private static int expmod(int base, int exp, int m) {
		if (exp == 0) {
			return 1;
		}
		if ((exp & 1) == 0) {
			return (square(expmod(base, exp / 2, m))) % m;
		} else {
			return (expmod(base, exp - 1, m) * base) % m;
		}
	}
	
	private static int square (int n){
		return n * n;
	}
}
