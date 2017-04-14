	/**
	 * 
	 * 
	 *
	 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 0)
		{
			return 0;
		}
		int res = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			res ^= nums[i];
		}
		return res;
    }
}