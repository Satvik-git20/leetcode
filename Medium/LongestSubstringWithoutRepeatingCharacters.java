package Medium;

/**
 * LeetCode 3. Longest Substring Without Repeating Characters
 * 
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * Constraints:
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * 
 * Time Complexity: O(n) - Each character visited at most twice
 * Space Complexity: O(min(m, n)) - m is the charset size (128 for ASCII)
 */
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If character is already in current window, move left pointer
            if (charIndexMap.containsKey(currentChar)) {
                // Move left to the position after the last occurrence
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }
            
            // Update the last seen index of current character
            charIndexMap.put(currentChar, right);
            
            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    // Alternative: Using array for ASCII characters (faster)
    public int lengthOfLongestSubstringArray(String s) {
        int[] charIndex = new int[128];
        for (int i = 0; i < 128; i++) {
            charIndex[i] = -1;
        }
        
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            if (charIndex[currentChar] != -1) {
                left = Math.max(left, charIndex[currentChar] + 1);
            }
            
            charIndex[currentChar] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = 
            new LongestSubstringWithoutRepeatingCharacters();
        
        System.out.println("abcabcbb: " + solution.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println("bbbbb: " + solution.lengthOfLongestSubstring("bbbbb"));       // 1
        System.out.println("pwwkew: " + solution.lengthOfLongestSubstring("pwwkew"));     // 3
        System.out.println("Empty: " + solution.lengthOfLongestSubstring(""));             // 0
        System.out.println(" ": " + solution.lengthOfLongestSubstring(" "));               // 1
        System.out.println("au: " + solution.lengthOfLongestSubstring("au"));             // 2
    }
}