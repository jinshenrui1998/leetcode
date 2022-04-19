package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：合并区间
public class P56MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        int[] curPath = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            //区间不重叠了就添加，区间重叠了就合并 不添加
            if (intervals[i][0] > curPath[1]) {
                //大于 不重叠 不合并 添加
                list.add(curPath);
                curPath = intervals[i];
            } else {
                curPath[1] = Math.max(curPath[1], intervals[i][1]);
            }
        }
        list.add(curPath);
        return list.toArray(new int[list.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

