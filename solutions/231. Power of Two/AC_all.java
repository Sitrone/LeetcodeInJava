	/*
	 * 进行操作最好避免对原数据进行更改
	 */
	public static boolean isPowerOfTwo(int n){
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
	
	/*
	 * 改进版，通过定义一个flag，移动flag来定位
	 */
	
	public static boolean isPowerOfTwo1(int n){
		if(n <= 0){
			return false;
		}
		int flag = 1, count = 0;
		while(flag != 0){
			if((n & flag) == flag){
				count++;
			}
			flag <<= 1;
		}
		if(count == 1)
			return true;
		else
			return false;
	}
	
	/*
	 * 常规方法(bf)，通过不断除以2
	 */
	public static boolean isPowerOfTwo2(int n){
    	if(n <= 0 )
    		return false;
        while(n%2 == 0)
        	n /= 2;
        if(n == 1)
        	return true;
        else
        	return false;
	}
	
	/*
	 * 利用n & (n -1) 可以去除n二进制最低位的1
	 */
	public static boolean isPowerOfTwo3(int n){
		if(n <= 0)
			return false;
		int count = 0;
		while(n != 0){
			n = n & (n -1);
			count++;
		}
		if(count == 1)
			return true;
		else
			return false;
	}