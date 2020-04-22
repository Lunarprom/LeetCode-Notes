public class LC692TopKFrequentWords {
	/**
	 * Similar to Top K Frequent Numbers. Only difference is to use compareTo() method on word1 and word2 so the one with lower lexical order will be polled first.
	 * Runtime: 4 ms, faster than 99.64% of Java online submissions for Top K Frequent Words.
	 * Memory Usage: 39.7 MB, less than 41.07% of Java online submissions for Top K Frequent Words.
	 */
	class PriorityQueueSolution {
	    public List<String> topKFrequent(String[] words, int k) {
	        List<String> result = new ArrayList<>();
	        if (words == null || words.length == 0) {
	            return result;
	        }
	        Map<String, Integer> map = new HashMap<>();
	        for (String word : words) {
	            int freq = map.getOrDefault(word, 0) + 1;
	            map.put(word, freq);
	        }
	        
	        PriorityQueue<String> pq = new PriorityQueue<String>(k, new Comparator<String>() {
	            @Override
	            public int compare(String word1, String word2) {
	                return map.get(word2) == map.get(word1) 
	                    ? word1.compareTo(word2) : map.get(word2) - map.get(word1);
	            }
	        });
	        for (String word : map.keySet()) {
	            pq.offer(word);
	        }
	        for (int i = 0; i < k; i++) {
	            result.add(pq.poll());
	        }
	        
	        return result;
	    }
	}
}