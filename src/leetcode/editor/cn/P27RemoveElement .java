package leetcode.editor.cn;

//Java：移除元素
public class P27RemoveElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //细节：只用快指针对慢指针赋值，忽略慢指针的值。不用交换
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left++] = nums[right];
            }
        }
        return left;
    }
/*    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;
        while (right <= nums.length - 1) {
            if (nums[right] != val) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
        return left;
    }
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

