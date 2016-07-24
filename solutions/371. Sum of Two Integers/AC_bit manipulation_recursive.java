	/**
	 * 1、异或操作求的结果
	 * 2、与操作模拟进位
	 *
	 */
public class Solution {
    public int getSum(int a, int b) {
        int result = a ^ b; 
        int carry = (a & b) << 1;
        if (carry != 0) {
            return getSum(result, carry);
        }
        return result;
    }
}