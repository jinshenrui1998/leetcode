package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//Java：字母异位词分组
public class P49GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //思路：建立一个map，以排序后的串为键，以原串（同为字母异味词的串）
    //      连接起来的为值.
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new LinkedList<>();
        for (String curString : strs) {
            char[] tmp = curString.toCharArray();
            int[] record = new int[26];
            //下面的整个过程也可用Array.sort代替
            for (char c : tmp) {
                record[c - 'a']++;
            }
            StringBuilder strBld = new StringBuilder();
            for (int i = 0; i < record.length; i++) {
                while (record[i] > 0) {
                    strBld.append('a' + i);
                    record[i]--;
                }
            }

            String legalString = strBld.toString();
            //这里主要有一个新方法getOrDefault，要细品
            List<String> stringList = map.getOrDefault(legalString, new LinkedList<String>());
            stringList.add(curString);
            map.put(legalString, stringList);
        }
        for (List<String> strings : map.values()) {
            res.add(strings);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

