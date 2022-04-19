package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//Java：用最少数量的箭引爆气球
public class P452MinimumNumberOfArrowsToBurstBalloons{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //自己思路
    //先按照第一个维度排序，排序后，若后一个值的start小于前一个值的end，那么就可以少用一根箭
    //而且 有个细节重点 比如 球 1，2用了一根箭，这时候评判指标应该仍然用1 去判断 3
    //如果不行那就多一根箭，并且更新评判指标,因为
    //1. 3的start都不行，那么后面的start更不行
    //2. 1，2一根箭，后面评判指标为3 是最优解（只用两根箭，而且评判指标对后面更友好）
    //优于 2 3一根箭，评判指标为2

    //直觉上来看，貌似只射重叠最多的气球，用的弓箭一定最少，那么有没有当前重叠了三个气球，我射两个，
    //留下一个和后面的一起射这样弓箭用的更少的情况呢？
    //尝试一下举反例，发现没有这种情况。
    public int findMinArrowShots(int[][] points) {
        //两个指标从小到大排
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int resNum = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            //超出范围，多射一根箭，并且更新end
            if (points[i][0] > end) {
                resNum++;
                end = points[i][1];
            } else {
                //这里存在后面的end小于前面end的情况，所以要取最小值,作为射爆区间
                end = Math.min(end, points[i][1]);
            }
        }
        return resNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

