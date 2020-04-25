public class LC50Powxn {
	/**
	 * Brute force是用for loop, 计算(n - 1)次 x * x
	 * Binary Search 二分法, 进行 count = n / 2 次 x = x * x. 如果 n % 2 == 1，就再多乘一次。
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Pow(x, n).
	 * Memory Usage: 36.7 MB, less than 5.88% of Java online submissions for Pow(x, n).
	 * Reference: https://oi-wiki.org/math/quick-pow/
	 */
	class RecursionSolution {
	    public double myPow(double x, int n) {
	        // 一定要使用长整型。如果是双精度的话会保留小数就傻逼了
	        long N = n;
	        if (N < 0) {
	            x = 1 / x;
	            N = -N;
	        }
	        
	        return fastPow(x, N);
	    }
	    
	    private double fastPow(double x, long n) {
	        if (n == 0) {
	            return 1.0;
	        }
	        double half = fastPow(x, n/2);
	        if (n % 2 == 1) {
	            return half * half * x;
	        } else {
	            return half * half;
	        }
	    }
	}

	/**
	 * Iterative implementationo of fast power.
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Pow(x, n).
	 * Memory Usage: 36.7 MB, less than 5.88% of Java online submissions for Pow(x, n).
	 * Reference: https://oi-wiki.org/math/quick-pow/
	 */
	class IterationSolution {
	    public double myPow(double x, int n) {
	        // Must use long instead of double!!!
	        long N = n;
	        if (N < 0) {
	            x = 1 / x;
	            N = -N;
	        }
	        
	        double ans = 1.0;
	        double current_product = x;
	        for (long i = N; i > 0; i /= 2) {
	            if ((i % 2) == 1) {
	                ans = ans * current_product;
	            }
	            current_product = current_product * current_product;
	        }
	        return ans;
	    }
	}
}