package Easy;

/**
 * LeetCode 53. Maximum Subarray
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray sol = new MaximumSubarray();
        System.out.println(sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(sol.maxSubArray(new int[]{1}));
        System.out.println(sol.maxSubArray(new int[]{5,4,-1,7,8}));
    }
}