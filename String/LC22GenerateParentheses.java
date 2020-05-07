/**
 * 标准得不能再标准的回溯解法
 */
public class LC22GenerateParentheses {
	class BacktrackSolution {
	    public List<String> generateParenthesis(int n) {
	        List<String> result = new ArrayList<>();
	        if (n == 0) {
	            return result;
	        }
	        backtrack(n, n, result, new StringBuilder());
	        
	        return result;
	    }
	    
	    private void backtrack(int left, int right, List<String> result, StringBuilder sb) {
	        if (left <= 0 && right <= 0) {
	            result.add(sb.toString());
	            return;
	        }
	        if (left > 0) {
	            sb.append('(');
	            backtrack(left - 1, right, result, sb);
	            sb.deleteCharAt(sb.length() - 1);
	        }
	        if (right > 0 && left < right) {
	            sb.append(')');
	            backtrack(left, right - 1, result, sb);
	            sb.deleteCharAt(sb.length() - 1);
	        }
	    }
	}
}