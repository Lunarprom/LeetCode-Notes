public class LC909SnakesAndLadders {
	/**
	 * 坐标的换算：row = N - 1 - (num-1)/N; col = N - 1 - (num-1)/N 或者(num - 1)/N （奇偶取决于行数）
	 * e.g. num = 1, row = 5 - 1/6 = 5, col = 0 % 6 = 0
	 * 先写个函数暴力求解坐标
	 * 然后从左下角的点开始对6个方向BFS。用visited 函数来标记当前格子已经检索过了。
	 * 时间复杂度O(N*N)
	 */
	class BFSSolution {
	    private int n;
	    public int snakesAndLadders(int[][] board) {
	        n = board.length;
	        boolean[] visited = new boolean[n * n + 1];
	        Queue<Integer> queue = new LinkedList<>();
	        queue.offer(1);
	        visited[1] = true;
	        int step = 1;
	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            for (int k = 0; k < size; k++) {
	                int cur = queue.poll();
	                for (int i = 1; i <= 6; i++) {
	                    int next = cur + i;
	                    int[] pos = numToPos(next);
	                    if (board[pos[0]][pos[1]] > 0) {
	                        next = board[pos[0]][pos[1]];
	                    }
	                    if (next == n * n) {
	                        return step;
	                    }
	                    if (!visited[next]) {
	                        queue.offer(next);
	                        visited[next] = true;
	                    }
	                }
	            }
	            step++;
	        }
	        return -1;
	    }
	    
	    private int[] numToPos(int target) {
	        int row = (target - 1) / n;
	        int col = (target - 1) % n;
	        int x = n - 1 - row;
	        int y = row % 2 == 0 ? col : n - 1 - col;
	        return new int[]{x, y};
	    }
	}
}