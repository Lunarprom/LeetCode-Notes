public class LC13RomanToInter {
	class LazyOnePassSolution {
	    Map<String, Integer> values = new HashMap<String, Integer>() {{
	        put("I", 1);
	        put("V", 5);
	        put("X", 10);
	        put("L", 50);
	        put("C", 100);
	        put("D", 500);
	        put("M", 1000);
	        put("IV", 4);
	        put("IX", 9);
	        put("XL", 40);
	        put("XC", 90);
	        put("CD", 400);
	        put("CM", 900);
	    }};
	    public int romanToInt(String s) {
	        int sum = 0;
	        if (s == null) {
	            return sum;
	        }
	        
	        int index = 0;
	        while (index < s.length()) {
	            if (index < s.length() - 1) {
	                String doubleSymbol = s.substring(index, index + 2);
	                if (values.containsKey(doubleSymbol)) {
	                    sum += values.get(doubleSymbol);
	                    index += 2;
	                    continue;
	                }
	            }
	            String singleSymbol = s.substring(index, index + 1);
	            sum += values.get(singleSymbol);
	            index++;
	        }
	        
	        return sum;
	    }
	}
}