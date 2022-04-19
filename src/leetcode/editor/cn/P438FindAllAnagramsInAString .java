package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：找到字符串中所有字母异位词
public class P438FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//滑动窗口，这里有一个小细节，返回一个序列，虽然最后返回的是这个序列的
//前下标，但是由于遍历后下标更方便操作和判断循环结束，所以就遍历后下标
//在最后由长度算一下前下标就行。
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //按照思路自己实现的
/*    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()){
            return new LinkedList<Integer>();
        }
        int[] recordS = new int[26];
        int[] recordP = new int[26];
        for(char c : s.substring(0, p.length() - 1).toCharArray()) {
            recordS[c - 'a']++;
        }
        for(char c : p.toCharArray()) {
            recordP[c - 'a']++;
        }
        char[] sChar = s.toCharArray();
        List<Integer> ans = new LinkedList<>();
        for (int i = p.length() - 1; i < sChar.length; i++) {
            recordS[sChar[i] - 'a']++;
            if (Arrays.equals(recordS, recordP)) {
                ans.add(i - p.length() + 1);
            }
            recordS[sChar[i - p.length() + 1] - 'a']--;
        }
        return ans;
    }*/
    //优化简洁版
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if(n < m) return res;
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for(int i = 0; i < m; i++){
            pCnt[p.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(sCnt, pCnt)){
            res.add(0);
        }
        for(int i = m; i < n; i++){
            sCnt[s.charAt(i - m) - 'a']--;
            sCnt[s.charAt(i) - 'a']++;
            if(Arrays.equals(sCnt, pCnt)){
                res.add(i - m + 1);
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

