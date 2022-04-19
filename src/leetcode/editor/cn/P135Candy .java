package leetcode.editor.cn;
//Java：分发糖果
public class P135Candy{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        //思路，先保证，右边评分高于左边的孩子，糖果数会更多
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        //再保证，左边评分高的，糖果数会大于右边
        //这里只能从右往左，因为是根据右边的来确定左边的
        //（左边的个数是根据右边来确认的）
        // 所以要先算出来右边的，所以只能从右往左遍历
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                //这里就要综合考虑两边的情况，保证ratings高的孩子，即大于左边的糖果也大于右边
                //取更大的选择上
                //担心：从左往右的时候遍历的秩序（右边评分高于左边的孩子，糖果数会更多）会不会被从右往左打破
                //答案：不会， 遍历到每一个结点的时候，对结点的糖果数量进行更新，只会往大更新
                // 假设从右往左，更新到下标为k的点，更新之后，这个点肯定满足右秩序，而且这个点的数只会变大
                // 所以肯定也满足左秩序
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);

            }
        }
        int sum = 0;
        for (int tmp : candies) {
            sum += tmp;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

