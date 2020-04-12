class LC130SurroundedRegions {
	/**
	 * BFS solution
	 * Traverse the whole matrix, if there is an 0 that's not on the border, start the BFS. Change all 0 to 1 as long as it's not on the border.
	 * Any 'o' on the border should not be flipped;
	 * Any 'o' on the border
	 */
	class BSFSolution {
	    int[] dx = {0, 1, 0, -1};
	    int[] dy = {1, 0, -1, 0};

	    public void solve(char[][] board) {
	        if (board == null || board.length == 0 || board[0].length == 0) {
	            return;
	        }
	        
	        for (int i = 0; i < board.length; i++) {
	            bfs(board, i, 0);
	            bfs(board, i, board[0].length - 1);
	        }
	        for (int i = 0; i < board[0].length; i++) {
	            bfs(board, 0, i);
	            bfs(board, board.length - 1, i);
	        }
	        
	        for (int i = 0; i < board.length; i++) {
	            for (int j = 0; j < board[0].length; j++) {
	                if (board[i][j] == '#') {
	                    board[i][j] = 'O';
	                } else {
	                    board[i][j] = 'X';
	                }
	            } 
	        }
	        
	    }
	    
	    // Flood fill
	    private void bfs(char[][] board, int cx, int cy) {        
	        if (board[cx][cy] != 'O') {
	            return;
	        }
	        int boardN = board[0].length;
	        Queue<Integer> queue = new LinkedList<>();
	        queue.offer(cx * boardN + cy);
	        board[cx][cy] = '#';
	        while (!queue.isEmpty()) {
	            int index = queue.poll();
	            int row = index / boardN;
	            int col = index % boardN;
	            if (board[row][col] == 'O') {
	                board[row][col] = '#';
	            }
	            for (int i = 0; i < 4; i++) {
	                // 对于周围八个方向都检查一下是不是等于'o' and add to the queue
	                int nx = row + dx[i];
	                int ny = col + dy[i];
	                if (isValid(nx, ny, board.length, boardN) 
	                    && board[nx][ny] == 'O') {
	                    board[nx][ny] = '#';
	                    queue.offer(nx * boardN + ny);
	                }
	            }
	        }
	    }
	    
	    private boolean isValid(int cx, int cy, int row, int col) {
	        return cx >= 0 && cx < row && cy >= 0 && cy < col;
	    }
	}

	/**
	 * DFS Solution
	 * Traverse the border and flood fill all 'O' and their adjacent 'O'.
	 */
	class DFSSolution {
	    private int[] dx = {0, 1, 0, -1};
	    private int[] dy = {1, 0, -1, 0};
	    public void solve(char[][] board) {
	        if (board == null || board.length == 0 || board[0].length == 0) {
	            return;
	        }
	        for (int i = 0; i < board.length; i++) {
	            dfs(board, i, 0);
	            dfs(board, i, board[0].length -1);
	        }
	        for (int j = 0; j < board[0].length; j++) {
	            dfs(board, 0, j);
	            dfs(board, board.length - 1, j);
	        }
	        
	        for (int i = 0; i < board.length; i++) {
	            for (int j = 0; j < board[0].length; j++) {
	                if (board[i][j] == '#') {
	                    board[i][j] = 'O';
	                } else {
	                    board[i][j] = 'X';
	                }
	            } 
	        }
	    }
	    
	    private void dfs(char[][] board, int cx, int cy) {
	        if (!isValid(cx, cy, board.length, board[0].length) || board[cx][cy] != 'O') {
	            return;
	        }
	        board[cx][cy] = '#';
	        for (int i = 0; i < 4; i++) {
	            dfs(board, cx + dx[i], cy + dy[i]);
	        }
	    }
	    
	    private boolean isValid(int cx, int cy, int row, int col) {
	        return cx >= 0 && cx < row && cy >= 0 && cy < col;
	    }
	}

	/**
	 * Set up a dummy node for all the 'O' on the border. Union them together. For all the rest just set the value to 'X'
	 * Runtime: 21 ms, faster than 5.27% of Java online submissions for Surrounded Regions.
	 * Memory Usage: 49.2 MB, less than 7.14% of Java online submissions for Surrounded Regions.
	 */
	class UnionFindSolution {
	    public void solve(char[][] board) {
	        if (board == null || board.length == 0 || board[0].length == 0) {
	            return;
	        }
	        int row = board.length;
	        int col = board[0].length;
	        int dummy = row * col;
	        UnionFind uf = new UnionFind(row * col + 1);
	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                int curIndex = i * col + j;
	                if (board[i][j] == 'O') {
	                    if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
	                        uf.union(dummy, i * col + j);
	                    } else {
	                        if (i > 0 && board[i - 1][j] == 'O') {
	                            uf.union(curIndex - col, curIndex);
	                        }
	                        if (i < row - 1 && board[i + 1][j] == 'O') {
	                            uf.union(curIndex + col, curIndex);
	                        }
	                        if (j > 0 && board[i][j - 1] == 'O') {
	                            uf.union(curIndex - 1, curIndex);
	                        }
	                        if (j < col - 1 && board[i][j + 1] == 'O') {
	                            uf.union(curIndex + 1, curIndex);
	                        }
	                    }
	                }
	            }
	        }
	        
	        for (int i =  0; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                if (!uf.isConnected(i * col + j, dummy)) {
	                    board[i][j] = 'X';
	                }
	            }
	        }
	    }
	    
	    class UnionFind {
	        int count;
	        int[] parent;
	        public UnionFind(int n) {
	            this.count = count;
	            this.parent = new int[n];
	            for (int i = 0; i < n; i++) {
	                parent[i] = i;
	            }
	        }
	        
	        int find(int p) {
	            if (parent[p] != p) {
	                parent[p] = find(parent[p]);
	            }
	            return parent[p];
	        }
	        
	        boolean isConnected(int p, int q) {
	            return find(p) == find(q);
	        }
	        
	        void union(int p, int q) {
	            int rootP = find(p);
	            int rootQ = find(q);
	            if (rootP == rootQ) {
	                return;
	            }
	            parent[rootQ] = rootP;
	        }
	    }
	}
}