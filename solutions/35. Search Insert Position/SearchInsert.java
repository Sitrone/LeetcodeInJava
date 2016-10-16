package leetcode;

public class SearchInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 1 };
		for (int i = 0; i < 3; i++) {
			System.out.print(i + " ");
			System.out.println(searchInsert1(nums, i));
		}
	}

	/**
	 * 直接搜索
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (target <= nums[i]) {
				return i;
			}
		}
		return nums.length;
	}

	/**
	 * 二分查找
	 * 特点：对于数组中不存在的情况，最后总是：
	 * low一定停在恰好比目标大的index上，high一定停在恰好比目标小的index上
	 * 也即 num[high] target num[low]
	 * 可视化操作：http://www.cs.usfca.edu/~galles/visualization/Search.html
	 */
	public static int searchInsert1(int[] nums, int target) {
		int low = 0, high = nums.length - 1;

		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (target == nums[mid]) {
				return mid;
			} else if (target > nums[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return low;
	}
}
