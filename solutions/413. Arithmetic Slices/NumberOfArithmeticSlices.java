package leetcode;

public class NumberOfArithmeticSlices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] t = new int[]{1, 2, 3, 4, 5, 6};
		System.out.println(numberOfArithmeticSlices(t));
	}

	/**
	 * 找规律，a(3) = 1, a(4) = 3, a(5) = 6, a(6) = 10
	 * a(3) - a(2) = 1 - 0  = 1
	 * a(4) - a(3) = 3 - 1  = 2
	 * a(5) - a(4) = 6 - 3  = 3
	 * a(6) - a(5) = 10 - 6 = 4
	 * 结果差成等差数列
	 * @param A
	 * @return
	 */
    public static int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        int added = 0;

        for (int i = 2; i < A.length; i++)
            if (A[i - 1] - A[i] == A[i - 2] - A[i - 1])
                count += ++added;
            else 
                added = 0;

        return count;
    }
}
