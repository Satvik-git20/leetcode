package Easy;

/**
 * LeetCode 9. Palindrome Number
 * 
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * 
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * 
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * 
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * 
 * Constraints:
 * -2^31 <= x <= 2^31 - 1
 * 
 * Follow up: Could you solve it without converting the integer to a string?
 * 
 * Time Complexity: O(log10(n)) - We divide the input by 10 in each iteration
 * Space Complexity: O(1)
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        // Numbers ending with 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }
        
        // For even length: x == reversedHalf
        // For odd length: x == reversedHalf / 10 (middle digit doesn't matter)
        return x == reversedHalf || x == reversedHalf / 10;
    }
    
    // Alternative solution: Convert to string
    public boolean isPalindromeString(int x) {
        String str = String.valueOf(x);
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        PalindromeNumber solution = new PalindromeNumber();
        
        System.out.println("121: " + solution.isPalindrome(121));    // true
        System.out.println("-121: " + solution.isPalindrome(-121));  // false
        System.out.println("10: " + solution.isPalindrome(10));      // false
        System.out.println("0: " + solution.isPalindrome(0));        // true
        System.out.println("12321: " + solution.isPalindrome(12321)); // true
    }
}