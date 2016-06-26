public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	
    	HashSet<Integer> set=new HashSet<Integer>(); 
    	int i = 0, j = 0;
    	while(i < nums1.length && j < nums2.length){
    		if(nums1[i] < nums2[j])
    			i++;
    		else if(nums1[i] > nums2[j])
    			j++;
    		else{
    			set.add(nums1[i]);
    			i++; 
    			j++;
    		}
    	}
    	int[] res = new int[set.size()];
    	int k = 0;
    	for(int num:set)
    		res[k++] = num;
    	return res;
    }
}