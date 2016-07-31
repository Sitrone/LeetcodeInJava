	/**
	 * 找规律，最简单的方法就是多试几个数，发现规律，然后归纳
	 * 
	 *
	 */
public class IntegerBreak {
    public static int integerBreak(int n) {
        int result = 0;
        if(n == 1) return 1;
        if(n >= 2 && n <= 3) return n - 1;
        
        if(n >= 4 && n < 59){
            if(n % 3 == 1)
                result = (int) (Math.pow(3, n / 3 - 1) * 4);
            else if(n % 3 == 0)
                result = (int) Math.pow(3, n / 3);
            else
                result = (int) (Math.pow(3, n / 3) * 2);
        }
        return result;
    }
}