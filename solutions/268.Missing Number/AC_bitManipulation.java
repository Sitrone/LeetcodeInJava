	/**
	 * 完整数组的长度比给定数组长度多1
	 * 完整数组与给定数组的元素全部异或一次，结果即为丢失的数字
	 *
	 */
public class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length, res = nums[0];
        for(int i = 0; i < len + 1; i++){
            res ^= i;
        }
        for(int i = 1; i < len; i++){
            res ^= nums[i];
        }
        return res;
    }
}