/*
*左右两边扫描分别存储i左边和右边值的乘积
*result[i] = left[i] * right[i]
*/
public class Solution {
    public int[] productExceptSelf(int[] nums) {
    	int len = nums.length;
    	int[] res = new int[len];
    	
    	int[] left = new int[len];
    	int[] right = new int[len];
    	
    	left[0] = 1;
    	for(int i = 1; i < len; i++)
    		left[i] = left[i - 1] * nums[i - 1];
    	right[len - 1] = 1;
    	for(int i = len - 2; i >= 0; i--)
    		right[i] = right[i + 1] * nums[i + 1];
    	
    	for(int i = 0; i < len; i++)
    		res[i] = left[i] * right[i];
    	
    	return res;
    }
}