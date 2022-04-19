package leetcode.editor.cn;
import java.util.HashMap;
//Java：四数相加 II
public class P454FourSumIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*  5本题解题步骤：
    首先定义 一个unordered_map，key放a和b两数之和，value 放a和b两数之和出现的次数。
    遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。
    定义int变量count，用来统计 a+b+c+d = 0 出现的次数。
    在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就用count把map中key对应的value也就是出现次数统计出来。
    最后返回统计值 count 就可以了
 */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int tmp1 : nums1) {
            for (int tmp2 : nums2) {
                int sum = tmp1 + tmp2;
                int count = map.getOrDefault(sum, 0);
                map.put(sum, count + 1);
            }
        }
        int ans = 0;
        for (int tmp3 : nums3) {
            for (int tmp4 : nums4) {
                int sum = tmp3 + tmp4;
                Integer count = map.get(-sum);
                if (count != null) {
                    ans += count;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

