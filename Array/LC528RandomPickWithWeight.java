public class LC528RandomPickWithWeight {
	/**
	 * 先根据概率求prefix sum，然后把生成的随机数往最近的正数靠？
	 * [1,2,3,4]
	 * [1,3,6,10]
	 * 不知道为什么随机数的选取不+1会导致OJ不通过。。。
	 */
	class Solution {
	    
	    int[] prefix;
	    Random rd;

	    public Solution(int[] w) {
	        rd = new Random();
	        prefix = new int[w.length];
	        prefix[0] = w[0];
	        for (int i = 1; i < w.length; i++) {
	            prefix[i] = w[i] + prefix[i - 1];
	        }
	    }
	    
	    public int pickIndex() {
	        int number = rd.nextInt(prefix[prefix.length - 1]) + 1; //???
	        int start = 0;
	        int end = prefix.length - 1;
	        while (start + 1 < end) {
	            int mid = start + (end - start) / 2;
	            if (prefix[mid] == number) {
	                return mid;
	            } else if (prefix[mid] < number) {
	                start = mid;
	            } else {
	                end = mid;
	            }
	        }
	        
	        if (prefix[start] >= number) {
	            return start;
	        } else {
	            return end;
	        }
	    }
	}

	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(w);
	 * int param_1 = obj.pickIndex();
	 */
}