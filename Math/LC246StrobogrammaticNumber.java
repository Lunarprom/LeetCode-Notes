public class LC246StrobogrammaticNumber {
	class Solution {
	    public boolean isStrobogrammatic(String num) {
	        Map<Character, Character> map = new HashMap<>() {{
	            put('6', '9');
	            put('9', '6');
	            put('8', '8');
	            put('1', '1');
	            put('0', '0');
	        }};
	        int left = 0;
	        int right = num.length() - 1;
	        while (left <= right) {
	            if (!map.containsKey(num.charAt(left)) || !map.containsKey(num.charAt(right))) {
	                return false;
	            }
	            if (map.get(num.charAt(left++)) != num.charAt(right--)) {
	                return false;
	            }
	        }
	        return true;
	    }
	}
}