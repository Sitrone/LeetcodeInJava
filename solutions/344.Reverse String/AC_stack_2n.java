 /*
 * @author codergoose
 * @Time  2016-6-18
 * 
 */
public static String reverseString(String s) {
	Stack<Character> stack = new Stack<>();
	char[] ch = s.toCharArray();

	String result = "";
	for (int i = 0; i < s.length(); i++) {
		stack.push(ch[i]);
	}
	for (int j = 0; j < s.length(); j++) {
		result += stack.pop();
		}
	return result;
}