public class LC49GroupAnagrams {
	/**
	 * Need a helper function to validate anagram (using HashMap)
	 * 
	 */
	class HashMapSolution {
	    public List<List<String>> groupAnagrams(String[] strs) {
	        if (strs == null || strs.length == 0) {
	            return new ArrayList<>();
	        }
	        Map<String, List<String>> map = new HashMap<>();
	        int[] count = new int[26];
	        for (String word : strs) {
	            Arrays.fill(count, 0);
	            for (char ch : word.toCharArray()) {
	                count[ch - 'a']++;
	            }
	            StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < 26; i++) {
	                sb.append('#');
	                sb.append(count[i]);
	            }
	            String key = sb.toString();
	            if (!map.containsKey(key)) {
	                map.put(key, new ArrayList<>());
	            }
	            map.get(key).add(word);
	        }
	        return new ArrayList(map.values());
	    }
	}
}