import java.util.LinkedList;
import java.util.Queue;

public class LeetCode346MovingAverageFromDataStream01 {

    private Queue<Integer> queue;
    private Integer maxSize;
    private Double sum = 0.0;

    /** Initialize your data structure here. */
    public LeetCode346MovingAverageFromDataStream01(int size) {
        this.queue = new LinkedList<Integer>();
        this.maxSize = size;
    }

    public double next(int val) {
        sum += val;
        if (queue.size() == maxSize) {
            sum -= queue.poll();
        }
        queue.offer(val);
        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
