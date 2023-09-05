package interview.livecoding.leetcode;

/**
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7, 6, 4, 3, 1};

        int[] prices = {3, 2, 4, 1};
//        int[] prices = {};

        System.out.println(getMaximumProfit_2(prices));
    }

    /*
        Time complexity: O(n)O(n)O(n)
        The algorithm iterates through the array of stock prices once, performing constant-time operations at each step.
        Therefore, the time complexity is linear in the size of the input array.

        Space complexity: O(1)O(1)O(1)
        The algorithm uses a constant amount of extra space to store variables like min_price and maxprof.
        The space complexity remains constant regardless of the size of the input array.
     */
    private static int getMaximumProfit(int[] prices) {
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int diff = prices[j] - prices[i];
                if (diff > result) {
                    result = diff;
                }
            }
        }
        return result;
    }

    private static int getMaximumProfit_2(int[] prices) {
        int minPrice = prices[0];
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
//            System.out.println(prices[i] +  " - " + minPrice  + " - " + result);
            result = Math.max(result, prices[i] - minPrice);
//            System.out.println(prices[i] +  " - " + minPrice  + " - " + result);
            minPrice = Math.min(prices[i], minPrice);
//            System.out.println(prices[i] +  " - " + minPrice  + " - " + result);
//            System.out.println();
        }
        return result;
    }

}
