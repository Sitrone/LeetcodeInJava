	/**
	 * 1. 求总和
	 * 2. 减去给定数组的全部值
	 *
	 */
public class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length, res = 0;
        for(int i = 0; i < len + 1; i++){
            res += i;
        }
        for(int i = 0; i < len; i++){
            res -= nums[i];
        }
        return res;
    }
}