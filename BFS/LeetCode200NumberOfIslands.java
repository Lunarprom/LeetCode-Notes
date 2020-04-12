public class LeetCode200NumberOfIslands {
    class Solution {
    /**
     * 1. define the available direction
     * 2. Maintain a same sized matrix marking visited points
     * 3. For every unvisited points, do BFS to check if it is connected to other points.
     */
    private class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int index = m * n; // index / n 得到行x，index % n 得到列y
        int count = 0;
        for (int i = 0; i < index; i++) {
            int row = i / n;
            int col = i % n;
            if (grid[row][col] == '1') {
                markByBFS(grid, row, col);
                count++;
            }
        }
        
        return count;
    }

    private void markByBFS(char[][] grid, int x, int y) {
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(x, y));
        grid[x][y] = '2'; // Mark as visited
        while (!queue.isEmpty()) {
            int size = queue.size();
            Coordinate current = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate neighbor = new Coordinate(current.x + dx[i], current.y + dy[i]);
                if (!isValid(neighbor, grid.length, grid[0].length)) {
                    continue;
                }
                if (grid[neighbor.x][neighbor.y] == '1') {
                    grid[neighbor.x][neighbor.y] = '2';
                    queue.offer(neighbor);
                }
            }
        }
        return;
    }
                    
    private boolean isValid(Coordinate coord, int row, int col) {
        return coord.x >= 0 && coord.y >= 0 && coord.x < row && coord.y < col;
    }
}
}