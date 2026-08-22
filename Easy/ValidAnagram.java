package Easy;

/**
 * LeetCode 242. Valid Anagram
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }

    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();
        System.out.println(sol.isAnagram("anagram", "nagaram"));
        System.out.println(sol.isAnagram("rat", "car"));
    }
}