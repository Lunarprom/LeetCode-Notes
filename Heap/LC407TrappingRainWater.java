public class LC407TrappingRainWater {
	class BFSSolution {
	    
	    class Cell {
	        int x;
	        int y;
	        int height;
	        public Cell (int x, int y, int height) {
	            this.x = x;
	            this.y = y;
	            this.height = height;
	        }
	    }
	    
	    class CellComparator implements Comparator<Cell> {
	        @Override
	        public int compare(Cell cell1, Cell cell2) {
	            return cell1.height - cell2.height;
	        }
	    }
	    
	    int[] dx = new int[]{0, 1, 0, -1};
	    int[] dy = new int[]{1, 0, -1, 0};
	    
	    public int trapRainWater(int[][] heightMap) {
	        if (heightMap == null || heightMap.length < 3 || heightMap[0].length < 3) {
	            return 0;
	        }
	        PriorityQueue<Cell> queue = new PriorityQueue<>(new CellComparator());
	        int m = heightMap.length;
	        int n = heightMap[0].length;
	        boolean[][] visited = new boolean[m][n];
	        
	        // Add all the boundary cell to the PQ.
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
	                    queue.offer(new Cell(i, j, heightMap[i][j]));
	                    visited[i][j] = true;
	                }
	            }
	        }
	        
	        int water = 0;
	        while (!queue.isEmpty()) {
	            Cell cell = queue.poll();
	            for (int i = 0; i < dx.length; i++) {
	                int x = cell.x + dx[i];
	                int y = cell.y + dy[i];
	                if (!isValid(x, y, m, n) || visited[x][y]) {
	                    continue;
	                }
	                visited[x][y] = true;
	                // 最小堆中元素的更新，都取的是当前最短木板和其井内未遍历元素高度，二者之间的最大值。
	                queue.offer(new Cell(x, y, Math.max(cell.height, heightMap[x][y])));
	                // 注水的时候，水量应该是堆中取出来的这个元素（木板）减去相邻元素（水洼）的差值
	                water += Math.max(0, cell.height - heightMap[x][y]);
	            }
	        }
	        
	        return water;
	    }
	    
	    private boolean isValid(int x, int y, int m, int n) {
	        return x >= 0 && x < m && y >= 0 && y < n;
	    }
	}
}