package Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 464. Can I Win
 * https://leetcode.com/problems/can-i-win/
 *
 * Two players take turns picking a distinct integer from 1..maxChoosableInteger.
 * The player who first makes the running total reach or exceed desiredTotal wins.
 *
 * Input : maxChoosableInteger, desiredTotal
 * Output: true if the first player to move can force a win, otherwise false.
 *
 * Constraints:
 *   1 <= maxChoosableInteger <= 20
 *   0 <= desiredTotal <= 300
 *
 * Approach (memoized game theory over a bitmask):
 *   - State = the set of integers already taken, encoded as a bitmask (bit i-1 set
 *     means integer i was used). This is the only state we need: the running total
 *     is just the sum of the set, so the remaining target is implied by the mask.
 *   - canWin(used, remaining): can the player whose turn it is force a win?
 *     * remaining <= 0 means the previous player already reached the target, so we lost.
 *     * Try every unused number i. If i >= remaining we win immediately by taking it.
 *       Otherwise we win iff the opponent cannot force a win from the next state.
 *   - Early rejections: a target <= 0 is already satisfied before anyone moves; a
 *     target <= n is won at once by picking a number that large; if 1+2+...+n is
 *     below the target nobody can ever reach it.
 *
 * Complexity: O(n * 2^n) time and O(2^n) space, where n = maxChoosableInteger.
 *   Each of the 2^n masks is solved at most once (memoized) and scans at most n
 *   choices, so the work is bounded by 2^n * n. Memo storage is O(2^n) and the
 *   recursion depth is at most n <= 20.
 */
public class CanIWin {
    private int n;
    private Map<Integer, Boolean> memo;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;                      // already reached
        if (desiredTotal <= maxChoosableInteger) return true;    // pick it and win now
        int maxTotal = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (maxTotal < desiredTotal) return false;              // nobody can reach it

        this.n = maxChoosableInteger;
        this.memo = new HashMap<>();
        return canWin(0, desiredTotal);
    }

    private boolean canWin(int used, int remaining) {
        // The previous player already reached the target: this side loses.
        if (remaining <= 0) return false;
        Boolean cached = memo.get(used);
        if (cached != null) return cached;

        for (int i = 1; i <= n; i++) {
            int bit = 1 << (i - 1);
            if ((used & bit) != 0) continue;
            // Taking i reaches the target on this move -> immediate win.
            if (i >= remaining) return true;
            // Hand the turn over; if the opponent cannot force a win, we can.
            if (!canWin(used | bit, remaining - i)) {
                memo.put(used, true);
                return true;
            }
        }
        memo.put(used, false);
        return false;
    }

    public static void main(String[] args) {
        CanIWin sol = new CanIWin();
        System.out.println(sol.canIWin(10, 11));  // false
        System.out.println(sol.canIWin(10, 0));   // true
        System.out.println(sol.canIWin(10, 1));   // true
    }
}