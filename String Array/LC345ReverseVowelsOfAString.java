public class LC345ReverseVowelsOfAString {
	class TwoPointersSolution {
	    Set<Character> vowels = new HashSet<Character>() {{
	        add('a');
	        add('e');
	        add('i');
	        add('o');
	        add('u');
	        add('A');
	        add('E');
	        add('I');
	        add('O');
	        add('U');
	    }};
	    public String reverseVowels(String s) {
	        if (s == null || s.length() <= 1) {
	            return s;
	        }
	        char[] chars = s.toCharArray();
	        int start = 0;
	        int end = chars.length - 1;
	        while (start < end) {
	            while ( start < chars.length && !vowels.contains(chars[start])) {
	                start++;
	            }
	            while (end >= 0 && !vowels.contains(chars[end])) {
	                end--;
	            }
	            if (start < end) {
	                char tmp = chars[start];
	                chars[start] = chars[end];
	                chars[end] = tmp;
	                start++;
	                end--;
	            }
	        }
	        
	        return new String(chars);
	    }
	}
}