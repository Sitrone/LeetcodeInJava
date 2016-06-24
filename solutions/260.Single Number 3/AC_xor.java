public class SingleNumberThree {
    public static int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int diff = 0;
        for(int num:nums ){
        	diff ^= num;
        }
        diff &= -diff;
        for(int num:nums){
            if((num & diff) == 0) {
            	result[0] ^= num;
            }else {
            	result[1] ^= num;
            }
        }
		return result;                                        
    }
}