public class LintCode680SplitString {
	/**
	 * Standard backtracking solution
	 */
	public class Solution {
	    /*
	     * @param : a string to be split
	     * @return: all possible split string array
	     */
	    public List<List<String>> splitString(String s) {
	        List<List<String>> result = new ArrayList<>();
	        // if (s == null || s.length() == 0) {
	        //     return result;
	        // }
	        helper(s, result, new ArrayList<String>(), 0);
	        
	        return result;
	    }
	    
	    private void helper(String s, List<List<String>> result, List<String> combo, int start) {
	        if (start == s.length()) {
	            result.add(new ArrayList<String>(combo));
	            return;
	        }
	        
	        combo.add(s.substring(start, start + 1));
	        helper(s, result, combo, start + 1);
	        combo.remove(combo.size() - 1);
	        
	        if (start < s.length() - 1) {
	            combo.add(s.substring(start, start + 2));
	            helper(s, result, combo, start + 2);
	            combo.remove(combo.size() - 1);
	        }
	    }
	}
}