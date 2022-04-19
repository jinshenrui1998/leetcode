package leetcode.editor.cn;

import java.util.Arrays;

//Java：替换空格
public class P剑指 Offer 05TiHuanKongGeLcof{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //方法：原地变化的关键在于 扩容后，从后往前走指针
    //因为扩容是括在后面的，这样右指针覆盖的内容都是已经记录过的
    //一些接口的运用，如何动态扩容字符串
    public String replaceSpace(String s) {
        StringBuilder strHelp = new StringBuilder();
        int rawSize = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                strHelp.append("  ");
            }
        }
        s += strHelp.toString();

        int left = rawSize - 1;
        int right= s.length() - 1;
        //这里需要修改字符串，而String不能修改，所以就把char[]取出来改完弄个新的
        char[] ch = s.toCharArray();
        while (left >= 0) {
            if (ch[left] == ' ') {
                ch[right--] = '0';
                ch[right--] = '2';
                ch[right] = '%';
            } else {
                ch[right] = ch[left];
            }
            right--;
            left--;
        }
        return new String(ch);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

