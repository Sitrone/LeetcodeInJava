	public static int[] countBits(int num)
	{
		int[] result = new int[num + 1];
		
		for(int i = 0; i <= num; i++)
		{
			result[i] = countBit(i);
		}
		return result;
	}
	
	private static int countBit(int num)
	{
		int count = 0;
		
		if(num == 0)
		{
			return 0;
		}
		while(num != 0)
		{
			count += num & 1;
			num = num >> 1;
		}
		
		return count;
	}