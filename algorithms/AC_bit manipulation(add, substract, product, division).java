	/**

	
	
	/**
	 * 1、加法，异或运算模拟加法操作，如果有进位，用与操作模拟
	 * https://leetcode.com/problems/sum-of-two-integers/
	 *
	 */
    public int getSum(int a, int b) {
        int result = a ^ b; 
        int carry = (a & b) << 1; 
        if (carry != 0) {
            return getSum(result, carry);
        }
        return result;
    }
    /**
     * a - b = a + (-b) = a + (~b + 1)
     * @param a
     * @param b
     * @return
     */
    public static int substract(int a, int b){
    	return add(a, negative(b));
    }

	    
    /**
     * 取反
     * @param a
     * @return
     */
    public static int negative(int a){
    	return add(~a, 1);
    }
    /**
     * 通过加法实现
     * 
     */
    public static int product(int a, int b){
    	boolean flag = a > 0 ? true : false;
    	if(!flag) a = negative(a);
    	int sum = 0;
    	
    	while(b-- != 0){
    		sum = add(a, sum);
    	}
    	if(!flag)
    		return negative(sum);
    	else
    		return sum;
    }
    
	/*
	*参考地址：http://www.kancloud.cn/digest/pieces-algorithm/163615
	* 目前还不能太理解？？？
	*/
    public static int product2(int a, int b){
    	boolean flag = b > 0 ? true : false;
    	if(!flag) b = ~b + 1;
    	int sum = 0;
    	
    	Map<Integer, Integer> bitMap = new HashMap<Integer, Integer>();
    	for(int i = 0; i < 32; i++){
    		bitMap.put(1 << i, i);
    	}
    	
    	while(b > 0){
            /*
            b & ~(b - 1)可以得到乘数b的二进制表示中最右侧1的位置
            last_bit记录被乘数a需要位移的位数
            */
    		int lastBit = bitMap.get(b & negative(b));
    		
    		sum += (a << lastBit);//将得到的乘法结果全部相加即为最后结果
    		b &= b - 1;//每次将b的二进制表示的最右侧1去掉用于下一次乘法
    	}
    	if(!flag)
    		return negative(sum);
    	else
    		return sum;
    }
	
