	/**
	 * 1、一个int型32为
	 * 2、26个小写字母可以使用字母相对a的便宜在整型中表示
	 *O(n^2)
	 */
public class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int mask[] = new int[len];//使用一个整数来放置words[i]中每个字母的在int型整数中出现的次数
        int max = 0;
        
        for(int i = 0; i < len; i++){
        	for(int j = 0; j < words[i].length(); j++){
        		mask[i] |=  1 << (words[i].toLowerCase().charAt(j)- 'a');
        	}
			
        	for(int k = 0; k < i; k++){
        		if((mask[i] & mask[k]) == 0){
        			 max = Math.max(max, words[i].length() * words[k].length()); 
        		}
        	}
        }
        return max;
    }
}