"""
LeetCode 464. Can I Win
https://leetcode.com/problems/can-i-win/

Two players take turns picking a distinct integer from 1..maxChoosableInteger.
The player who first makes the running total reach or exceed desiredTotal wins.

Input : maxChoosableInteger, desiredTotal
Output: True if the first player to move can force a win, otherwise False.

Constraints:
    1 <= maxChoosableInteger <= 20
    0 <= desiredTotal <= 300

Approach (memoized game theory over a bitmask):
  - State = the set of integers already taken, encoded as a bitmask (bit i-1 set
    means integer i was used). That is the only state needed: the running total is
    the sum of the set, so the remaining target is implied by the mask.
  - can_win(used, remaining): can the player whose turn it is force a win?
    * remaining <= 0 means the previous player already reached the target, so we lost.
    * Try every unused number i. If i >= remaining we win immediately by taking it.
      Otherwise we win iff the opponent cannot force a win from the next state.
  - Early rejections: a target <= 0 is already satisfied before anyone moves; a
    target <= n is won at once by picking a number that large; if 1+2+...+n is
    below the target nobody can ever reach it.

Complexity: O(n * 2^n) time and O(2^n) space, where n = maxChoosableInteger.
  Each of the 2^n masks is solved at most once (memoized) and scans at most n
  choices, so the work is bounded by 2^n * n. Memo storage is O(2^n) and the
  recursion depth is at most n <= 20.
"""


class CanIWin:
    def can_i_win(self, max_choosable_integer: int, desired_total: int) -> bool:
        if desired_total <= 0:
            return True                                       # already reached
        if desired_total <= max_choosable_integer:
            return True                                       # pick it and win now
        max_total = max_choosable_integer * (max_choosable_integer + 1) // 2
        if max_total < desired_total:
            return False                                      # nobody can reach it

        n = max_choosable_integer
        memo = {}

        def can_win(used: int, remaining: int) -> bool:
            # The previous player already reached the target: this side loses.
            if remaining <= 0:
                return False
            if used in memo:
                return memo[used]

            for i in range(1, n + 1):
                bit = 1 << (i - 1)
                if used & bit:
                    continue                                  # already taken
                # Taking i reaches the target on this move -> immediate win.
                if i >= remaining:
                    memo[used] = True
                    return True
                # Hand the turn over; if the opponent cannot force a win, we can.
                if not can_win(used | bit, remaining - i):
                    memo[used] = True
                    return True

            memo[used] = False
            return False

        return can_win(0, desired_total)


if __name__ == "__main__":
    sol = CanIWin()
    print(sol.can_i_win(10, 11))  # false
    print(sol.can_i_win(10, 0))   # true
    print(sol.can_i_win(10, 1))   # true