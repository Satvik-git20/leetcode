package Easy;

/**
 * LeetCode 26. Remove Duplicates from Sorted Array
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
 * such that each unique element appears only once. Return the number of unique elements.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray sol = new RemoveDuplicatesFromSortedArray();
        int[] nums1 = {1,1,2};
        int k1 = sol.removeDuplicates(nums1);
        System.out.println("k=" + k1 + ", nums=" + java.util.Arrays.toString(java.util.Arrays.copyOf(nums1, k1)));
        
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int k2 = sol.removeDuplicates(nums2);
        System.out.println("k=" + k2 + ", nums=" + java.util.Arrays.toString(java.util.Arrays.copyOf(nums2, k2)));
    }
}