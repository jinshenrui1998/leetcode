package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Java：两个数组的交集
public class P349IntersectionOfTwoArrays{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int tmp : nums1) {
            set1.add(tmp);
        }
        for (int tmp : nums2) {
            if (set1.contains(tmp)) {
                set2.add(tmp);
            }
        }
        int[] ansArr = new int[set2.size()];
        int i = 0;
        for (int tmp : set2) {
            ansArr[i++] = tmp;
        }
        return ansArr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

