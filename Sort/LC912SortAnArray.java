public class LC912SortAnArray {
	class MergeSortSolution {
	    public int[] sortArray(int[] nums) {
	        mergeSort(nums, 0, nums.length - 1);
	        
	        return nums;
	    }
	    
	    private void mergeSort(int[] nums, int left, int right) {
	        if (left >= right) {
	            return;
	        }
	        int mid = left + (right - left) / 2;
	        mergeSort(nums, left, mid);
	        mergeSort(nums, mid + 1, right);
	        merge(nums, left, mid, right);
	    }
	    
	    private void merge(int[] nums, int left, int mid, int right) {
	        int[] tmp = new int[right - left + 1];
	        int i = left;
	        int j = mid + 1;
	        int index = 0;
	        while (i <= mid && j <= right) {
	            if (nums[i] <= nums[j]) {
	                tmp[index++] = nums[i++];
	            } else {
	                tmp[index++] = nums[j++];
	            }
	        }
	        while (i <= mid) {
	            tmp[index++] = nums[i++];
	        }
	        while (j <= right) {
	            tmp[index++] = nums[j++];
	        }
	        for (index = 0; index < tmp.length; index++) {
	            nums[index + left] = tmp[index];
	        }
	    }
	}

	class QuickSortSolution {
	    public int[] sortArray(int[] nums) {
	        quickSort(nums, 0, nums.length - 1);
	        return nums;
	    }
	    
	    private void quickSort(int[] nums, int left, int right) {
	        if (left >= right) {
	            return;
	        }
	        int pIndex = partition(nums, left, right);
	        quickSort(nums, left, pIndex - 1);
	        quickSort(nums, pIndex + 1, right);
	    }
	    
	    private int partition(int[] nums, int left, int right) {
	        int pivot = nums[right];
	        int pIndex = left;
	        for (int i = left; i < right; i++) {
	            if (nums[i] < pivot) {
	                // swap nums[i] with pIndex
	                swap(nums, i, pIndex);
	                pIndex++;
	            }
	        }
	        // confirm the index for the pivot.
	        swap(nums, pIndex, right);
	        return pIndex;
	    }
	    
	    private void swap(int[] nums, int left, int right) {
	        int tmp = nums[left];
	        nums[left] = nums[right];
	        nums[right] = tmp;
	    }
	}
}