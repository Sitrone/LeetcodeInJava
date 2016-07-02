	/**
	 * 建立罗马数字对应整数的HashMap
	 * 从前向后遍历罗马数字，如果比前面数小，则加上该数。反之，减去前一个数的两倍然后加上该数
	 */
public class Solution {
    public int romanToInt(String s) {
        Character[] roman = new Character[]{
        		'I', 'V', 'X', 'L', 'C', 'D', 'M'
        		};
        int[] values = new int[]{
        		1, 5, 10, 50, 100, 500, 1000
        };
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < roman.length; i++){
        	map.put(roman[i], values[i]);
        }
        
        char[] target = s.toCharArray();
        int res = map.get(target[0]);
        for(int i = 1; i < s.length(); i++){
        	int pre = map.get(target[i - 1]);
        	int cur = map.get(target[i]);
        	
        	if(pre >= cur){
        		res += cur;
        	}else{
        		res += cur - 2 * pre;
        	}
        }
        return res;
    }
}