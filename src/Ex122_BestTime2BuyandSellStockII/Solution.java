package Ex122_BestTime2BuyandSellStockII;

/*
    For the second version, we can do as many transition as we like
 */

public class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int singleTrans = 0;
        int profitSoFar = 0;
        for (int curPrice : prices) {
            if (curPrice <= buyPrice || curPrice - buyPrice < singleTrans) {
                // 1) If current price is smaller than the price we bought before,
                // that means we should sell it before
                // 2) If current price is less than yesterday's price, we also need to sell it before
                buyPrice = curPrice;
                profitSoFar += singleTrans;
                singleTrans = 0;
            } else {
                // here means we gain a higher price, can just keep it to tomorrow
                singleTrans = curPrice - buyPrice;
            }
        }
        profitSoFar += Math.max(0, singleTrans);
        return profitSoFar;
    }

    public static void main(String[] args) {
        Solution use = new Solution();
        int[] test = new int[]{7,6,4,3,1};
        System.out.println(use.maxProfit(test));
    }
}
