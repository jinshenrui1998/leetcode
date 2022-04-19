package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Java：两个数组的交集 II
//通过数组实现哈希，和通过set，map实现哈希
//数组：对于在一定范围内的数据，使用数组速度更快，空间更小。
//比如字符（26）
//但是如果范围大（比如3万个整数，就很费空间）
public class P350IntersectionOfTwoArraysIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 ||nums2 == null || nums2.length == 0)
            return null;
        HashMap<Integer, Integer> map1 = new HashMap();
        for (int tmp : nums1) {
            int count = map1.getOrDefault(tmp, 0);
            map1.put(tmp, count + 1);
        }
        int[] ans = new int[nums1.length];
        int index = 0;
        for(int tmp : nums2) {
            int count = map1.getOrDefault(tmp, 0);
            if (count > 0) {
                ans[index++] = tmp;
                count--;
                if (count > 0) {
                    map1.put(tmp, count);
                } else {
                    map1.remove(tmp);
                }
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

