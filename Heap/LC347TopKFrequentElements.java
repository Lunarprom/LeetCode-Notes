public class LC347TopKFrequentElements {
	/**
	 * First instinct: Use a hash map to maintain the number-frequency relationship
	 * Design a class with number+frequency and sort by frequency
	 * Top k -> Need to reverse the comparator
	 * Runtime: 9 ms, faster than 87.12% of Java online submissions for Top K Frequent Elements.
	 * Memory Usage: 42.1 MB, less than 9.48% of Java online submissions for Top K Frequent Elements.
	 * 7 min bug free.
	 */
	class PriorityQueueSolution {
	    public int[] topKFrequent(int[] nums, int k) {
	        int[] result = new int[k];
	        if (nums == null || nums.length == 0) {
	            return result;
	        }
	        Map<Integer, Integer> map = new HashMap<>();
	        PriorityQueue<NumWithFreq> pq = new PriorityQueue<NumWithFreq>(k, new Comparator<NumWithFreq>() {
	            @Override
	            public int compare(NumWithFreq nwf1, NumWithFreq nwf2) {
	                return nwf2.freq - nwf1.freq;
	            }
	        });
	        for (int num : nums) {
	            int freq = map.getOrDefault(num, 0) + 1;
	            map.put(num, freq);
	        }
	        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	            NumWithFreq nwf = new NumWithFreq(entry.getKey(), entry.getValue());
	            pq.add(nwf);
	        }
	        for (int i = 0; i < k; i++) {
	            NumWithFreq nwf = pq.poll();
	            result[i] = nwf.num;
	        }
	        
	        return result;
	    }
	    
	    private class NumWithFreq {
	        int num;
	        int freq;
	        public NumWithFreq(int num, int freq) {
	            this.num = num;
	            this.freq = freq;
	        }
	    }
	}
}