public class LC694NumberOfDistinctIslands {
	/*
	 * 标记岛屿的形状，可以记住岛屿的行/列数
	 * 对每个岛屿格子使用DFS，搜索上下左右四个方向，
	 * "o"标记最外层格子开始，udlr标记四个方向搜索的路径，b标记当前方向搜索的结束。
	 * 对于同一个形状的岛屿，DFS的路径应当是一致的。
	 * Time Complexity: O(R*C), where R is the number of rows in the given grid, 
	 * and C is the number of columns. We visit every square once.
	 */
	class DFSSolution {
	    public int numDistinctIslands(int[][] grid) {
	        Set<String> set = new HashSet<>();
	        for(int i = 0; i < grid.length; i++) {
	            for(int j = 0; j < grid[i].length; j++) {
	                if(grid[i][j] != 0) {
	                    StringBuilder sb = new StringBuilder();
	                    dfs(grid, i, j, sb, "o"); // origin
	                    grid[i][j] = 0;
	                    System.out.println(sb.toString());
	                    set.add(sb.toString());
	                }
	            }
	        }
	        return set.size();
	    }
	    
	    private void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
	        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length 
	           || grid[i][j] == 0) {
	            return;
	        }
	        sb.append(dir);
	        grid[i][j] = 0;
	        dfs(grid, i - 1, j, sb, "u");
	        dfs(grid, i + 1, j, sb, "d");
	        dfs(grid, i, j - 1, sb, "l");
	        dfs(grid, i, j + 1, sb, "r");
	        sb.append("b");
	    }
	}
}