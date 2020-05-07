public class LC84LargestRectangleInHistogram {
	/**
	 * 找到每个元素左边第一个比自己小的元素:出栈
	 * 找右边的第一个比自己小的元素：出栈就是因为遇到了第一个比自己小的数
	 * 最大矩形一定是某个柱子向左向右推进到无法推进形成的
	 */
	class StackSolution {
	    public int largestRectangleArea(int[] heights) {
	        if (heights == null || heights.length == 0) {
	            return 0;
	        }
	        if (heights.length == 1) {
	            return heights[0];
	        }
	        Stack<Integer> stack = new Stack<>();
	        int max = 0;
	        for (int i = 0; i <= heights.length; i++) {
	            int cur = (i == heights.length) ? -1 : heights[i]; // -1 works as 哨兵 and can guarantee all entries in the stack will be poped out
	            while (!stack.isEmpty() && cur <= heights[stack.peek()]) {
	                // pop
	                int h = heights[stack.pop()];
	                int left = stack.isEmpty() ? 0 : stack.peek() + 1; // 不是栈顶，而是下一个
	                int right = i - 1; // 当前元素cur(index = i)是栈弹出的当前元素右边第一个比它小的元素（右边界）。计算面积的时候右边界是不要的。所以要-1
	                
	                int area = h * (right - left + 1);
	                max = Math.max(max, area);
	            }
	            stack.push(i);
	        }
	        
	        return max;
	    }
	}
}