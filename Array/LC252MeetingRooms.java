public class LC252MeetingRooms {
	/**
	 * Two pointers solution.
	 * Runtime: 4 ms, faster than 95.12% of Java online submissions for Meeting Rooms.
	 * Memory Usage: 39.3 MB, less than 5.13% of Java online submissions for Meeting Rooms.
	 */
	class TwoPointersSolution {
	    public boolean canAttendMeetings(int[][] intervals) {
	        if (intervals == null || intervals.length <= 1) {
	            return true;
	        }
	        Arrays.sort(intervals, new Comparator<int[]>() {
	            @Override
	            public int compare(int[] int1, int[] int2) {
	                return int1[0] - int2[0];
	            }
	        });

	        int next = 1;
	        int cur = 0;
	        while (next < intervals.length) {
	            if (intervals[next][0] < intervals[cur][1]) {
	                return false;
	            } else {
	                cur++;
	                next++;
	            }
	        }
	        
	        return true;
	    }
	}
}