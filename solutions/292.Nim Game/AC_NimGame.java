public class Solution {
    public boolean canWinNim(int n) {
/*         if (n < 4)
            return true;
        else if(n == 4)
            return false;
        else if ((n > 4) && (n % 4 != 0)) 
            return true;
        else
            return false; */
		return n % 4 != 0;
    }
}