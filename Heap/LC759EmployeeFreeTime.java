public class LC759EmployeeFreeTime {
	/*
	// Definition for an Interval.
	class Interval {
	    public int start;
	    public int end;

	    public Interval() {}

	    public Interval(int _start, int _end) {
	        start = _start;
	        end = _end;
	    }
	};
	*/

	class LineSweepingSolution {
	    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
	        int OPEN = 1, CLOSE = -1;

	        List<int[]> events = new ArrayList();
	        for (List<Interval> employee: avails)
	            for (Interval iv: employee) {
	                events.add(new int[]{iv.start, OPEN});
	                events.add(new int[]{iv.end, CLOSE});
	            }

	        Collections.sort(events, (a, b) -> a[0] != b[0] ? a[0]-b[0] : b[1] - a[1]);
	        List<Interval> ans = new ArrayList();

	        int prev = -1, bal = 0;
	        for (int[] event: events) {
	            // event[0] = time, event[1] = command
	            if (bal == 0 && prev >= 0)
	                ans.add(new Interval(prev, event[0]));
	            bal += event[1];
	            prev = event[0];
	        }

	        return ans;
	    }
	}

}