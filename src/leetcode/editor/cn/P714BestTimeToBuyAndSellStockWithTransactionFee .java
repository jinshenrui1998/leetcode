package leetcode.editor.cn;
//Java：买卖股票的最佳时机含手续费
public class P714BestTimeToBuyAndSellStockWithTransactionFee{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //这题的贪心策略很难，建议动态规划 done

    //如果使用贪心策略，就是最低值买，最高值（如果算上手续费还盈利）就卖。
    //此时无非就是要找到两个点，买入日期，和卖出日期。
    //买入日期：其实很好想，遇到更低点就记录一下。
    //卖出日期：这个就不好算了，但也没有必要算出准确的卖出日期，只要当前价格大于（最低价格+手续费），
    //就可以收获利润，至于准确的卖出日期，就是连续收获利润区间里的最后一天（并不需要计算是具体哪一天）。
    public int maxProfit(int[] prices, int fee) {
        int buy = prices[0] + fee;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                res += prices[i] - buy;
                //这里隐藏的细节，当你卖出后，再次进购价，可以不考虑fee
                //因为这里不加入fee，就可以把这个看做持有，和后面的更高价，看做一次交易
                buy = prices[i];
            } else if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

