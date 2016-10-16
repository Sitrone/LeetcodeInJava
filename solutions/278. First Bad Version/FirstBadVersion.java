package leetcode;

public class FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isBadVersion(int version){
		return false;
	}

	// 最后退出循环时，h指向小于目标的点，l指向大于目标的点，这里第一个坏的version较大，所以返回l
    public static int firstBadVersion(int n) {
        int l = 1, h = n;
        while(l <= n){
        	int mid = l + ((h - l) >> 1);
        	if(isBadVersion(mid)){
        		h = mid - 1;
        	}else{
        		l = mid + 1;
        	}
        }
        return l;
    }
}
