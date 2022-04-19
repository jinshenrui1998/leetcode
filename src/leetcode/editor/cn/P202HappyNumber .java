package leetcode.editor.cn;
//Java：快乐数

import java.util.HashSet;

public class P202HappyNumber{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //题目中说了会 无限循环，那么也就是说求和的过程中，
    //sum会重复出现，这对解题很重要！
    //当我们遇到了要快速判断一个元素是否出现集合里的时候，就要考虑哈希法了。
    //所以这道题目使用哈希法，来判断这个sum是否重复出现，
    //如果重复了就是return false， 否则一直找到sum为1为止。
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n != 0){
                int tmp = n % 10;
                sum += tmp * tmp;
                n = n / 10;
            }
            n = sum;
            if (!set.add(n)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

