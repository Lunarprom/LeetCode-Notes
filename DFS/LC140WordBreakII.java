public class LC140WordBreakII {
	/**
	 * Memoized DFS
	 * Time complexity: O(2^N) while N is the length of the Strings. Considering the worst case string = "aaaaaaa" and every prefix of the string is in the dictionary, the list of string the algorithm desires is basically generating all combinations of the space existence between any two characters. So it is at least O(2^N) because you need at least 2^n strings in the result list. 
	 * In this case, space complexity is also O(2^N) for the recursion stack.
	 */
	class MemoizedDFSSolution {
	    public List<String> wordBreak(String s, List<String> wordDict) {
	        return dfs(s, wordDict, new HashMap<String, List<String>>());
	    }
	    
	    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> memo) {
	        if (memo.containsKey(s)) {
	            return memo.get(s);
	        }
	        List<String> result = new ArrayList<>();
	        for (String word : wordDict) {
	            if (s.startsWith(word)) {
	                String substring = s.substring(word.length());
	                if (substring.length() == 0) {
	                    result.add(word);
	                } else {
	                    List<String> nextWords = dfs(substring, wordDict, memo);
	                    for (String nextWord : nextWords) {
	                        result.add(word + " " + nextWord);
	                    }
	                }
	            }
	        }
	        
	        memo.put(s, result);
	        return result;
	    }
	}
}