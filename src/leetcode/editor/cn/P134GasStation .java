package leetcode.editor.cn;
//Java：加油站
public class P134GasStation{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //自己想的：贪心思路
    //到每个结点都有一个加，一个耗，如果加的大于耗的，那么就开始累计
    //这样到节点时就相当于有正收益和负收益。
    //经过多个节点，只要当前累计的收益是正的就行
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int sum = 0; //累计收益
//        int resIndex = -1;
//        int nodeNum = 0;
//        for (int i = 0; i < 2 * gas.length; i++) {
//            int k = i % gas.length;
//            int count = gas[k] - cost[k];//单独收益
//            sum += count;
//            if (sum < 0) {
//                sum = 0;
//                resIndex = -1;
//                nodeNum = 0;
//            } else if (resIndex == -1){
//                resIndex = k;
//                nodeNum++;
//            } else {
//                nodeNum++;
//            }
//            if (nodeNum == gas.length) return resIndex;
//        }
//        return -1;
//    }
    //卡尔哥的，思路巧妙
    //计算totalSum，如果totalSum >= 0 就可以，小于0就不行
    //通过更新index，找到最佳起始位置的下标，该下标也不一定可以，但是如果可以，就一定是该下标
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                curSum = 0;
                index = i + 1;
            }
        }
        return totalSum >= 0 ? index : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

