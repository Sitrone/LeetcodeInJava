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
	//Fisher�CYates shuffle
	// ÿ�δ�ʣ������������ȡ��һ���������һ��������
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
