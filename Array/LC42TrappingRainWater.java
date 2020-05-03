public class LC42TrappingRainWater {
    /**
     * 1. 暴力法对每个点遍历找到右边界，O(N^2)
     * 2. DP左右扫一遍记录当前最大的左边界和右边界
     * 3. 单调递减栈，直到找到一根比前面高的柱子，就可以开始计算积水
     * 4. 双指针分别maintain当前左右最大，挪动小的去找低洼
     */
    class TwoPointersSolution {
        public int trap(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            } 
            int left = 0;
            int right = height.length - 1;
            int leftMax = 0;
            int rightMax = 0;
            int result = 0;
            while (left < right) {
                if (height[left] < height[right]) {
                    if (height[left] >= leftMax) {
                        leftMax = height[left];
                    } else {
                        result += leftMax - height[left];
                    }
                    left++;
                } else {
                    if (height[right] >= rightMax) {
                        rightMax = height[right];
                    } else {
                        result += rightMax - height[right];
                    }
                    right--;
                }
            }
            
            return result;
        }
    }

    class DPSolution {
        public int trap(int[] height) {
            if (height == null || height.length < 3) {
                return 0;
            }
            int len = height.length;
            int[] leftMax = new int[len];
            int[] rightMax = new int[len];
            leftMax[0] = height[0];
            rightMax[len - 1] = height[len - 1];
            int result = 0;
            for (int i = 1; i < len; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }
            for (int i = len - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }
            for (int i = 0; i < len; i++) {
                result += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            
            return result;
        }
    }

    class StackSolution {
        public int trap(int[] height) {
            if (height == null || height.length < 3) {
                return 0;
            }
            int len = height.length;
            int[] leftMax = new int[len];
            int[] rightMax = new int[len];
            leftMax[0] = height[0];
            rightMax[len - 1] = height[len - 1];
            int result = 0;
            for (int i = 1; i < len; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }
            for (int i = len - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }
            for (int i = 0; i < len; i++) {
                result += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            
            return result;
        }
    }
}