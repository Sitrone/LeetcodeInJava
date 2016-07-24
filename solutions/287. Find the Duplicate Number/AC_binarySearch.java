	/**
	 * 1、计算总数组中有多少个数小于等于中间数
	 * 2、如果小于等于中间数的数量小于中间数，则后半部分必有重复；反之则反
	 *
	 */
public class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length == 0)
			return 0;
		int low = 0, high = nums.length - 1;
		
		while(low <= high){
			int mid = low + (high - low) / 2;
			int count = 0;
			// 计算总数组中有多少个数小于等于中间数
			for(int i : nums){
				if(i <= mid){
					count++;
				}
			}
			// 如果小于等于中间数的数量小于中间数，则后半部分必有重复；反之则反
			if(count <= mid){
				low = mid + 1;
			}else{
				high = mid - 1;
			}
		}
		return low;
    }
}