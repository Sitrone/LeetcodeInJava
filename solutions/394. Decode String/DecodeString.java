package leetcode;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * StringBuilder sb = new StringBuilder("abcd"); sb.reverse();
		 * System.out.println(sb.toString()); int num = 1; while(num-- > 0){
		 * sb.append(sb); } System.out.println(sb.toString());
		 */

		String s = "2[abc]3[cd]ef";
		String t = "100[leetcode]";
		System.out.println(decodeString(s));
		
		System.out.println(evl("(1+((2+3)*(4*5)))"));

	}

	/**
	 * 双栈，一个栈装数字，一个栈装字符串
	 * @param s
	 * @return
	 */
	public static String decodeString(String s) {
		Stack<StringBuilder> strStack = new Stack<>();
		Stack<Integer> intStack = new Stack<>();

		StringBuilder cur = new StringBuilder("");
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[') {
				intStack.push(num);
				strStack.push(cur);
				cur = new StringBuilder("");
				num = 0;
			} else if (c == ']') {
				StringBuilder temp = cur;
				cur = strStack.pop();
				for (num = intStack.pop(); num > 0; --num){
					cur.append(temp);
				}
			} else if (Character.isDigit(c)) {
				num = num * 10 + c - '0';
			} else {
				cur.append(c);
			}
		}

		return cur.toString();
	}
	
	/**
	 * 同类体型，具体参见<算法4>
	 * Dijkstra的双栈算术表达式
	 * @param str
	 * @return
	 */
	public static Double evl(String str){
        Stack<Double> vals = new Stack<Double>();
        Stack<Character> op = new Stack<Character>();
        char[] ch = str.toCharArray();
        for(int i = 0;i < ch.length;i++){
            if(ch[i] == '+') op.push(ch[i]);
            else if(ch[i] == '-') op.push(ch[i]);
            else if(ch[i] == '*') op.push(ch[i]);
            else if(ch[i] == '/') op.push(ch[i]);
            else if(ch[i] == '(');
            else if(ch[i] == ')'){
                char o = op.pop();
                Double val = vals.pop();
                if(o == '+') val = val + vals.pop();
                else if(o == '-') val = vals.pop() - val;
                else if(o == '*') val = vals.pop() * val;
                else if(o == '/') val = vals.pop() / val;
                vals.push(val);
            }else{
                vals.push(Double.parseDouble(Character.toString(ch[i])));
            }
        }
        return vals.pop();
    }

}
