public class LC636ExclusiveTimeOfFunctions {
    /**
     * Mocked with Eagle. Spent ~50min and did not finished it.
     * 在没有见过这道题的情况下，第一直觉是这个题就应该使用stack，但是花了很长的时间纠结到底要不要stack（并且中途使用for loop没用stack来写发现行不通)
     * Solution is the same as the official solution.
     * Runtime: 9 ms, faster than 98.03% of Java online submissions for Exclusive Time of Functions.
     * Memory Usage: 40.2 MB, less than 10.71% of Java online submissions for Exclusive Time of Functions.
     */
    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            int[] result = new int[n];
            if (logs == null || logs.size() == 0) {
                return result;
            }
            Stack<TaskStatus> stack = new Stack<>();
            TaskStatus st0 = parse(logs.get(0));
            stack.push(st0);
            int index = 1;
            int preTime = st0.time;
            while (index < logs.size()) {
                TaskStatus curr = parse(logs.get(index));
                if (curr.isStart) { // if curr is start, then the previous must also be a start.
                    if (!stack.isEmpty()) {
                        TaskStatus pre = stack.peek();
                        int interval = curr.time - preTime;
                        result[pre.id] += interval;
                    }
                    stack.push(curr);
                    preTime = curr.time;
                } else {
                    if (!stack.isEmpty()) {
                        int interval = curr.time - preTime + 1;
                        result[curr.id] += interval;
                        stack.pop();
                    }
                    preTime = curr.time + 1;
                }
                index++;
            }
            
            return result;
        }
        
        private TaskStatus parse(String log) {
            String[] s = log.split(":");
            return new TaskStatus(Integer.parseInt(s[0]), s[1].equals("start"), Integer.parseInt(s[2]));
        }
        
        private class TaskStatus {
            int id;
            boolean isStart;
            int time;
            public TaskStatus(int id, boolean isStart, int time) {
                this.id = id;
                this.time = time;
                this.isStart = isStart;
            }
        }
    }
}