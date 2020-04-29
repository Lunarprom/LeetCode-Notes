public class LC839SimilarStringGroups {
	/**
	 * Standard Union Find Solution. Time complexity is O(N^2*L), N is the length of A, L is the length of each String.
	 */
	class UnionFindSolution {
	    public int numSimilarGroups(String[] A) {
	        // remove duplication
	        Set<String> wordSet = new HashSet<String>(Arrays.asList(A));
	        A = wordSet.toArray(new String[wordSet.size()]);
	        UnionFind uf = new UnionFind(A.length);
	        
	        for (int i = 0; i < A.length - 1; i++) {
	            for (int j = 1; j < A.length; j++) {
	                if (isSimilar(A[i], A[j])) {
	                    uf.union(i, j);
	                }
	            }
	        }
	        
	        return uf.roots;
	    }
	    
	    private boolean isSimilar(String word1, String word2) {
	        if (word1 == null && word2 == null) {
	            return true;
	        }
	        if (word1.length() != word2.length()) {
	            return false;
	        }
	        int diff = 0;
	        for (int i = 0; i < word1.length(); i++) {
	            if (word1.charAt(i) != word2.charAt(i)) {
	                diff++;
	            }
	        }
	        
	        return diff <= 2;
	    }
	    
	    private class UnionFind {
	        int[] parent;
	        int roots;
	        
	        public UnionFind(int size) {
	            this.parent = new int[size];
	            this.roots = size;
	            for (int i = 0; i < size; i++) {
	                parent[i] = i;
	            }
	        }
	        
	        public void union(int p, int q) {
	            int rootP = find(p);
	            int rootQ = find(q);
	            if (rootP != rootQ) {
	                parent[rootP] = rootQ;
	                roots--;
	            }
	            
	            return;
	        }
	        
	        public int find(int p) {
	            while (parent[p] != p) {
	                p = parent[parent[p]];
	            }
	            
	            return p;
	        }
	    }
	}
}