package Easy;

/**
 * LeetCode 121. Best Time to Buy and Sell Stock
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Maximize profit by choosing a single day to buy one stock and choosing a different day in the future to sell.
 * Return the maximum profit you can achieve. If no profit, return 0.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) minPrice = price;
            else if (price - minPrice > maxProfit) maxProfit = price - minPrice;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock sol = new BestTimeToBuyAndSellStock();
        System.out.println(sol.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(sol.maxProfit(new int[]{7,6,4,3,1}));
    }
}