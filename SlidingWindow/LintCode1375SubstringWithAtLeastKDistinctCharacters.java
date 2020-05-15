public class LintCode1375SubstringWithAtLeastKDistinctCharacters {
	public class TwoPointersSolution {
	    /**
	     * @param s: a string
	     * @param k: an integer
	     * @return: the number of substrings there are that contain at least k distinct characters
	     */
	    public long kDistinctCharacters(String s, int k) {
	        long sCounter = 0;
	        if (s == null || s.length() == 0 || k <= 0) {
	            return sCounter;
	        }
	        int left = 0;
	        int right = 0;
	        int kCounter = 0;
	        int[] chars = new int[128];
	        while (left <= right && left < s.length()) {
	            while (kCounter < k && right < s.length()) {
	                char rightCh = s.charAt(right);
	                if (chars[rightCh] < 1) {
	                    kCounter++;
	                }
	                chars[rightCh]++;
	                right++;
	            }
	            if (kCounter >= k) {
	                sCounter += s.length() - right + 1; // 既然当前子串满足需求，则右指针往后的也全都满足需求
	            }
	            char leftCh = s.charAt(left);
	            if (chars[leftCh]-- == 1) {
	                kCounter--;
	            }
	            left++;
	        }
	        
	        return sCounter;
	    }
	}
}