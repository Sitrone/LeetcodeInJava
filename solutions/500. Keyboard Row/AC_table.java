	/**
	 * 
	 * 打表法
	 *
	 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindWords
{
	private static final String first = "qwertyuiopQWERTYUIOP";
	private static final String second = "asdfghjklASDFGHJKL";
	private static final String third = "zxcvbnmZXCVBNM";

	public String[] findWords(String[] words)
	{
		List<String> list = new LinkedList<>();
		for (String word : words)
		{
			boolean isOneRow = true, isFirst = false, isSecond = false, isThird = false;

			if (first.indexOf(word.charAt(0)) != -1)
			{
				isFirst = true;
			}
			else if (second.indexOf(word.charAt(0)) != -1)
			{
				isSecond = true;
			}
			else if (third.indexOf(word.charAt(0)) != -1)
			{
				isThird = true;
			}
			else
			{
				continue;
			}

			for (char c : word.toCharArray())
			{
				if (isFirst)
				{
					if(first.indexOf(c) == -1)
					{
						isOneRow = false;
					}
				}
				else if (isSecond)
				{
					if(second.indexOf(c) == -1)
					{
						isOneRow = false;
					}
				}
				else
				{
					if(third.indexOf(c) == -1)
					{
						isOneRow = false;
					}
				}
			}
			if(isOneRow)
			{
				list.add(word);
			}
		}
		return list.toArray(new String[list.size()]);
	}
	
	public static void main(String[] args)
	{
		FindWords f = new FindWords();
		String[] arr = new String[]{"Hello", "Alaska", "Dad", "Peace"};
		System.out.println(Arrays.toString(f.findWords(arr)));
	}
}
