package leetcode;

import java.util.Arrays;

public class IsAnagram {

	public static void main(String[] args){
		String s1 = "anagram";
		String s2 = "nagaram";
		System.out.println(isAnagram1(s1, s2));
		System.out.println(isAnagram2(s1, s2));
	}
	
	/**
	 * ≈≈–Ú∫Û±»Ωœ
	 * @param s
	 * @param t
	 * @return
	 */
    public static boolean isAnagram1(String s, String t) {
    	if(s.length() != t.length()){
    		return false;
    	}
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        
        Arrays.sort(cs);
        Arrays.sort(ct);
        
        return Arrays.equals(cs, ct);
    }
    
    public static boolean isAnagram2(String s, String t) {
    	if(s.length() != t.length()){
    		return false;
    	}
    	
    	int[] hashTable = new int[26];
    	for(char c : s.toCharArray()){
    		hashTable[c - 'a']++;
    	}
    	for(char c : t.toCharArray()){
    		hashTable[c - 'a']--;
    	}
    	
    	for(int i = 0; i < hashTable.length; i++){
    		if(0 != hashTable[i]){
    			return false;
    		}
    	}
    	return true;
    }
}
