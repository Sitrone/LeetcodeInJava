	/**
	 * 1、考虑空格；  2、考虑正负数； 3、考虑越界
	 * 
	 *
	 */
public class Atoi {
    public static int myAtoi(String str) {
        if(str.length() < 1 || str.equals(null)){
        	return 0;
        }
        str = str.replace(" ", "");
        int i = 0;
        char flag = '+';
        if(str.charAt(0) == '-'){
        	flag = '-';
        	i++;
        }else if(str.charAt(0) == '+'){
        	flag = '+';
        	i++;
        }
        
        double result = 0;
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
        	result = result * 10 + (str.charAt(i) - '0');
        	i++;
        }
        
        if(flag == '-'){
        	result = -result;
        }
        if(result > Integer.MAX_VALUE){
        	return Integer.MAX_VALUE;
        }
        if(result < Integer.MIN_VALUE){
        	return Integer.MIN_VALUE;
        }
        
        return (int)result;
    }
}
