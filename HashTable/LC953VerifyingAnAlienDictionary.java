public class LC953VerifyingAnAlienDictionary {
    /**
     * 只需要比较第一次出现不同的位置即可。
     * Runtime: 1 ms, faster than 41.92% of Java online submissions for Verifying an Alien Dictionary.
     * Memory Usage: 39.2 MB, less than 7.69% of Java online submissions for Verifying an Alien Dictionary.
     */
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            Map<Character, Integer> orderMap = new HashMap<>();
            for (int i = 0; i < order.length(); i++) {
                orderMap.put(order.charAt(i), i);
            }
            for (int i = 0; i < words.length - 1; i++) {
                if (!inOrder(words[i], words[i + 1], orderMap)) {
                    return false;
                }
            }
            return true;
        }
        
        private boolean inOrder(String word1, String word2, Map<Character, Integer> orderMap) {
            int count = Math.min(word1.length(), word2.length());
            for (int i = 0; i < count; i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    return !(orderMap.get(word1.charAt(i)) > orderMap.get(word2.charAt(i)));
                }
                continue;
            }
            return !(word1.length() > word2.length());
        }
    }
}