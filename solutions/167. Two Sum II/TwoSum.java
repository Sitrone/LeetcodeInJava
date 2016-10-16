package leetcode;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{1,2,3,4,4,9,56,90};
		System.out.println(Arrays.toString(twoSum(arr, 8)));
	}

	/**
	 * �������������ע�⣺
	 * 1. ��������������������l <= h,���� 1 2 3 4 5��key=5; left==rightʱ����ѵ�key
	 * 2. h = mid - 1, l = mid + 1
	 * @param numbers
	 * @param target
	 * @return
	 */
    public static int[] twoSum(int[] numbers, int target) {
    	int length = numbers.length;
        if(length < 0){
        	return null;
        }
        
        int index[] = new int[]{1, 1};
        for(int i = 0; i < length; i++){
        	index[0] += i;
        	
        	int num = target - numbers[i];
        	int l = i + 1, h = length - 1;
        	while(l <= h){
        		int middle = l + ((h - l) >> 2);
        		
        		if(num == numbers[middle]){
        			index[1] += middle;
        			return index;
        		}else if(num < numbers[middle]){
        			h = middle - 1;
        		}else{
        			l = middle + 1;
        		}
        	}
        	index[0] = 1;
        	index[1] = 1;
        }
        return index;
    }
}
