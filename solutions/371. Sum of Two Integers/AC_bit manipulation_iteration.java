	/**
	 * 1、异或操作求的结果
	 * 2、与操作模拟进位
	 *
	 */
public class Solution {
    public int getSum(int a, int b) {
		int result, carry;
        do{
			result = a ^ b; 
			carry = (a & b) << 1;
			a = result;
			b = carry;
		}while(carry != 0);
		
        return result;
    }
}