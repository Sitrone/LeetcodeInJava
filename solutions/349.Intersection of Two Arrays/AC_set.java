public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
    	HashSet<Integer> set2 = new HashSet<Integer>();
    	// 去重
    	for(int num:nums1)
    		set1.add(num);
    	for(int num:nums2)
    		set2.add(num);
    	set1.retainAll(set2);// 求交集
    	
        int[] result = new int[set1.size()];
        int cre = 0;
        for(int num:set1)
        	result[cre++] = num;
        
        return result;
    }
}