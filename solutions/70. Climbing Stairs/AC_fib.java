	/**
	 * f(n) = f(n -1) + f(n - 2),斐波那契数列的变形应用，
	 * 扩展：如果每次可以跳1、2... n-1、n阶乘，如果有n阶楼梯，有多少种跳法
	 * @param n
	 * @return
	 */
    public static int climbStairs(int n) {
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        
        int one = 1, two = 2;
        while(n-- > 1){
            int temp = one + two;
            one = two;
            two = temp;
        }
        return one;
    }