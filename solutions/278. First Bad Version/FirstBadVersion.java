package leetcode;

public class FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isBadVersion(int version){
		return false;
	}

	// ����˳�ѭ��ʱ��hָ��С��Ŀ��ĵ㣬lָ�����Ŀ��ĵ㣬�����һ������version�ϴ����Է���l
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
