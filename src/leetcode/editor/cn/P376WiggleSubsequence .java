package leetcode.editor.cn;
//Java：摆动序列
public class P376WiggleSubsequence{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //自己写，但不简洁，如果是同号的，那么就是递增或递减，递增要取最大，递减取最小，都是取最后一个，所以直接取
    //最后一个就行
//    public int wiggleMaxLength(int[] nums) {
//        if (nums.length == 1) return 1;
//        int res = 1;
//        int slow = 0;
//        Boolean flag = null;
//        for (int i = 1; i < nums.length; i++) {
//            boolean curFlag = nums[i] - nums[slow] > 0;
//            if (nums[i] == nums[slow]) continue;
//            if ((flag != null && curFlag == flag)) {
//                if (flag) {
//                    slow = nums[slow] > nums[i] ? slow : i;
//                } else {
//                    slow = nums[slow] < nums[i] ? slow : i;
//                }
//                continue;
//            }
//            slow = i;
//            res++;
//            flag = curFlag;
//        }
//        return res;
//    }

//    public int wiggleMaxLength(int[] nums) {
//        if (nums.length <= 1) return nums.length;
//        int res = 1;
//        int preDif = 0;
//        int curDif;
//        for (int i = 1; i < nums.length; i++) {
//            curDif = nums[i] - nums[i - 1];
//            //当前这个值纳不纳入res，和前一个差值是否等于0没有关系，只要当前不为0就行了
//            //
//            //而让preDif等于0也进入循环，可以处理最左端preDif如何设置的问题
//            //这个方法不太好想到，可以考虑使用自己的方法，好理解
//            if ((preDif <= 0 && curDif > 0) || (preDif >= 0 && curDif < 0)) {
//                res++;
//                preDif = curDif;
//            }
//        }
//        return res;
//    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int res = 1;
        Integer preDif = null;
        int curDif;
        for (int i = 1; i < nums.length; i++) {
            curDif = nums[i] - nums[i - 1];
            //当前这个值纳不纳入res，和前一个差值是否等于0没有关系，只要当前不为0就行了
            //
            //而让preDif等于0也进入循环，可以处理最左端preDif如何设置的问题
            //这个方法不太好想到，可以考虑使用自己的方法，好理解
            if (preDif == null) {
                if (curDif != 0)
                    res++;
                preDif = curDif;
            }
            if ((preDif <= 0 && curDif > 0) || (preDif >= 0 && curDif < 0)) {
                res++;
                preDif = curDif;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

