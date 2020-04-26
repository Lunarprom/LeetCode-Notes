public class LC875KokoEatingBananas {
	/**
	 * 题意转化成找一个对所有pile[i] value 找最小公约数使得他们的倍数相加大于H
	 * 上下边界的话随便设一个min/max吧
	 * Runtime: 16 ms, faster than 37.11% of Java online submissions for Koko Eating Bananas.
	 * Memory Usage: 40.3 MB, less than 100.00% of Java online submissions for Koko Eating Bananas.
	 * 8min, a bug on the start value.
	 */
	class Solution {
	    public int minEatingSpeed(int[] piles, int H) {
	        if (piles == null || piles.length == 0) {
	            return 0;
	        }
	        int start = 1; // Cannot be 1!!! otherwise the division will fail.
	        int end = Integer.MAX_VALUE;
	        while (start + 1 < end) {
	            int mid = start + (end - start) / 2;
	            if (possible(piles, mid, H)) {
	                end = mid;
	            } else {
	                start = mid;
	            }
	        }
	        
	        if (possible(piles, start, H)) {
	            return start;
	        } else {
	            return end;
	        }
	    }
	    
	    private boolean possible(int[] piles, int speed, int H) {
	        int time = 0;
	        for (int i = 0; i < piles.length; i++) {
	            if (piles[i] % speed != 0) {
	                time += piles[i] / speed + 1;
	            } else {
	                time += piles[i] / speed;
	            }
	        }
	        
	        return time <= H;
	    }
	}
}