// Related question: LC 69 Sqrt(x) and LintCode Sqrt(x) II
public class LC367ValidPerfectSquare {
	class BinarySearchSolution {
	    public boolean isPerfectSquare(int num) {
	        if (num == 0) {
	            return true;
	        }
	        
	        // 要用long int否则遇到很大的num，平方会溢出
	        long left = 1;
	        long right = num / 2;
	        while (left < right) {
	            long mid = left + (right - left) / 2;
	            long sqr = mid * mid;
	            if (sqr == num) {
	                return true;
	            } else if (sqr < num) {
	                left = mid + 1;
	            } else {
	                right = mid;
	            }
	        }
	        
	        return left * left == num;
	    }
	}
}