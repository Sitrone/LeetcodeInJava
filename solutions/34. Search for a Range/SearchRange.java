package leetcode;

import java.util.Arrays;

public class SearchRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1};
		System.out.println(Arrays.toString(searchRange(nums, 0)));
	}

	public static int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		
		int[] result = new int[]{-1, -1};
		
		int low = 0, high = nums.length - 1;
		int mid = 0;
		while(low <= high){
			mid = low + ((high - low) >> 1);
			if(target == nums[mid]){
				result[0] = mid;
				result[1] = mid;
				break;
			}else if(target > nums[mid]){
				low = mid + 1;
			}else{
				high = mid - 1;
			}
		}
		
		// 先判断target存在不存在
		if(nums[mid] != target){
			return result;
		}
		
		// 左边第二次二分搜索
		// 已经找到了目标元素，其中右边界已经确定
		// 所以判断条件是相等则向左看，否则大于则向右看
		int newLow = 0, newHigh = mid;
		while(newLow <= newHigh){
			int newMid = newLow + ((newHigh - newLow) >> 1);
			if(nums[newMid] == target){
				newHigh = newMid - 1;
			}else{
				newLow = newMid + 1;
			}
		}
		result[0] = newLow;
		
		// 右边第三次二分搜索
		// 已经找到了目标元素，其中左边界已经确定
		// 所以判断条件是相等则向右看，大于则向左看
		newLow = mid; newHigh = nums.length - 1;
		while(newLow <= newHigh){
			int newMid = newLow + ((newHigh - newLow) >> 1);
			if(nums[newMid] == target){
				newLow = newMid + 1;
			}else{
				newHigh = newMid - 1;
			}
		}
		result[1] = newHigh;
		
		return result;
	}
}
