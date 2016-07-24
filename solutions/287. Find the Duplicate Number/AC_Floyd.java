	/**
	 * 参考 Link list Cycle II
	 * Floyd 判圈法找环的起点
	 *
	 */
public class Solution {
    public int findDuplicate(int[] nums) {
		int slow = 0, fast = 0;
		do{
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(slow != fast);
		
		int find = 0;
		while(find != slow){
			find = nums[find];
			slow = nums[slow];
		}
		return find;
    }
}