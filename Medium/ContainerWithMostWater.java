package Medium;

/**
 * LeetCode 11. Container With Most Water
 * You are given an integer array height of length n.
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater sol = new ContainerWithMostWater();
        System.out.println(sol.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(sol.maxArea(new int[]{1,1}));
    }
}