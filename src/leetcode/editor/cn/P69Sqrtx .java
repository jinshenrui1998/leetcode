package leetcode.editor.cn;

//Java：Sqrt(x)
public class P69Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}

//细节：int乘法防止溢出使用double
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int res = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if ((long)mid * mid > x){
                right = mid - 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

