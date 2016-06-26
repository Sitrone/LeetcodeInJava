public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for(int k = 0; k < nums.length; k++)                          //注意初始化数组为1，防止出现[0,1]
            res[k] = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i == j)
                    continue;
                else
                    res[i] *= nums[j];
            }
        }
        return res;
    }
}