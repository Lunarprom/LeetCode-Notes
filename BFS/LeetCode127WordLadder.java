class LeetCode127WordLadder {

    class Solution1 {
        /**
         * Solution 1: Brute force BFS
         * Time: 1290ms
         */
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (beginWord == null || endWord == null || beginWord == endWord) {
                return 0;
            }
            
            Set<String> visited = new HashSet<String>();
            Queue<String> queue = new LinkedList<String>();
            // Add the first word to the queue;
            queue.offer(beginWord);
            int count = 0;
            while(!queue.isEmpty()) {
                count++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String current = queue.poll();
                
                    for (String word : wordList) {
                        if (visited.contains(word)) {
                            continue;
                        }
                        if (!isValid(current, word)) {
                            continue;
                        }
                        // Must first check whether the word is a valid ladder from the current word before checking it's the endWord.
                        if (endWord.equals(word)) {
                            return count + 1;
                        }
                        visited.add(word);
                        queue.offer(word); 
                    }
                }
            }
            return 0;
        }
    }

    class Solution2 {
        /**
         * Optimization from brute force BFS: visited
         * Runtime: 757 ms, faster than 15.74% of Java online submissions for Word Ladder.
         * Memory Usage: 40.2 MB, less than 77.37% of Java online submissions for Word Ladder.
         */
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (beginWord == null || endWord == null || beginWord == endWord) {
                return 0;
            }
            
            boolean[] visited = new boolean[wordList.size()];
            Queue<String> queue = new LinkedList<String>();
            // Add the first word to the queue;
            queue.offer(beginWord);
            int count = 0;
            while(!queue.isEmpty()) {
                count++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String current = queue.poll();
                
                    for (int j = 0; j < wordList.size(); j++) {
                        String word = wordList.get(j);
                        if (visited[j]) {
                            continue;
                        }
                        if (!isValid(current, word)) {
                            continue;
                        }
                        // Must first check whether the word is a valid ladder from the current word before checking it's the endWord.
                        if (endWord.equals(word)) {
                            return count + 1;
                        }
                        visited[j] = true;
                        queue.offer(word); 
                    }
                }
            }
            return 0;
        }
        
        
    }

    class Solution3 {
        /**
         * Bi-directional BFS
         * 用两个HashSet来存从两头向中间扫描的结果(why set not queue? -> de-duplicate)
         * Runtime: 1613 ms, faster than 5.01% of Java online submissions for Word Ladder.
         * Memory Usage: 41.9 MB, less than 49.64% of Java online submissions for Word Ladder.
         */
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (beginWord == null || endWord == null || beginWord == endWord) {
                    return 0;
            }
            // If the end word is not in the word list, then there is no valid path.
            if (wordList.indexOf(endWord) == -1) {
                return 0;
            }
            if (beginWord.equals(endWord)) {
                return 1;
            }
            Queue<String> queueA = new LinkedList<>();
            Set<String> setA = new HashSet<>();
            queueA.offer(beginWord);
            setA.add(beginWord);
            
            Queue<String> queueB = new LinkedList<>();
            Set<String> setB = new HashSet<>();
            queueB.offer(endWord);
            setB.add(endWord);
            
            Queue<String> temp = new LinkedList<>();
            int countA = 0;
            int countB = 0;
            while (!queueA.isEmpty() && !queueB.isEmpty()) {
                countA++;
                int sizeA = queueA.size();
                for (int i = 0; i < sizeA; i++) {
                    String current = queueA.poll();
                    for (int j = 0; j < wordList.size(); j++) {
                        String word = wordList.get(j);
                        if (setA.contains(word)) {
                            continue;
                        }
                        if (!isValid(word, current)) {
                            continue;
                        }
                        if (setB.contains(word)) {
                            return countA + countB + 1;
                        }
                        setA.add(word);
                        queueA.offer(word);
                    }
                }
                
                countB++;
                int sizeB = queueB.size();
                for (int i = 0; i < sizeB; i++) {
                    String current = queueB.poll();
                    for (int j = 0; j < wordList.size(); j++) {
                        String word = wordList.get(j);
                        if (setB.contains(word)) {
                            continue;
                        }
                        if (!isValid(word, current)) {
                            continue;
                        }
                        if (setA.contains(word)) {
                            return countA + countB + 1;
                        }
                        setB.add(word);
                        queueB.offer(word);
                    }
                }
            }
            
            return 0;
        }
    }
    class Solution4 {
        /**
         * Optimization4: Bi-directional BFS
         * 用两个HashSet来存从两头向中间扫描的结果(why set not queue? -> de-duplicate)
         * 总是先检查Set size小的那个
         * Runtime: 149 ms, faster than 29.11% of Java online submissions for Word Ladder.
         * Memory Usage: 39.9 MB, less than 83.21% of Java online submissions for Word Ladder.
         */
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (beginWord == null || endWord == null || beginWord == endWord) {
                    return 0;
            }
            // If the end word is not in the word list, then there is no valid path.
            if (wordList.indexOf(endWord) == -1) {
                return 0;
            }
            if (beginWord.equals(endWord)) {
                return 1;
            }
            Queue<String> queueA = new LinkedList<>();
            Set<String> setA = new HashSet<>();
            queueA.offer(beginWord);
            setA.add(beginWord);
            
            Queue<String> queueB = new LinkedList<>();
            Set<String> setB = new HashSet<>();
            queueB.offer(endWord);
            setB.add(endWord);

            int count = 0;
            // Always operate on the set whose size is smaller.
            while (!queueA.isEmpty() && !queueB.isEmpty()) {
                count++;
                if (queueA.size() > queueB.size()) {
                    Queue<String> tempQueue = queueA;
                    queueA = queueB;
                    queueB = tempQueue;
                    Set<String> tempSet = setA;
                    setA = setB;
                    setB = tempSet;
                }
                
                int sizeA = queueA.size();
                for (int i = 0; i < sizeA; i++) {
                    String current = queueA.poll();
                    for (int j = 0; j < wordList.size(); j++) {
                        String word = wordList.get(j);
                        if (setA.contains(word)) {
                            continue;
                        }
                        if (!isValid(word, current)) {
                            continue;
                        }
                        if (setB.contains(word)) {
                            return count + 1;
                        }
                        setA.add(word);
                        queueA.offer(word);
                    }
                }
            }
            
            return 0;
        }
    }

    class Solution {
        /**
         * 因为单词是由a~z这有限数量的字符组成的，可以遍历当前单词能转换成的所有单词，判断其是否包含在候选单词中。
         * 候选单词用HashSet保存，可以大大提高判断包含关系的性能。
         * Runtime: 44 ms, faster than 78.02% of Java online submissions for Word Ladder.
         * Memory Usage: 49.3 MB, less than 5.11% of Java online submissions for Word Ladder.
         */
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            int end = wordList.indexOf(endWord);
            if (end == -1) {
                return 0;
            }
            wordList.add(beginWord);
            
            // 从两端BFS遍历要用的队列
            Queue<String> queue1 = new LinkedList<>();
            Queue<String> queue2 = new LinkedList<>();
            // 两端已经遍历过的节点
            Set<String> visited1 = new HashSet<>();
            Set<String> visited2 = new HashSet<>();
            queue1.offer(beginWord);
            queue2.offer(endWord);
            visited1.add(beginWord);
            visited2.add(endWord);
            
            int count = 0;
            Set<String> allWordSet = new HashSet<>(wordList);

            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                count++;
                if (queue1.size() > queue2.size()) {
                    Queue<String> tmp = queue1;
                    queue1 = queue2;
                    queue2 = tmp;
                    Set<String> t = visited1;
                    visited1 = visited2;
                    visited2 = t;
                }
                int size1 = queue1.size();
                while (size1-- > 0) {
                    String s = queue1.poll();
                    char[] chars = s.toCharArray();
                    for (int j = 0; j < s.length(); ++j) {
                        // 保存第j位的原始字符
                        char c0 = chars[j];
                        for (char c = 'a'; c <= 'z'; ++c) {
                            chars[j] = c;
                            String newString = new String(chars);
                            // 已经访问过了，跳过
                            if (visited1.contains(newString)) {
                                continue;
                            }
                            // 两端遍历相遇，结束遍历，返回count
                            if (visited2.contains(newString)) {
                                return count + 1;
                            }
                            // 如果单词在列表中存在，将其添加到队列，并标记为已访问
                            if (allWordSet.contains(newString)) {
                                queue1.offer(newString);
                                visited1.add(newString);
                            }
                        }
                        // 恢复第j位的原始字符
                        chars[j] = c0;
                    }
                }
            }
            return 0;
        }
    }

    /**
     * Helper method to check whether the word is a valid ladder to the target.
     */
    private boolean isValid(String target, String word) {
        if (target.length() != word.length()) {
            return false;
        }
        
        int diff = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != word.charAt(i)) {
                diff++;
            }
        }
        
        return diff == 1;
    }
}