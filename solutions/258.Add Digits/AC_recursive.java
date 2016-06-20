public class Solution {
    public int addDigits(int num) {
        int temp = 0;
        if(num < 10){
            return num;
        }
        while(num >=10){
            temp += num % 10;
            num /= 10;
        }
        if((temp + num) > 9)
        {
        	return addDigits(temp + num);
        }else
        {
        	return temp + num;
        }
    }
}