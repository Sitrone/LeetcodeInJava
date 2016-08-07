package com.test;

import java.util.Random;

public class Prime {

	// 素数检测，如果n不是素数，则必然存在一个小于或等于sqrt(n)的因子
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

	// 费马检测
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

	// 反复平方法求幂次的模
	// 对每次乘幂的结果进行求模，避免造成溢出
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
