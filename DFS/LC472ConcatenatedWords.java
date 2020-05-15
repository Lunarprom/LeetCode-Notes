public class LC472ConcatenatedWords {
    /**
     * 当时被问用Trie跟直接用HashMap有啥不一样的时候我被问住了。。。
     * 理由应该是说Trie的话省去了查找相同prefix的时间。而且记住每搜到一个单词之后的搜索都应该从root再开始去找别的单词）
     * 这道题也可以用DP+memoization来做，跟Word Break系列题目也有共通之处。
     * 时间复杂度: 
     *  Build Trie Tree takes O(N) 即字典中所有字符的数量
     *  DFS: O(M ^ L) M是单词的个数，L是单词的长度
     * 空间复杂度: 
     *  Trie Tree takes O(N) 每次递归调用O(L) L为当前字符长度    
     */
    class TrieTreeSolution {
    
        TrieNode trie;
        
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            List<String> result = new ArrayList<>();
            trie = new TrieNode();
            for (String word : words) {
                if (word.length() > 0) {
                    trie.insert(word, 0);
                }
            }
            for (String word : words) {
                if (word.length() == 0) {
                    continue;
                }
                
                if (trie.children.containsKey(word.charAt(0)) && dfs(word, 0, 0)) {
                    result.add(word);
                }
            }
            return result;
        }
        
        private boolean dfs(String word, int index, int count) {
            if (index == word.length()) {
                return count > 1;
            }
            
            TrieNode currNode = trie;
            for (int i = index; i < word.length(); i++) {
                if (!currNode.children.containsKey(word.charAt(i))) {
                    return false;
                }
                currNode = currNode.children.get(word.charAt(i));
                if (currNode.isWord) {
                    if (dfs(word, i + 1, count + 1)) {
                        return true;
                    }
                }
            }
            
            return false;
        }
        
        private class TrieNode {
            Map<Character, TrieNode> children;
            boolean isWord;

            public TrieNode() {
                this.children = new HashMap<>();
                this.isWord = false;
            }

            public void insert(String s, int index) {
                if (index == s.length()) {
                    this.isWord = true;
                    return;
                }
                char curr = s.charAt(index);
                if (!children.containsKey(curr)) {
                    children.put(curr, new TrieNode());
                }
                children.get(curr).insert(s, index + 1);
            }
        }
    }
}