	/**
	 * 1、暴力求解；2、计算二进制中1的个数，个数为1则为2的幂次，否则不是
	 * 
	 *
	 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
			return false;
		}
		int num = 0;
		while(n != 0){
			num += n & 0X1;
			n >>= 1;
		}
		if(num == 1){
			return true;
		}
		return false;
    }
}