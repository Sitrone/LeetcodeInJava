/**
*����������⣬�ⷨһ��ֱ���ҹ�����⣬�ⷨ����ȫ���������������У��ӱ���ȡ����
*/

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        n = Math.min(10, n);
        int[] res = new int[n + 1];
        res[0] = 1;
        for(int i =1; i <= n; i++ ){
            res[i] = 9;
            for(int x = 9; x >= 9 - i + 2;x--){
                res[i] *= x;
            }
        }
        
        int ans = 0;
        for(int i = 0; i < res.length; i++){
            ans += res[i];
        }
        return ans;
    }
}

