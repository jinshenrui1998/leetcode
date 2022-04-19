package leetcode.editor.cn;

import java.util.Arrays;

//Java：反转字符串 II
public class P541ReverseStringIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        int left = 0;
        char[] arr = s.toCharArray();
        int length = arr.length;

        //注意下标运算就行：下标left到right之间有 right-left+1个数
        while (length - 1 >= left + 2 * k - 1) {
            reverse(arr, left, left + k - 1);
            left += 2 * k;
        }
        if (length - 1 - left <= k - 1) {
            reverse(arr, left, length - 1);
        } else {
            reverse(arr, left, left + k - 1);
        }
        return new String(arr);
    }
    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char c = arr[left];
            arr[left] = arr[right];
            arr[right] = c;
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

