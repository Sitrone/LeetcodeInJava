	/**
	 * 1. 找规律题
	 * 2. 开关操作次数为奇数次的最后为打开状态，即公约数有奇数个，也即只有完全平方数有奇数个公约数
	 * 3  再简化推到可知为开方盏灯
	 */
public class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}