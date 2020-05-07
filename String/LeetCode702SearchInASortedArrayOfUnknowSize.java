/**
 * https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
 */
public class LeetCode702SearchInASortedArrayOfUnknowSize {
    /**
     * Expand the boundary until the end value is larger than the target. Then do regular binary search.
     *
     * @param reader
     * @param target
     * @return
     */
    public int search(ArrayReader reader, int target) {
        if (reader == null) {
            return -1;
        }

        int index = 0;
        int start = 0;
        while (reader.get(index) < 2147483647){
            if (reader.get(index) == target) {
                return index;
            } else if (reader.get(index) < target) {
                index = index * 2 + 1;
            } else {
                break;
            }
        }

        while (start + 1 < index) {
            int mid = start + (index - start) / 2;
            if (reader.get(mid) < target) {
                start = mid;
            } else if (reader.get(mid) > target) {
                index = mid;
            } else {
                return mid;
            }
        }

        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(index) == target) {
            return index;
        }

        return -1;
    }

    private class ArrayReader {
        public int get(int index) {
            return index; // jibberish number to make the compiler happy.
        }
    }
}