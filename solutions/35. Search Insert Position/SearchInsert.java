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
	 * ֱ������
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
	 * ���ֲ���
	 * �ص㣺���������в����ڵ������������ǣ�
	 * lowһ��ͣ��ǡ�ñ�Ŀ����index�ϣ�highһ��ͣ��ǡ�ñ�Ŀ��С��index��
	 * Ҳ�� num[high] target num[low]
	 * ���ӻ�������http://www.cs.usfca.edu/~galles/visualization/Search.html
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
