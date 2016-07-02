public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num : nums){
		    map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> pq = 
				new PriorityQueue<>(k,
                        // 大顶堆
                        new Comparator<Map.Entry<Integer, Integer>>() {
                           public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
                                return o2.getValue().compareTo(o1.getValue());
                            }});
		//遍历装入pq
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			pq.offer(entry);
		}
		
		//出列前k个
		List<Integer> res = new ArrayList<Integer>();
		for(int i = 0 ; i < k; i++){
			res.add(pq.poll().getKey());
		}
		return res;
    }
}