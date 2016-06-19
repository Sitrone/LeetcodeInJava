	/*
	 * @author codergoose
	 * @Time  2016-6-18
	 * 
	 */
    public String reverseString(String s) {
    	char[] ch = s.toCharArray();
    	int len = s.length();
    	char temp;
    	for(int i = 0, j = len -1; i <=j; i++, j--)
    	{
    		temp = ch[i];
    		ch[i] = ch[j];
    		ch[j] = temp;
    	}
		return new String(ch);
    }