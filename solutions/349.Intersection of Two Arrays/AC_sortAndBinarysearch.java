public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    /**
     * ÅÅĞò + ¶ş·Ö·¨
     */
    	Arrays.sort(nums1);
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i = 0; i < nums2.length; i++){
        	if(binarySearch(nums1, nums2[i]) >= 0){
        		set.add(nums2[i]);
        	}
        }
    	int[] res = new int[set.size()];
    	int k = 0;
    	for(int num:set)
    		res[k++] = num;
    	return res;
    }
    
    /**
     * BinarySearch
     * 
     */
    private int binarySearch(int[] a, int key){
    	int low = 0;
    	int high = a.length -1;
    	
    	while(low <= high){
    		int mid = low + (high - low) / 2;
    		if(a[mid] < key){
    			low = mid + 1;
    		}else if(a[mid] > key){
    			high = mid -1;
    		}else{
    			return mid;
    		}
    	}
    	return -1;
    }
}