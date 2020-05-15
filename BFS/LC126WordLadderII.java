public class LC126WordLadderII {
	/**
	 * 一看到要求all路径/组合就知道这道题该用DFS啦
	 * BFS + DFS 双向搜索:
	 * 1. 先做BFS，找到每个单词从startWord 开始的长度，并且建立每个单词到其他邻接单词的无向图。（单向+双向均可。面试的时候求写代码速度所以先把单向BFS搞出来也未尝不可）
	 * 2. 再做DFS，在规定的最短长度内找到有效路径
	 * 
	 */
	class Solution {
	    
	    List<List<String>> result;
	    
	    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
	        result = new ArrayList<>();
	        Set<String> dict = new HashSet<>(wordList);
	        if (!dict.contains(endWord)) {
	            return result;
	        }
	        Map<String, Set<String>> neighborsMap = new HashMap<>();
	        Map<String, Integer> distances = new HashMap<>();
	        bfs(beginWord, endWord, dict, neighborsMap, distances);
	        dfs(beginWord, endWord, dict, distances, neighborsMap, new ArrayList<>());
	        
	        return result;
	    }
	    
	    private void dfs(
	        String curr, 
	        String endWord, 
	        Set<String> dict, 
	        Map<String, Integer> distances, 
	        Map<String, Set<String>> neighbors,
	        List<String> path) {
	        path.add(curr);
	        if (endWord.equals(curr)) {
	            result.add(new ArrayList<>(path));
	        } else {
	            Set<String> currNeighbors = neighbors.get(curr);
	            for (String next : currNeighbors) {
	                if (distances.get(next) == distances.get(curr) + 1) {
	                    dfs(next, endWord, dict, distances, neighbors, path);
	                }
	            }
	        }
	        path.remove(path.size() - 1);
	    }
	    
	    private void bfs(
	        String beginWord, 
	        String endWord, 
	        Set<String> dict, 
	        Map<String, Set<String>> neighborMap,
	        Map<String, Integer> distances) {
	        Queue<String> queue = new LinkedList<>();
	        queue.offer(beginWord);
	        distances.put(beginWord, 0);
	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            
	            boolean findEnd = false;
	            for (int i = 0; i < size; i++) {
	                String curr = queue.poll();
	                int currDist = distances.get(curr);
	                Set<String> neighbors = getNeighbors(curr, dict);
	                if (!neighborMap.containsKey(curr)) {
	                    neighborMap.put(curr, neighbors);
	                }
	                for (String next : neighbors) {
	                    if (distances.containsKey(next)) {
	                        continue; // the word is already visited. Skipping.
	                    }
	                    distances.put(next, currDist + 1);
	                    if (endWord.equals(next)) {
	                        findEnd = true;
	                    } else {
	                        queue.offer(next);
	                    }
	                }
	                if (findEnd) {
	                    break;
	                }
	            }
	        }
	        
	        return;
	    }
	    
	    private Set<String> getNeighbors(String word, Set<String> dict) {
	        Set<String> result = new HashSet<>();
	        char[] chs = word.toCharArray();
	        
	        for (int i = 0; i < chs.length; i++) {
	            for (char c = 'a'; c <= 'z'; c++) {
	                if (chs[i] == c) continue;
	                char t = chs[i];
	                chs[i] = c;
	                String target = String.valueOf(chs);
	                if (dict.contains(target)) result.add(target);
	                chs[i] = t;
	            }
	        }
	        
	        return result;
	    }
	}
}