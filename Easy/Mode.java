package Easy;

/**
 * LeetCode 501. Find Mode in Binary Search Tree
 * Given the root of a binary search tree (BST), find the mode(s) (the most frequently occurred element) in it.
 * If the tree has more than one mode, return them in any order.
 * Assume a BST is defined as follows:
 * - The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * - The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 * Constraints:
 * - The number of nodes in the tree is in the range [1, 10^4].
 * - -10^5 <= Node.val <= 10^5
 * Follow up: Could you do that without using any extra space? (O(1) space complexity, excluding the recursive stack)
 */
import java.util.*;

public class Mode {
    private int maxCount = 0;
    private int curCount = 0;
    private Integer prev = null;
    private List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != null && node.val == prev) {
            curCount++;
        } else {
            curCount = 1;
        }
        if (curCount > maxCount) {
            maxCount = curCount;
            result.clear();
            result.add(node.val);
        } else if (curCount == maxCount) {
            result.add(node.val);
        }
        prev = node.val;
        inorder(node.right);
    }

    public static void main(String[] args) {
        Mode s = new Mode();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(2)));
        int[] modes = s.findMode(root);
        System.out.println("Modes: " + Arrays.toString(modes));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}