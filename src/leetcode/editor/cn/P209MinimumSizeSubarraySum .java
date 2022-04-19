package leetcode.editor.cn;
//Java：长度最小的子数组
public class P209MinimumSizeSubarraySum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//双循环暴力解法在遍历的过程中会丢失信息，比如连续两个值a，b小于target，而
//加上第三个值c大于等于target时，以a为首的可能性就遍历完了，之后开始以b为首。

//这里就丢失了b < target的信息（由a+b小于target得来）
//所以可以采取的做法是跳过b对比，直接用b+c对比，这样就有效的利用了这个信息。

//新理解：关于判定是否出循环的变量（如i,j,left,right)如何设置
//结论：一定要在最后（该循环中最后一次使用该变量）再对这些变量进行加减。
//好处：循环中的标识变量（上文提到的这些）保持一致，并且在循环开头就判定为
//在该循环中的合法值，不会造成数组越界。
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

