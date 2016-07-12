	/**
	 * 
	 * 1、暴力求解，同求2的幂次，可以演化为求解为n的幂次
	 *
	 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0 )
    		return false;
        while(n%3 == 0)
        	n /= 3;
        if(n == 1)
        	return true;
        else
        	return false;
    }
}