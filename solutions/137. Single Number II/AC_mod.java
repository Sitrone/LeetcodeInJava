	/**
	 * 
	 * 1、int型长度是32位，创建32位长度数组存储元素中1出现的次数
	 * 2、数字出现K次，则取模k，最后将结果相加则为只出现一次的值
	 * 
	 */
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        int[] bit = new int[32];
    	for(int i = 0; i < 32; i++){
    		for(int j = 0; j < nums.length; j++){ //求出每个数第i位上的1的次数之和
    			bit[i] += nums[j] >> i & 0x01;
    		}
    		result += (bit[i] % 3) << i;  //求出第i位上的余数
    	}
        
        return result;
    }
}

    /**
     * Ref
	其实只要理解什么是XOR就好。
	A XOR B = (A+B)%进制。
	如果是10进制，7 XOR 8 = (7+8)%10 = 5
	一种思想就是把二进制XOR改成三进制XOR就好

	所谓single number，其实就是bit统计
	你可以按照 bit by bit 统计
	single number II，你可以把bit加到一起
	所有number第一bit的sum
	所有number第二bit的sum...
	然后sum%3 (bit by bit) 就是结果...
     */