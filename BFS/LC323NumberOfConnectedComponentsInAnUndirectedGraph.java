class LC323NumberOfConnectedComponentsInAnUndirectedGraph {
    class UnionFindSolution {
        /**
         * UnionFind: 找出连通分量的个数 and return n - uf.getCount()
         * Runtime: 1 ms, faster than 100.00% of Java online submissions for Number of Connected Components in an Undirected Graph.
         * Memory Usage: 39.5 MB, less than 100.00% of Java online submissions for Number of Connected Components in an Undirected Graph.
         */
        public int countComponents(int n, int[][] edges) {
            if (edges == null) {
                return 0;
            }
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < edges.length; i++) {
                uf.union(edges[i][0], edges[i][1]);
            }
            
            return uf.count;
        }
        
        private class UnionFind {
            int count;
            int[] parent;
            public UnionFind(int n) {
                this.count = n;
                this.parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }
            
            // Find the root node of p;
            int find(int p) {
                if (parent[p] != p) {
                    parent[p] = find(parent[p]);
                }
                return parent[p];
            }
            
            void union(int p, int q) {
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
}