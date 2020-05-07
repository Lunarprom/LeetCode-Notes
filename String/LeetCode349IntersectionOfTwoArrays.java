import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class LeetCode349IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        final Set<Integer> numbers = new HashSet<Integer>();
        final Set<Integer> intersection = new HashSet<Integer>();
        for (Integer num : nums1) {
            numbers.add(num);
        }

        for (Integer num : nums2) {
            if (numbers.contains(num)) {
                intersection.add(num);
            }
        }
        int[] result = new int[intersection.size()];
        Iterator it = intersection.iterator();
        int i = 0;
        while (it.hasNext()) {
            result[i++] = (int)it.next();
        }

        return result;
    }
}
