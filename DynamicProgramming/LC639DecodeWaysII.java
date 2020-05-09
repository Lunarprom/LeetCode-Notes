/**
 * 需要分好多好多种情况讨论。
 * Ref: 九章强化Lec05
 */
public class LC639DecodeWaysII {
	class Solution {
	    public int numDecodings(String s) {
	        char[] chars = s.toCharArray();
	        int n = s.length();
	        long MOD = 1000000007;
	        long[] f = new long[n + 1]; // f[i] for first i digits
	        f[0] = 1;
	        for (int i = 1; i <= n; i++) {
	            f[i] = f[i - 1] * cnt1(chars[i-1]);
	            if (i > 1) {
	                f[i] += f[i - 2] * cnt2(chars[i - 2], chars[i - 1]);
	            }
	            f[i] = f[i] % MOD;
	        }
	        
	        return (int)f[n];
	    }
	    
	    private int cnt1(char c) {
	        if (c == '0') {
	            return 0;
	        }
	        
	        if (c != '*') {
	            return 1;
	        }
	        
	        return 9;
	    }
	    
	    private int cnt2(char c2, char c1) {
	        if (c2 == '0') {
	            return 0;
	        }
	        if (c2 == '1') {
	            if (c1 == '*') {
	                return 9; // 11-19
	            }
	            return 1;
	        }
	        if (c2 == '2') {
	            if (c1 == '*') {
	                return 6; // 21-26
	            }
	            if (c1 <= '6') {
	                return 1;
	            }
	            return 0;
	        }
	        
	        if (c2 >= '3' && c2 <= '9') {
	            return 0;
	        }
	        
	        // c2 = '*'
	        if (c1 >= '0' && c1 <= '6') {
	            return 2; // 10, 20
	        }
	        if (c1 >= '7' && c1 <= '9') {
	            // 17
	            return 1;
	        }
	        
	        // **
	        return 15;
	    }
	}
}