/**
 * 典型的求连通分量个数题目。DFS/BFS/UnionFind可解
 */
public class LeetCode547FriendCircles {
	class UnionFindSolution {
	    /**
	     * 用邻接矩阵来表示各点之间的连结关系
	     * 时间复杂度: O(N)
	     */
	    public int findCircleNum(int[][] M) {
	        if (M == null || M.length == 0 || M[0].length == 0 || M.length != M[0].length) {
	            return 0;
	        }
	        int n = M.length;
	        UnionFind uf = new UnionFind(n); // 在邻接矩阵中，结点个数其实就是矩阵的一边长
	        for (int i = 0; i < n; ++i) {
	            for (int j = i + 1; j < n; ++j) {
	                if (M[i][j] == 1) {
	                    uf.union(i, j);
	                }
	            }
	        }
	        
	        return uf.count;
	    }

	    private class UnionFind {
	        int count;
	        int parent[];
	        
	        public UnionFind(int n) {
	            this.count = n;
	            this.parent = new int[n];
	            for (int i = 0; i < n; i++) {
	                parent[i] = i;
	            }
	        }
	        
	        // 递归路径压缩的话应该返还的是父亲节点的的索引
	        // TODO：还可以进一步压缩，就是在查找的沿途把所有碰过的结点都指向p
	        private int find(int p) {
	            if (parent[p] != p) {
	                parent[p] = find(parent[p]); // 递归地找到父亲节点的父亲节点。。直到找到根
	            }
	            
	            return parent[p];
	        }
	        
	        public void union(int p, int q) {
	            int rootP = find(p);
	            int rootQ = find(q);
	            if (rootP == rootQ) {
	                return;
	            }
	            parent[rootP] = rootQ;
	            count--;
	        }
	    }
	}

	/**
 	 * BFS解法：对于每个node，只要value是1，就使用BFS来搜索
 	 * 优化:Only need to search for the upper half/lower half of the matrix since it is an adjacent matrix
 	 * Runtime: 1 ms, faster than 72.16% of Java online submissions for Friend Circles.
     * Memory Usage: 41 MB, less than 60.00% of Java online submissions for Friend Circles.
     */
	class BSFSolution {
	    public int findCircleNum(int[][] M) {
	        if (M == null || M.length == 0 || M[0].length == 0 || M.length != M[0].length) {
	            return 0;
	        }
	        int n = M.length;
	        boolean[] visited = new boolean[n];
	        int count = 0;
	        for (int i = 0; i < n; i++) {
	            if (!visited[i]) {
	                bfs(i, M, visited);
	                count++;
	            }
	        }
	        
	        return count;
	    }
	    
	    private void bfs(int student, int[][] M, boolean[] visited) {
	        Queue<Integer> queue = new LinkedList<>();
	        queue.offer(student);
	        visited[student] = true;
	        while (!queue.isEmpty()) {
	            int cur = queue.poll();
	            for (int j = 0; j < M.length; j++) { // 对于cur这一行，把所有的结点都刷一遍
	                if (!visited[j] && M[cur][j] == 1) { // 进入queue循环之后检查的是M[cur][j] (此时student这个参数已经无用了
	                    queue.offer(j);
	                    visited[j] = true;
	                }
	            }
	        }
	    }
	}

	/**
	 * DFS 解法: 把BFS的queue 改成递归写法
	 */
	class Solution {
	    public int findCircleNum(int[][] M) {
	        if (M == null || M.length == 0 || M[0].length == 0 || M.length != M[0].length) {
	            return 0;
	        }
	        int n = M.length;
	        boolean[] visited = new boolean[n];
	        int count = 0;
	        for (int i = 0; i < n; i++) {
	            if (!visited[i]) {
	                dfs(i, M, visited);
	                count++;
	            }
	        }
	        
	        return count;
	    }
	    
	    private void dfs(int student, int[][] M, boolean[] visited) {
	        for (int i = 0; i < M.length; i++) {
	            if (!visited[i] && M[student][i] == 1) {
	                visited[i] = true;
	                dfs(i, M, visited);
	            }
	        }
	    }
	}
}