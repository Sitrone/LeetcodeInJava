package leecode;

import java.util.HashMap;

public class CanConstruct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "bdjijj";
		String b = "aifbigejbibiefgeffhabgeejdbiajgaahjefhdegafhfcigjaecbfiechadiehhfcejhhfbbdjheecfaijdba";
		System.out.println(canConstruct(a, b));
	}
	
	/**
	 *  TLE
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        boolean result = true;
        if(null == ransomNote && null == magazine){
        	return false;
        }
        for(int i = 0; i < magazine.length(); i++){
        	if(!map.containsKey(magazine.charAt(i))){
        		map.put(magazine.charAt(i), 1);
        	}else{
        		int count = map.get(magazine.charAt(i));
        		map.put(magazine.charAt(i), count + 1);
        	}
        }
        
        for(int j = 0; j < ransomNote.length(); j++){
        	if(map.containsKey(ransomNote.charAt(j))){
        		int count = map.get(ransomNote.charAt(j));
        		if(0 == count){
        			result = false;
        		}else{
        			map.put(ransomNote.charAt(j), count -1);
        		}
        	}else{
        		result = false;
        	}
        }
        return result;
    }

    public static boolean canConstruct1(String ransomNote, String magazine) {
        boolean result = true;

        for(int i = 0; i < ransomNote.length(); i++){
        	if(magazine.contains(String.valueOf(ransomNote.charAt(i)))){
        		int index = magazine.indexOf(ransomNote.charAt(i));
        		int endIndex = magazine.length();
        		magazine = magazine.substring(0, index) + magazine.substring(index + 1, endIndex);
        	}else{
        		result = false;
        	}
        }
        
        return result;
    }


    /**
     * 在看问题note，发现两个目标string都只包含contain only lowercase letters.
     * 故考虑直接用一维数组
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct2(String ransomNote, String magazine) {
    	boolean result = true;
    	
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
            	result =  false;
            }
        }
        return result;
    }

}
