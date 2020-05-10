/**
 * Pay attention to the overflow once the number is reverted.
 * 2^31-1 = 2147483647
 */
public class LC7ReverseInteger {
	class Solution {
	    public int reverse(int x) {
	        int result = 0;
	        while (x != 0) {
	            int mod = x % 10;
	            x /= 10;
	            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && mod > 7)) return 0;
	            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && mod < -8)) return 0;
	            result = result * 10 + mod;
	        }
	        
	        return result;
	    }
	}
}