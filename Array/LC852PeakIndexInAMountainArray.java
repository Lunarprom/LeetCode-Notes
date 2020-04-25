public class LC852PeakIndexInAMountainArray {
  /**
   * Binary search, 左闭右开的写法
   * Runtime: 0 ms, faster than 100.00% of Java online submissions for Peak Index in a Mountain Array.
   * Memory Usage: 39.5 MB, less than 80.00% of Java online submissions for Peak Index in a Mountain Array.
   */
  class Solution {
      public int peakIndexInMountainArray(int[] A) {
          if (A == null || A.length == 0) {
              return 0;
          }
          int start = 0;
          int end = A.length;
          while (start < end) {
              int mid = start + (end - start) / 2;
              if (A[mid] < A[mid + 1]) {
                  start = mid + 1;
              } else {
                  end = mid;
              }
          }
          
          return start;
      }
  }
}