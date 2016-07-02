/**
*排列组合问题，解法一，直接找规律求解，解法二，全部计算出来放入表中，从表中取数据
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

