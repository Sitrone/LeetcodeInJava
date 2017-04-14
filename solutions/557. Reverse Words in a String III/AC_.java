	/**
	 * 
	 * 
	 *
	 */
public class Solution {
	public String reverseWords(String s)
	{
		if (s == null || s.isEmpty())
		{
			return "";
		}
		String[] strs = s.split(" ");
		StringBuilder sb = new StringBuilder(s.length());
		for (int i = 0; i < strs.length; i++)
		{
			sb.append(reverseWord(strs[i])).append(" ");
		}
		return sb.toString().trim();
	}

	private String reverseWord(String s)
	{
		StringBuilder sb = new StringBuilder(s.length());
		return sb.append(s).reverse().toString();
	}
}