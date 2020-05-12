public class LC204CountPrimes {
	// Sieve of Eratosthenes algorithm
	// O(N * loglogN)
	class Solution {
	    public int countPrimes(int n) {
	        boolean[] isPrime = new boolean[n];
	        Arrays.fill(isPrime, true);
	        for (int i = 2; i * i < n; i++) {
	            for (int j = i * i; j < n; j += i) {
	                if (isPrime[i]) {
	                    isPrime[j] = false;
	                }
	            }
	        }
	        
	        int count = 0;
	        for (int i = 2; i < n; i++) {
	            count += isPrime[i] ? 1 : 0;
	        }
	        
	        return count;
	    }
	}
}