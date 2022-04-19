package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：水果成篮
public class P904FruitIntoBaskets{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
//这题掌握情况较差
//题目，找到数组中长度最长的一片区域，该区域最多只能有两种不同值
//Hashmap中存储 ：(值，出现该值的最后一个下标）

//实现过程中：如果碰见1213（块状，非单个元素）的情况，在执行到3时
//hashmap中 (2, index2) (1, index1)，   index1 > index2
//所以left = index2 + 1。即把前面的1（第一个） ， 2块都给删除了
class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int res = 0;
        HashMap map = new HashMap();
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], right);
            if (map.size() > 2) {
                int minIndex = Integer.MAX_VALUE;
                for (Object o : map.values()) {
                    if (((int)o) < minIndex) {
                        minIndex = (int)o;
                    }
                }
                map.remove(fruits[minIndex]);
                left = minIndex + 1;
            }
            //经过上面的处理之后无论进不进if，这里的left和right都是
            //当前值往前数的一片合法区域的闭区间
            res = Math.max(right - left + 1, res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

