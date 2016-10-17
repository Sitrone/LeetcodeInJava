package leetcode;

public class IsSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "axc";
		String t = "ahbgdc";
		System.out.println(isSubsequence(s, t));
	}

	// Ë«Ö¸Õë
    public static boolean isSubsequence(String s, String t) {
    	int i = 0, j = 0;
        for(i = 0, j = 0; j < t.length() && i < s.length(); j++){
        	if(s.charAt(i) == t.charAt(j)){
        		i++;
        	}
        }
        if(i == s.length()){
        	return true;
        }
        return false;
    }
}
