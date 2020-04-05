/**
 * Solution 1: 暴力解法：遍历数组，排序，得到第K大的数，复杂度O(NlogN)如果用快排/merge sort/heap sort的话
 * Solution 2: 优先队列：本质上就也还是merge sort。
 *   声明一个size为k的priority queue然后一直往里面放数，最后再一直取数直到最后一个
 *   如果放进去的数字超过k会怎么样 => 把多余的数移除否则影响最后返还的结果
 *   时间复杂度是O(NlogK)。因为每次往堆里添加和移除元素的操作都是logK的复杂度，K是堆的size。
 * Solution 3: Quick Select (Quick Sort的变种) 把所有比第K小的都挪到左边，把所有比第K大的都挪到右边
 *   时间复杂度可以降到平均O(N)最坏O(N^2)
 */
class Solution {

    public class HeapSolution {
        public int findKthLargest(int[] nums, int k) {
            int result = -1;
            if (nums == null || nums.length < k) {
                return result;
            }
            
            // PriorityQueue is "the smallest the first"
            PriorityQueue<Integer> heap  = new PriorityQueue<Integer>(k);
            for (int num : nums) {
                heap.add(num);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
            
            return heap.poll();
        }
    }

    public class QuickSelectSolution {
        private int[] nums;
        public int findKthLargest (int[] nums, int k) {
            this.nums = nums;
            int size = nums.length;
            // Convert this problem to finding the (N-k) smallest number.
            return quickSelect(0, size - 1, size - k);
        }

        private void swap(int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        private int partition(int left, int right, int pivot) {
            int pivotVal = nums[pivot];
            swap(pivot, right); // Move the pivot to the end of the array;
            int resultIndex = left;
            for (int i = left; i < right; i++) { // equal does not matter since right already equals to pivot
                if (nums[i] < pivotVal) {
                    swap(i, resultIndex);
                    resultIndex++;
                }
            }
            swap(resultIndex, right); // swap the pivot back to the current index.
            return resultIndex;
        }

        private int quickSelect(int left, int right, int k) {
            // Null/Empty case check
            if (nums == null || right < left) {
                return - 1;
            }
            // If the array only contains one element.
            if (left == right) {
                return nums[left];
            }
            Random random = new Random();
            int seed = left + random.nextInt(right - left);
            int pivot = partition(left, right, seed);
            if (pivot == k) {
                return nums[k];
            } else if (pivot < k) {
                return quickSelect(pivot + 1, right, k);
            } else {
                return quickSelect(left, pivot - 1, k);
            }
        }
    }
    
}
