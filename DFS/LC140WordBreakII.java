public class LC140WordBreakII {
	/**
	 * Memoization+DFS
	 * Runtime: 11 ms, faster than 48.64% of Java online submissions for Word Break II.
	 * Memory Usage: 40 MB, less than 16.40% of Java online submissions for Word Break II.
	 */
	class Solution {
	    public List<String> wordBreak(String s, List<String> wordDict) {
	        List<String> result = new ArrayList<>();
	        if (s == null || s.length() == 0) {
	            return result;
	        }
	        Set<String> dict = new HashSet<String>(wordDict);
	        Map<String, List<String>> memo = new HashMap<>();
	        return helper(s, dict, memo);
	    }
	    
	    private List<String> helper(String s,
	                                Set<String> dict,
	                                Map<String, List<String>> memo) {
	        if (memo.containsKey(s)) {
	            return memo.get(s);
	        }
	        List<String> result = new ArrayList<>();
	        if (s.length() == 0) {
	            return result;
	        }
	        if (dict.contains(s)) {
	            result.add(s);
	        }
	        for (int i = 1; i < s.length(); i++) {
	            String word = s.substring(0, i);
	            if (!dict.contains(word)) {
	                continue;
	            }
	            String suffix = s.substring(i);
	            List<String> sufSegments = helper(suffix, dict, memo);
	            for (String segment : sufSegments) {
	                result.add(word + " " + segment);
	            }
	        }
	        
	        memo.put(s, result);
	        return result;
	    }
	}
}