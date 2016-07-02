public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
	    //���������Ԫ�أ�Ƶ�ʣ�����map
	    for (int n : nums) {
	        frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
	    }

	    // �½���СΪn+1���飬�±�ΪƵ�Σ���ͬƵ�η���һ���±��list��
	    List<Integer>[] bucket = new ArrayList[nums.length + 1];
	    for (int key : frequencyMap.keySet()) {
	        int frequency = frequencyMap.get(key);
	        if (bucket[frequency] == null) {
	            bucket[frequency] = new ArrayList<>();
	        }
	        bucket[frequency].add(key);
	    }

	    // ȡ�����
	    List<Integer> res = new ArrayList<Integer>();
	    for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
	        if (bucket[pos] != null) {
	            res.addAll(bucket[pos]);
	        }
	    }
	    return res;
    }
}