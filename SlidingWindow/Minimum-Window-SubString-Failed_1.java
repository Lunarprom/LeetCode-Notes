class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length() || t.length() == 0 || s.length() == 0) {
            return "";
        }
        
        // Initialization
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> mapT = new HashMap<Character, Integer>();
        for (int i = 0; i < charT.length; i++) {
            char key = charT[i];
            mapT.put(key, mapT.getOrDefault(key, 0) + 1);
        }
        
        // Searching for the first window;
        int fast = 0;
        int slow = 0;
        for (int i = 0; i < charS.length; i++) {
            char cur = charS[i];
            if (mapT.get(cur) != null) { // Why FindBugs doesn't like calling containsKey() before get()
                mapT.put(cur, mapT.get(cur) - 1); // 如果字符match了就从map value里减去1
            }
            // 如果字符不match的话就接着往前走，i.e. fast挪到当前的i；
            fast = i;
            // 然后每次挪了fast都做一下检查看看当前是否所有的字符都找到了。
            // 如果还没找到，就继续循环
            if (!allCharFound(mapT)) {
                continue;
            }
            while (allCharFound(mapT)) {
                // 如果找到了，就计算当前的最小长度；
                minLength = Math.min(minLength, i - slow + 1);
                // 挪动右指针，更新mapT，然后再判断是否allCharFound
                updateMap(mapT, charS[slow++]);
            }
        }
        
        // Another corner case: such substring doesn't exist
        if (minLength > s.length()) {
            return "";
        }
        // should be slow - 1 instead of slow??? 因为slow - 1才是实际上的minLeft(因为二者之间关系相对固定所以其实没必要多assign一个变量)
        return s.substring(slow - 1, slow + minLength - 1);
    }
    
    private void updateMap(Map<Character, Integer> mapT, char curChar) {
        if (mapT.get(curChar) != null) {
            mapT.put(curChar, mapT.get(curChar) + 1);
        }
    }
    
    private boolean allCharFound(final Map<Character, Integer> mapT) {
        for (Map.Entry entry : mapT.entrySet()) {
            Integer value = (Integer) entry.getValue();
            if (0 < value) {
                return false;
            }
        }
                
        return true;
    }
}