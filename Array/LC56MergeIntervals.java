public class LC56MergeIntervals {
	/**
	 * Solution1: sort the intervals by the start.
	 * Runtime: 7 ms, faster than 27.03% of Java online submissions for Merge Intervals.
	 * Memory Usage: 42.3 MB, less than 48.55% of Java online submissions for Merge Intervals.
	 */
	class SortSolution {
	    public int[][] merge(int[][] intervals) {
	        if (intervals == null || intervals.length <= 1) {
	            return intervals;
	        }
	        Arrays.sort(intervals, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] interval1, int[] interval2) {
	                return interval1[0] - interval2[0];
	            }
	        });
	        
	        LinkedList<int[]> merged = new LinkedList<>();
	        merged.add(intervals[0]);
	        for (int i = 1; i < intervals.length; i++) {
	            if (intervals[i][0] > merged.getLast()[1]) {
	                merged.add(intervals[i]);
	            } else {
	                merged.getLast()[1] = Math.max(intervals[i][1], merged.getLast()[1]);
	            }
	        }
	        
	        return merged.toArray(new int[merged.size()][]);
	    }
	}

	/**
	 * Two pointers solution. points to the intervals and keep updating the value 
	 * before adding the interval to the list.
	 * 排序是O(NLogN)，扫描是O(N)
	 */
	class Solution {
	    public int[][] merge(int[][] intervals) {
	        if (intervals == null || intervals.length <= 1) {
	            return intervals;
	        }
	        Arrays.sort(intervals, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] int1, int[] int2) {
	                return int1[0] - int2[0];
	            }
	        });
	            
	        LinkedList<int[]> result = new LinkedList<>();
	        int startTime = intervals[0][0];
	        int endTime = intervals[0][1];
	        for (int i = 1; i < intervals.length; i++) {
	            if (intervals[i][0] <= endTime) {
	                endTime = Math.max(intervals[i][1], endTime);
	            } else {
	                result.add(new int[]{startTime, endTime});
	                startTime = intervals[i][0];
	                endTime = intervals[i][1];
	            }
	        }
	        result.add(new int[]{startTime, endTime});
	        
	        return result.toArray(new int[result.size()][]);
	    }
	}
}