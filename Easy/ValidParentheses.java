package Easy;

/**
 * LeetCode 20. Valid Parentheses
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 * 
 * Example 1:
 * Input: s = "()"
 * Output: true
 * 
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Example 3:
 * Input: s = "(]"
 * Output: false
 * 
 * Example 4:
 * Input: s = "([])"
 * Output: true
 * 
 * Constraints:
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 * 
 * Time Complexity: O(n) - Single pass through the string
 * Space Complexity: O(n) - Stack to store opening brackets
 */
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push to stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            // If it's a closing bracket
            else {
                // Stack empty means no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                // Check if brackets match
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        // All brackets should be matched
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        
        System.out.println("(): " + solution.isValid("()"));           // true
        System.out.println("()[]{}: " + solution.isValid("()[]{}"));   // true
        System.out.println("(]: " + solution.isValid("(]"));           // false
        System.out.println("([]): " + solution.isValid("([])"));       // true
        System.out.println("([)]: " + solution.isValid("([)]"));       // false
        System.out.println("{[]}: " + solution.isValid("{[]}"));       // true
    }
}