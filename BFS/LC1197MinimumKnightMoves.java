public class LC1197MinimumKnightMoves {
	class Solution {
    
	    private final int[][] DIRECTIONS = 
	        new int[][]{{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
	    
	    public int minKnightMoves(int x, int y) {
	        // Direction doesn't matter. So changing that to positive x-y quadrant.
	        x = Math.abs(x);
	        y = Math.abs(y);
	        
	        Queue<int[]> q = new LinkedList<>();
	        q.add(new int[]{0, 0});
	        
	        // Using a String saved SO MUCH TIME for the OJ. Won't cause TLE.
	        Set<String> visited = new HashSet<>();
	        visited.add("0,0");
	        
	        int steps = 0;
	        while (!q.isEmpty()) {
	            int size = q.size();
	            for (int i = 0; i < size; i++) {
	                int[] pos = q.remove();
	                int posx = pos[0];
	                int posy = pos[1];
	                if (posx == x && posy == y) return steps;

	                for (int[] direction: DIRECTIONS) {
	                    int nextx = posx + direction[0];
	                    int nexty = posy + direction[1];
	                    int[] nextxy = new int[]{nextx, nexty};

	                    String nextpos = nextx + "," + nexty;
	                    if (!visited.contains(nextpos) && nextx >= -1 && nexty >= -1) {
	                        q.offer(nextxy);
	                        visited.add(nextpos);
	                    }
	                }
	            }
	            steps++;
	        }
	        return -1;
	    }
	}
}