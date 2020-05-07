public class LC69Sqrtx {
	class BinarySearchSolution {
	    public int mySqrt(int x) {
	        if (x < 2) {
	            return x;
	        }
	        long left = 0;
	        long right = x / 2;
	        while (left < right) {
	            // 向右取中数，否则会死循环 e.g. x = 4
	            long mid = left + (right - left + 1) / 2; // mid会永远等于1
	            long sqr = mid * mid;
	            
	            if (sqr == x) {
	                return (int) mid;
	            }if (sqr > x) {
	                right = mid - 1; // 向右边取边界因为根据题意，要找平方小于等于x的
	            } else {
	                left = mid;
	            }
	        }
	        
	        return (int) left;
	    }
	}
}