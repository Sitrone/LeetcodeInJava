	/**
	 * 使用HashMap，时间复杂度也是O(n)
	 * 
	 *
	 */
    public static int majorityElement2(int[] nums){
    	Map<Integer, Integer> map = new HashMap<Integer,Integer>();
    	int res = 0;
    	for(int i = 0; i< nums.length; i++){
    		if(!map.containsKey(nums[i])){
    			map.put(nums[i], 1);
    		}else{
    			map.put(nums[i], map.get(nums[i]) + 1);
    		}
    	}
    	
    	for(int i = 0; i< nums.length; i++){
    		if(map.get(nums[i]) > nums.length/2){
    			res = nums[i];
    			break;
    		}
    	}
    	return res;
    }