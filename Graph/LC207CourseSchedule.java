public class LC207CourseSchedule {
    /**
     * 1. 统计每个点的入度
     * 2. 将每个入度为 0 的点放入队列(Queue)中作为起始节点 (入度为0说明此课程不依赖于别的课程)
     * 3. 不断从队列中拿出一个点，去掉这个点的所有连边(指向其他点的边)，其他点的相应的入度 - 1
     * 4. 一旦发现新的入度为 0 的点，丢回队列中 (即去掉之前的边之后此课程不依赖别的课程)
     * 删完之后如果还有结点/课程的入度不为0（此课程依赖于别的课程）说明该图有环
     * Runtime: 3 ms, faster than 89.08% of Java online submissions for Course Schedule.
     * Memory Usage: 39.6 MB, less than 100.00% of Java online submissions for Course Schedule.
     */
    class TopologicalSolution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] indegrees = new int[numCourses];
            List<List<Integer>> adjacencies = new ArrayList<>(); // 每个课程指向其他的课程（即该课程是其他课程的先修）
            for (int i = 0; i < numCourses; i++) {
                // Initialize the adjacent list
                adjacencies.add(new ArrayList<Integer>());
            }
            for (int[] edge : prerequisites) {
                indegrees[edge[0]]++;
                adjacencies.get(edge[1]).add(edge[0]);
            }
            Queue<Integer> queue = new LinkedList<>();
            int count = numCourses;
            for (int i = 0; i < indegrees.length; i++) {
                if (indegrees[i] == 0) {
                    queue.add(i);
                }
            }
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                count--;
                List<Integer> adjList = adjacencies.get(curr);
                int size = adjList.size();
                for (int i = 0; i < size; i++) {
                    if (--indegrees[adjList.get(i)] == 0) {
                        queue.add(adjList.get(i));
                    }
                }
            }
            
            return count == 0;
        }
    }
}