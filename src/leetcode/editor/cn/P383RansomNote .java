package leetcode.editor.cn;
//Java：赎金信
public class P383RansomNote{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //TODO
        int[] record = new int[26];
        for (char tmp : ransomNote.toCharArray()) {
            record[tmp - 'a'] += 1;
        }
        for (char tmp : magazine.toCharArray()) {
            record[tmp - 'a'] -= 1;
        }
        for (int tmp : record) {
            if (tmp > 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

