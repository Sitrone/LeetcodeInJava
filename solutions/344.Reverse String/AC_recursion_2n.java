	/*
	 * @author codergoose
	 * @Time  2016-6-18
	 * 
	 */
    public static String reverseString(String s) {
		int len = s.length();
		if (len <= 1)
			return s;
		String left = s.substring(0, len/2);
		String right = s.substring(len/2, len);
		return reverseString(right) +  reverseString(left);
    }