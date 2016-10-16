package leetcode;

public class MySqrt {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(newton(7));
	}
	
	/** 
	 * 二分查找
	 * @param x
	 * @return
	 */
    public static int mySqrt(int x) {
    	if(x < 0){
    		return 0;
    	}
    	if(x <= 1){
    		return x;
    	}
        long low = 0 , high = x / 2;
        while(low <= high){
            long mid = low + (high - low) / 2;
    		if (mid * mid == x)
    			return (int) mid;
    		else if (mid * mid < x)
    			low = mid + 1;
    		else
    			high = mid - 1;
        }
        return (int)high;
    }
    
    // 牛顿法，可参见SICP 1.1.7 节
    public static int newton(int x){
    	double guess = 1;
    	while(Math.abs(Math.pow(guess, 2) - x) >= 1){
    		guess = (x / guess + guess) / 2;
    	}
    	return (int) guess;
    }
}
