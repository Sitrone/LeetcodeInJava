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
		
		// ���ж�target���ڲ�����
		if(nums[mid] != target){
			return result;
		}
		
		// ��ߵڶ��ζ�������
		// �Ѿ��ҵ���Ŀ��Ԫ�أ������ұ߽��Ѿ�ȷ��
		// �����ж���������������󿴣�������������ҿ�
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
		
		// �ұߵ����ζ�������
		// �Ѿ��ҵ���Ŀ��Ԫ�أ�������߽��Ѿ�ȷ��
		// �����ж���������������ҿ�������������
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
