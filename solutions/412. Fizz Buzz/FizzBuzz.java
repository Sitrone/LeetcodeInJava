package leecode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	
	public static void main(String ...str){
		System.out.println(fizzBuzz(15));
	}
	
    public static List<String> fizzBuzz(int n) {
    	List<String> result = new ArrayList<String>();
    	
        String fizz = "Fizz";
        String buzz = "Buzz";
        String fizzBuzz = "FizzBuzz";
        
        for(int i = 1; i < n + 1; i++){
        	if(i % 15 == 0){
        		result.add(fizzBuzz);
        	}else if(i % 3 == 0){
        		result.add(fizz);
        	}else if(i % 5 == 0){
        		result.add(buzz);
        	}else{
        		result.add(String.valueOf(i));
        	}
        }
        return result;
    }
}
