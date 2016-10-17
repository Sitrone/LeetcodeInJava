package leetcode;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {
	private int[] arr;
	private Random random;

	public ShuffleArray(int[] nums) {
		this.arr = nums;
		this.random = new Random();
	}
	
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.arr;
    }
    
    /** Returns a random shuffling of the array. */
	//Fisher–Yates shuffle
	// 每次从剩余的数组中随机取出一个数与最后一个数交换
    public int[] shuffle() {
    	int [] res = Arrays.copyOf(this.arr, this.arr.length);
    	int j = res.length;
    	
        while(j-- > 1){
        	int left = random.nextInt(j + 1);
        	swap(res, left, j);
        }
        return res;
    }
    
    private void swap(int[] num, int i, int j){
    	int temp = num[i];
    	num[i] = num[j];
    	num[j] = temp;
    }
}
