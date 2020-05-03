public class LC529MineSweeper {
	/**
	 * 标准BFS solution. 我赌电面不考这个。。。
	 * 八个方向坐标的扫描还可以优化一下。
	 */
	class BFSSolution {
	    public char[][] updateBoard(char[][] board, int[] click) {
	        if (board == null || board.length == 0 || board[0].length == 0) {
	            return board;
	        }
	        int m = board.length;
	        int n = board[0].length;
	        if (click[0] < 0 || click[0] >= m || click[1] < 0 || click[1] >= n) {
	            return board;
	        }
	        Queue<int[]> queue = new LinkedList<>();
	        queue.offer(click);
	        while (!queue.isEmpty()) {
	            int[] curr = queue.poll();
	            int row = curr[0];
	            int col = curr[1];
	            if (board[row][col] == 'M') {
	                board[row][col] = 'X';
	                return board;
	            }
	            // 扫描节点 (row, col) 八个方向有多少个地雷
	            int count = 0;
	            for (int i = -1; i < 2; i++) {
	                for (int j = -1; j < 2; j++) {
	                    if (i == 0 && j == 0) continue;
	                    int r = row + i;
	                    int c = col + j;
	                    if (r < 0 || r >= m || c < 0 || c >= n) continue;
	                    if (board[r][c] == 'M' || board[r][c] == 'X') count++;
	                }
	            }
	            if (count > 0) {
	                // 如果有地雷的话，则停止搜索
	                // 并且将节点 (row, col) 的值设置为地雷的数量
	                board[row][col] = (char)(count + '0');
	            } else {
	                // 继续 BFS 
	                board[row][col] = 'B';
	                // 搜索节点 (row, col) 八个方向
	                for (int i = -1; i < 2; i++) {
	                    for (int j = -1; j < 2; j++) {
	                        if (i == 0 && j == 0) continue;
	                        int r = row + i;
	                        int c = col + j;
	                        if (r < 0 || r >= m || c < 0 || c >= n) continue;
	                        if (board[r][c] == 'E') {
	                            queue.add(new int[]{r, c});
	                            board[r][c] = 'B';
	                        }
	                    }
	                }
	            }
	        }
	        
	        return board;
	    }
	}
}