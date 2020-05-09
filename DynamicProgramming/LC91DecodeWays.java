public class LC91DecodeWays {
	/**
	 * 最后一步：最后一个字符的解密方式取决于N-1 和 N-2 （因为有可能是两位的)
	 * 状态方程f[i] = f[i - 1] + f[i - 2]
	 * 初始化 f 数组为 0
	 * 若字符串中 s[i] 表示的阿拉伯数字在 1~9 范围内, f[i] += f[i-1]
	 * 若s[i-1]和s[i]连起来表示的数字在 10~26 范围内, f[i] += f[i-2] (若i==1, 则f[i] += 1)
	 * 边界条件：f[0] = 1 （空字符串只有一种方式since 0不能转化成字母
	            if i = 1 那就只有9种因为只有一位的长度
	 * 计算顺序：f[0], f[1]... f[n]
	 * Time complexity: O(N), Space complexity: O(N)
	 */
	class Solution {    
	    public int numDecodings(String s) {
	        // nothing to decode
	        if (s == null || s.length() == 0) {
	            return 0;
	        }
	        int n = s.length();
	        int[] dp = new int[n + 1];
	        dp[0] = 1;
	        dp[1] = s.charAt(0) != '0' ? 1 : 0; // We can't decode '0' to any letter
	        for (int i = 2; i <= n; i++) {
	            if (s.charAt(i - 1) != '0') {
	                dp[i] = dp[i - 1];
	            }
	            int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
	            // Make sure that the first digit is not 0. Otherwise meaning char at [i - 2] is invalid, i.e.0.
	            if (twoDigits >= 10 && twoDigits <= 26) {
	                dp[i] += dp[i - 2];
	            }
	            
	        }
	        
	        return dp[n];
	    }
	}
}