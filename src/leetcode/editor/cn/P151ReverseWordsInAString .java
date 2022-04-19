package leetcode.editor.cn;
//Java：翻转字符串里的单词
public class P151ReverseWordsInAString{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //这个题最重要的是想对方法，如果直接来，把单词分段之后交换，
    //会面临一个交换单词长度不同，整个字符串都要重构的问题
    //所以这里采用的方法是
    //1.移除多余空格
    //2.反转整个字符串
    //3.反转每个单词
    //这样可以做到反转单词的位置
    public String reverseWords(String s) {
        char[] chs = s.toCharArray();
        int boundary = removeSpace(chs);
        reverse(chs, 0, boundary);
        int left = 0;
        for (int i = 0; i <= boundary; i++) {
            if (chs[i] == ' '){
                reverse(chs, left, i - 1);
                left = i + 1;
            }
        }
        reverse(chs, left, boundary);
        return new String(chs,0, boundary + 1);
    }
    //移除多余空格一定要找准方法
    public int removeSpace(char[] ch) {
        int left = 0;
        int right = 0;
        while (right < ch.length && ch[right] == ' ') right++;
        while (right < ch.length) {
            //这里的逻辑是 赋值情况分为三种
            //1. ch[right]不为空格直接就赋值
            //2. ch[right]如果为空格，那么后一个不越界（即不为最后一个)且后一个不是空格就赋值
            //这里其实还可以从反面来考虑
            //什么时候不赋值
            //ch[right] == ' ' && (right + 1 < ch.length || ch[right+1] == ' ')
            //right处为空格，如果是最后一个或者后一个为空格，那么就不赋值
            //给这个判别式加上一个 ! 就可以得到下面的判别式
            if (ch[right] != ' ' || (right + 1 < ch.length && ch[right + 1] != ' ')) {
                ch[left++] = ch[right];
            }
            right++;
        }
        return left - 1;
    }
    public void reverse(char[] ch, int left, int right) {
        while (left < right) {
            char tmp = ch[left];
            ch[left++] = ch[right];
            ch[right--] = tmp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

