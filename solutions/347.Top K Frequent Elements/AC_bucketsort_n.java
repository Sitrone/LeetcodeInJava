public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
	    //获得数组中元素，频率，存入map
	    for (int n : nums) {
	        frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
	    }

	    // 新建大小为n+1数组，下标为频次，相同频次放入一个下标的list中
	    List<Integer>[] bucket = new ArrayList[nums.length + 1];
	    for (int key : frequencyMap.keySet()) {
	        int frequency = frequencyMap.get(key);
	        if (bucket[frequency] == null) {
	            bucket[frequency] = new ArrayList<>();
	        }
	        bucket[frequency].add(key);
	    }

	    // 取出结果
	    List<Integer> res = new ArrayList<Integer>();
	    for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
	        if (bucket[pos] != null) {
	            res.addAll(bucket[pos]);
	        }
	    }
	    return res;
    }
}