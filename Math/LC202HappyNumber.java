public class LC202HappyNumber {
	/**
	 * 1. The number evetuanlly leads to 1 meaning it is a happy number;
	 * 2. There is a circle during the calculation;
	 * 3. The calculation goes up infinitely -> wont' happen. 9999 -> 324. Eventually it will go down and either leads to 1 or get stuck under 324.
	 * 
	 * Implementation: 
	 * 1. Find the next number;
	 * 2. Detect the circle.
	 */
	class HashTableSolution {
	    public boolean isHappy(int n) {
	        Set<Integer> seen = new HashSet<>();
	        while (n != 1 && !seen.contains(n)) {
	            seen.add(n);
	            n = getNext(n);
	        }
	        
	        return n == 1; // Either n == 1, or we have seen the next number before.
	    }
	    
	    private int getNext(int n) {
	        int next = 0;
	        while (n > 0) {
	            int mod = n % 10; // get the lowest digit;
	            n = n / 10; // Move to the next digit;
	            next += mod * mod;
	        }
	        
	        return next;
	    }
	}
}