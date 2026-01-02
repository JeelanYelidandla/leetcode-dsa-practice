package com.leetcode.slidingwindow;

public class BestTimeToBuyAndSellStockII {

/*
    You must sell before you buy again.
    Return the maximum profit you can achieve.
    We want to grab all profit opportunities.

➡️ Think of it like this: every time price goes up from one day to the next, we take that profit.
That’s equivalent to buying at every valley and selling at every peak.

 ✅ Example
    Input: prices = [7,1,5,3,6,4]
    Output: 7
    Explanation:
    Buy at 1, sell at 5 → profit = 4
    Buy at 3, sell at 6 → profit = 3
    Total profit = 7

🔎 Dry Run: prices = [7,1,5,3,6,4]

| Day | Price | Price\[i] - Price\[i-1] | Condition | Profit |
| --- | ----- | ----------------------- | --------- | ------ |
| 1   | 1     | -                       | -         | 0      |
| 2   | 5     | 5 - 1 = 4               | ✅ add     | 4      |
| 3   | 3     | 3 - 5 = -2              | ❌ skip    | 4      |
| 4   | 6     | 6 - 3 = 3               | ✅ add     | 7      |
| 5   | 4     | 4 - 6 = -2              | ❌ skip    | 7      |


✍️ Pseudo-code (your step-by-step style)

Initialize profit = 0
Iterate through prices (from day 1 to n-1):
    If price[i] > price[i-1]:
        profit += (price[i] - price[i-1])

Return profit

------------------

 */
    public static int maxProfit(int[] prices) {
      int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i - 1];
            }
        }
      return  profit;

    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(prices);
        System.out.println("Maximum Profit: " + result);
    }
}
