package Easy;

/**
 * LeetCode 283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes sol = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        sol.moveZeroes(nums);
        System.out.println(java.util.Arrays.toString(nums));
    }
}