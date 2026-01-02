package com.leetcode.slidingwindow;

import java.io.IO;

public class BestTimeToBuyAndSellStock {

/*
    Summary
        Time Complexity:
        Initialization + loop → O(1 + n) = O(n)
    Space Complexity:
        Only variables minPrice & maxProfit → O(1)
    ✅ Final Answer:
        Time: O(n)
        Space: O(1)

| Line | Code                                | Time Complexity    | Space Complexity | Explanation                                             |
| ---- | ----------------------------------- | ------------------ | ---------------- | ------------------------------------------------------- |
| 1    | `int minPrice = Integer.MAX_VALUE;` | O(1)               | O(1)             | Assigns a constant value.                               |
| 2    | `int maxProfit = 0;`                | O(1)               | O(1)             | Assigns a constant value.                               |
| 3    | `for (int price : prices)`          | O(n)               | O(1)             | Iterates through array once.                            |
| 4    | `if (price < minPrice)`             | O(1) per iteration | O(1)             | Simple comparison.                                      |
| 5    | `minPrice = price;`                 | O(1) when executed | O(1)             | Updates variable.                                       |
| 6    | `maxProfit = Math.max(...)`         | O(1) per iteration | O(1)             | Computes max of two numbers.                            |
| 7    | `return maxProfit;`                 | O(1)               | O(1)             | Returns final value.                                    |
| 8    | `int[] prices = {...}`              | O(1)               | O(n)             | Creates input array (only in `main`, not part of algo). |
| 9    | `int result = maxProfit(prices);`   | O(n)               | O(1)             | Calls function, executes full algorithm.                |
| 10   | `System.out.println(...)`           | O(1)               | O(1)             | Prints output.                                          |

Logic:
Intuition:
    We need to buy at the lowest price seen so far.
    At each day, we check:
    If today’s price is less than our current minPrice, update minPrice.
    Otherwise, calculate profit = prices[i] - minPrice.
    Keep track of the maximum profit.

----------------------
//new int[]{7, 1, 5, 3, 6, 4})

Initialize minPrice = first price
Initialize maxProfit = 0

For each price in prices:
    If price < minPrice:
        minPrice = price
    Else:
        profit = price - minPrice
        maxProfit = max(maxProfit, profit)

Return maxProfit

 */
    public static int bestTimeToBuyAndSellStock(int priceArray[]){
        int minBuyPrice = priceArray[0]; // we can take max Integer value as Integer.MAX_VALUE
        int maxProfit = 0;
        for (int currentPrice : priceArray){
            if(currentPrice < minBuyPrice){
                minBuyPrice = currentPrice;
            }else{
                //Profit = Sell Price – Buy Price
                maxProfit = Math.max(maxProfit, currentPrice-minBuyPrice);
            }
        }
        return maxProfit;
    }
    static void main() {
        IO.println(BestTimeToBuyAndSellStock.bestTimeToBuyAndSellStock(new int[]{7, 2, 5, 3, 6, 4,1}));
    }
}
