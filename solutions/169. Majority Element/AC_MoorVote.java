	/**
	 * 1、Moore voting algorithm,摩尔投票法
	 * wiki：https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
	 *
	 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
    	// 
        int times = 0;
        int majority = 0;
        for(int i = 0; i < nums.length; i++){
        	// 如果出现次数为0，则前面没有出现大于一般的数字，重新设置新的数字
        	if(times == 0){
        		majority = nums[i];
        	}
        	if(nums[i] != majority){
        		times++;
        	}else{
        		times--;
        	}
        }
        return majority;
    }
}