package leetcode;

public class AddStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addStrings("99999", "11"));
	}

	/**
	 * 大数相加
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String addStrings(String num1, String num2) {
		int sum = 0, carry = 0;
		StringBuilder sb = new StringBuilder();

		int i = num1.length() - 1, j = num2.length() - 1;
		while (i >= 0 || j >= 0) {
			if (i >= 0 && j >= 0) {
				sum = (int) (num1.charAt(i) - '0') + (int) (num2.charAt(j) - '0') + carry;
			} else if (i >= 0) {
				sum = (int) (num1.charAt(i) - '0') + carry;
			} else if (j >= 0) {
				sum = (int) (num2.charAt(j) - '0') + carry;
			}
			carry = sum / 10;
			sb.append(sum % 10);
			i--;
			j--;
		}
		if (carry == 1)
			sb.append("1");
		return sb.reverse().toString();
	}
}
