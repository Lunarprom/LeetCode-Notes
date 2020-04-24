public class LC253MeetingRoomsII {
	/**
	 * Put the end time of each meeting into the priority queue. Iterate through the intervals  
	 * checking whether the start time is after the most recent end time. 
	 */
	class PriorityQueueSolution {
	    public int minMeetingRooms(int[][] intervals) {
	        if (intervals == null || intervals.length == 0) {
	            return 0;
	        }
	        PriorityQueue<Integer> pq = new PriorityQueue<>(intervals.length);
	        Arrays.sort(intervals, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] interval1, int[] interval2) {
	                return interval1[0] - interval2[0];
	            }
	        });
	        
	        pq.offer(intervals[0][1]);
	        for (int i = 1; i < intervals.length; i++) {
	            if (intervals[i][0] >= pq.peek()) {
	                pq.poll();
	            }
	            pq.offer(intervals[i][1]);
	        }
	            
	        return pq.size();  
	    }
	}

	/**
	 * Two pointers solution.
	 * Runtime: 5 ms, faster than 81.11% of Java online submissions for Meeting Rooms II.
	 * Memory Usage: 39.5 MB, less than 11.54% of Java online submissions for Meeting Rooms II.
	 */
	class Solution {
	    public int minMeetingRooms(int[][] intervals) {
	        if (intervals == null || intervals.length == 0) {
	            return 0;
	        }
	        Arrays.sort(intervals, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] interval1, int[] interval2) {
	                return interval1[0] - interval2[0];
	            }
	        });
	        
	        int len = intervals.length;
	        int[] start = new int[len];
	        int[] end = new int[len];
	        
	        for (int i = 0; i < intervals.length; i++) {
	            start[i] = intervals[i][0];
	            end[i] = intervals[i][1];
	        }
	        
	        Arrays.sort(start);
	        Arrays.sort(end);
	        
	        int sp = 0;
	        int ep = 0;
	        int count = 0;
	        while (sp < len) {
	            if (start[sp] >= end[ep]) {
	                count--;
	                ep++;
	            }
	            sp++;
	            count++;
	        }
	        
	        return count;
	    }
	}
}