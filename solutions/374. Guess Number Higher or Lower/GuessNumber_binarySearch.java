package leetcode;

public class GuessNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 典型的最基本的二分搜索
    public static int guessNumber(int n) {
        int l = 1, h = n;
        while(l <= h){
        	int mid = l + ((h - l) >> 1);
        	int g = guess(mid);
        	if(g == 0){
        		return mid;
        	}else if(g == 1){
        		l = mid + 1;
        	}else{
        		h = mid - 1;
        	}
        }
        return -1;
    }
}
