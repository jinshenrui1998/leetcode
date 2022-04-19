package leetcode.editor.cn;
//Java：买卖股票的最佳时机 II
public class P122BestTimeToBuyAndSellStockIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
 class Solution {
     public int maxProfit(int[] prices) {
         if (prices.length <= 1) return 0;
         int res = 0;
         for (int i = 1; i < prices.length; i++) {
             if (prices[i] > prices[i - 1]) {
                 res += prices[i] - prices[i - 1];
             }
         }
         return res;
     }
 }
//class Solution {
//    public int maxProfit(int[] prices) {
//        int result = 0;
//        for (int i = 1; i < prices.length; i++) {
//            result += Math.max(prices[i] - prices[i - 1], 0);
//        }
//        return result;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

