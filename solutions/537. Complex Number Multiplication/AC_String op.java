	/**
	 * 
	 * 
	 *
	 */
public class Solution {
    public String complexNumberMultiply(String a, String b) {
		int x1, x2, y1, y2;
		String[] A = a.split("\\+");
		String[] B = b.split("\\+");
		
		x1 = Integer.valueOf(A[0]);
		x2 = Integer.valueOf(B[0]);
		y1 = Integer.valueOf(A[1].replace("i", ""));
		y2 = Integer.valueOf(B[1].replace("i", ""));
		
		int x1x2 = x1 * x2;
		int y1y2 = y1 * y2;
		int x1y2y1x2 = x1 * y2 + x2 * y1;
		
		String xfinal = x1x2 -y1y2 + "";
		String yfinal = x1y2y1x2 + "i";
		String res = xfinal + "+" + yfinal;
		return res;
    }
}