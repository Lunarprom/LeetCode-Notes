public class LC17LetterCombinationOfAPhoneNumber {
	/**
	 * DFS + backtracking.
	 * Runtime: 1 ms, faster than 79.19% of Java online submissions for Letter Combinations of a Phone Number.
	 * Memory Usage: 39.9 MB, less than 6.16% of Java online submissions for Letter Combinations of a Phone Number.
	 * Further optimization: what if the words have to be valid according to a dictionary: use Trie tree.
	 */ 
	class NaiveBacktrackingSolution {
	    Map<Character, String> dict = new HashMap<Character, String>() {{
	        put('2', "abc");
	        put('3', "def");
	        put('4', "ghi");
	        put('5', "jkl");
	        put('6', "mno");
	        put('7', "pqrs");
	        put('8', "tuv");
	        put('9', "wxyz");
	    }};
	    
	    public List<String> letterCombinations(String digits) {
	        List<String> result = new ArrayList<String>();
	        if (digits == null || digits.length() == 0) {
	            return result;
	        }
	        helper(digits, result, "");
	        
	        return result;                                            
	    }
	    
	    private void helper(String digits, List<String> result, String perm) {
	        if (digits.length() == 0) {
	            result.add(new String(perm));
	            return;
	        }
	        Character digit = digits.charAt(0);
	        String letters = dict.get(digit);
	        for (int i = 0; i < letters.length(); i++) {
	            String letter = letters.substring(i, i+1);
	            helper(digits.substring(1), result, perm + letter);
	        }
	    }
	}
}