package Easy;

/**
 * LeetCode 88. Merge Sorted Array
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead be stored inside nums1.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0) {
            nums1[k--] = (i >= 0 && nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
    }

    public static void main(String[] args) {
        MergeSortedArray sol = new MergeSortedArray();
        int[] nums1 = {1,2,3,0,0,0};
        sol.merge(nums1, 3, new int[]{2,5,6}, 3);
        System.out.println(java.util.Arrays.toString(nums1));
    }
}