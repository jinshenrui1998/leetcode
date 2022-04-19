package leetcode.editor.cn;

import java.util.Arrays;

//Java：无重叠区间
public class P435NonOverlappingIntervals{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
//自己想的
//class Solution {
//    public int eraseOverlapIntervals(int[][] intervals) {
//        if (intervals.length <= 1) return 0;
//        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//        int resNum = 0;
//        int end = intervals[0][1];
//        for (int i = 1; i < intervals.length; i++) {
//            if (intervals[i][0] < end) {
//                resNum++;
//                //当出现重叠时，这里相当于要选择删除哪一个
//                //那肯定删除end大的，留下end小的
//                end = Math.min(end, intervals[i][1]);
//            } else {
//                end = intervals[i][1];
//            }
//        }
//        return resNum;
//    }
//}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        //按照end区间升序排，
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int resNum = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //如果当前边缘小于后一个起始值，那么就不重叠，直接更新
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
            } else {
            //如果当前边缘大于后一个的起始值，那么就重叠，结果加一
            //默认删除后一个，因为删除end边缘大 可以删的最少 后面的效果更好是贪心
            //所以这里直接就不更新end， 就是删除后一个， 就比上面那种方法减少了一个步骤
                resNum++;
            }
        }
        return resNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

