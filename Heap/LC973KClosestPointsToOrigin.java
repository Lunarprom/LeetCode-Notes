public class LC973KClosestPointsToOrigin {
	/**
	 * PriorityQueue + 自定义Comparator就可以了吧
	 * Runtime: 23 ms, faster than 60.26% of Java online submissions for K Closest Points to Origin.
	 * Memory Usage: 49.2 MB, less than 100.00% of Java online submissions for K Closest Points to Origin.
	 */
	class PriorityQueueSolution {
		public int[][] kClosest(int[][] points, int K) {
		    int[][] result = new int[K][2];
		    if (points == null || K == 0) {
		        return result;
		    }
		    Comparator<Coordinate> comp = new Comparator<Coordinate>() {
		        @Override
		        public int compare(Coordinate cd1, Coordinate cd2) {
		            int abs1 = cd1.x * cd1.x + cd1.y * cd1.y;
		            int abs2 = cd2.x * cd2.x + cd2.y * cd2.y;
		            
		            return abs1 - abs2;
		        }
		    };
		    PriorityQueue<Coordinate> pq = new PriorityQueue<>(K, comp);
		    
		    for (int i = 0; i < points.length; i++) {
		        Coordinate cd = new Coordinate(points[i][0], points[i][1]);
		        pq.add(cd);
		    }
		    
		    for (int i = 0; i < K; i++) {
		        Coordinate cd = pq.poll();
		        result[i][0] = cd.x;
		        result[i][1] = cd.y;
		    }
		    
		    return result;
		}

		private class Coordinate {
		    int x;
		    int y;
		    public Coordinate(int x, int y) {
		        this.x = x;
		        this.y = y;
		    }
		}
	}
}