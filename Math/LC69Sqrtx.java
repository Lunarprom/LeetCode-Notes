public class LC69Sqrtx {
	class BinarySearchSolution {
	    public int mySqrt(int x) {
	        if (x < 2) {
	            return x;
	        }
	        long left = 0;
	        // 如果一个数的一半的平方大于它自己，那么这个数的取值范围。解以上不等式得a ≥4或者a ≤ 0
	        // 对 0、1、2、3 分别计算结果，很容易知道，这 4 个数的平方根依次是 0、1、1、1
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