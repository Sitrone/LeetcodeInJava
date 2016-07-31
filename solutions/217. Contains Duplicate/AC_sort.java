	/**
	 * 先排序，再比较相邻的数
	 * 
	 *
	 */
public class ContainsDuplicate {
	// Sort
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
}