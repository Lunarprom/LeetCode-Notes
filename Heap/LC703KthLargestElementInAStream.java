public class LC703KthLargestElementInAStream {
	// 第K大也就是size为K的
	class KthLargest {

	    PriorityQueue<Integer> pq;
	    int capacity = 0;
	    
	    public KthLargest(int k, int[] nums) {
	        pq = new PriorityQueue<>(k);
	        capacity = k;
	        for (int num : nums) {
	            add(num);
	        }
	    }
	    
	    public int add(int val) {
	        if (pq.size() < capacity) {
	            pq.add(val);
	        } else if (val > pq.peek()) {
	            pq.remove();
	            pq.add(val);
	        }
	        
	        return pq.peek();
	    }
	}

	/**
	 * Your KthLargest object will be instantiated and called as such:
	 * KthLargest obj = new KthLargest(k, nums);
	 * int param_1 = obj.add(val);
	 */
}