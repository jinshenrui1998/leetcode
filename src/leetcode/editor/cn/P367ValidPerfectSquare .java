package leetcode.editor.cn;

//Java：有效的完全平方数
public class P367ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        int res = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if ((long) mid * mid > num) {
                right = mid - 1;
            } else if ((long) mid * mid < num){
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

