package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Hashtable;

//Java：有效的字母异位词
public class P242ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*    public boolean isAnagram(String s, String t) {
        // TODO: 2022/1/23 预处理

        CharMap map = new CharMap();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), 1);
        }
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), -1);
        }
        for (Integer o : map.values()) {
            if (o != 0) {
                return false;
            }
        }
        return true;

    }

    class CharMap extends HashMap<Character, Integer>{
        @Override
        public Integer put (Character key, Integer value) {
            return super.put(key, this.get(key) + value);
        }
        public Integer get (Character key) {
            if (containsKey(key)) {
                return super.get(key);
            }
            return 0;
        }
    }*/
    //这种方法比上面的方法更高效，时间，空间均更多
    //改进点如下：
    //1.由于 26字符 ASCII码的连续性 这一特点，采用数组代替hashmap
    //而此题不需要利用get的快速查找这一特点
    //2.采用增强for循环遍历s.toCharArray,从而在没有开辟新空间char[]的
    //情况下，增加了遍历速度

    public boolean isAnagram(String s, String t) {

        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

