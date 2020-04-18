public class LC290WordPattern {
	/**
	 * Words are already split by space in the String. Use HashTable to store the mapping relationship.
	 * Optimization: use a Set to maintain the words that are already mapped to a char.
	 */
	class Solution {
	    public boolean wordPattern(String pattern, String str) {
	        if (pattern.length() > str.length()) {
	            return false;
	        }
	        Map<Character, String> map = new HashMap<>();
	        Set<String> set = new HashSet<>();
	        String[] words = str.split(" ");
	        if (pattern.length() != words.length) {
	            return false;
	        }
	        for (int i = 0; i < pattern.length(); i++) {
	            char c = pattern.charAt(i);
	            
	            if (!map.containsKey(c)) {
	                if (set.contains(words[i])) {
	                    return false;
	                }
	                map.put(c, words[i]);
	                set.add(words[i]);
	            } else {
	                if (!words[i].equals(map.get(c))) {
	                    return false;
	                }
	            }
	        }
	        
	        return true;
	    }
	}
}