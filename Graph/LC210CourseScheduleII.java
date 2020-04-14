public class LC210CourseScheduleII {
	/**
	 * Topological sort. The difference with Question I is just we need to append the course that we traversed (that the indegree has ever been 0) to a result list.
	 * If the result list size is smaller than numCourses, then it means there are nodes that has cyclic dependencies and thus the course schedule is impossible.
	 * Runtime: 5 ms, faster than 71.20% of Java online submissions for Course Schedule II.
	 * Memory Usage: 40.4 MB, less than 97.56% of Java online submissions for Course Schedule II.
	 */
	class TopologicalSortSolution {
	    public int[] findOrder(int numCourses, int[][] prerequisites) {
	        if (numCourses <= 0) {
	            return new int[0];
	        }
	        int[] indegrees = new int[numCourses];
	        List<Set<Integer>> adjacencies = new ArrayList<>();
	        // Initialize the adjacent list
	        for (int i = 0; i < numCourses; i++) {
	            adjacencies.add(new HashSet<Integer>());
	        }
	        // Traverse all edges and update the array and the adjacent list.
	        for (int[] edge : prerequisites) {
	            indegrees[edge[0]]++;
	            adjacencies.get(edge[1]).add(edge[0]);
	        }
	        List<Integer> courses = new ArrayList<Integer>();
	        Queue<Integer> queue = new LinkedList<Integer>();
	        for (int i = 0; i < numCourses; i++) {
	            if (indegrees[i] == 0) {
	                queue.add(i);
	            }
	        }
	        
	        while (!queue.isEmpty()) {
	            int node = queue.poll();
	            courses.add(node);
	            // delete all edges from the adj list and reduce indegree;
	            Set<Integer> adjs = adjacencies.get(node);
	            for (int adj : adjs) {
	                if (--indegrees[adj] == 0) {
	                    queue.add(adj);
	                }
	            }
	        }
	        if (numCourses != courses.size()) {
	            return new int[0];
	        }
	        int[] schedule = new int[numCourses];
	        for (int i = 0; i < numCourses; i++) {
	            schedule[i] = courses.get(i);
	        }
	        
	        return schedule;
	    }
	}
}