public class LC438FindAllAnagramsInAString {
	/**
	 * Instinct solution:
	 * Use a Map to store all the Characters-Frequencies in p.
	 * Start scanning s, maintain a map to count the char-freq until the map is empty
	 * Once that's done, record the first index, and add the char-freq back to the temporary map.
	 * As soon as there is a char that does not belong to the map key set, jump to the char behind it.
	 * Avoid using == to compare wrapped type! (I am talking about the freaking Java Integer...)
	 * Runtime: 20 ms, faster than 37.84% of Java online submissions for Find All Anagrams in a String.
	 * Memory Usage: 40.8 MB, less than 10.00% of Java online submissions for Find All Anagrams in a String.
	 */
	class SlidingWindowSolution {
	    public List<Integer> findAnagrams(String s, String p) {
	        List<Integer> result = new ArrayList<>();
	        if (s == null || s.length() == 0 || s.length() < p.length()) {
	            return result;
	        }
	        Map<Character, Integer> mapP = new HashMap<>();
	        Map<Character, Integer> map = new HashMap<>();
	        int match = 0;
	        for (Character c : p.toCharArray()) {
	            mapP.put(c, mapP.getOrDefault(c, 0) + 1);
	        }
	        
	        int left = 0;
	        int right = 0;
	        for (; right < s.length(); right++) {
	            char rightChar = s.charAt(right);
	            if (mapP.containsKey(rightChar)) {
	                map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
	                if (map.get(rightChar).equals(mapP.get(rightChar))) {
	                    match++;
	                }
	            }
	            while (match == mapP.keySet().size()) {
	                // 如果长度不吻合，就一直把left往右挪到anagram起点
	                if (right - left + 1 == p.length()) {
	                    result.add(left);
	                }
	                // left char must exist in map keyset.
	                char leftChar = s.charAt(left);
	                if (mapP.containsKey(leftChar)) {
	                    map.put(leftChar, map.get(leftChar) - 1);
	                
	                    // 注意判断条件. mapP might not contain the character.
	                    if (map.get(leftChar) < mapP.get(leftChar)) {
	                        match--;
	                    }
	                }
	                left++;
	            }
	        }
	        
	        return result;
	    }
	}
}