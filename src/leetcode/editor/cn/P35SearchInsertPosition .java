/*
 * 已刷次数 : 2
 * 目前状态 : 细节仍有问题
 * */
package leetcode.editor.cn;

//Java：搜索插入位置
public class P35SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
//        if (target < nums[0]) {
//            return 0;
//        } else if (target > nums[nums.length - 1]) {
//            return nums.length;
//        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
    未熟悉细节 ： 为什么最后返回left
    这里只讨论插入的情况，找到的情况很简单，不在最后讨论范围
    明确一个概念：插入的地方的位置。如果最后找到的数大于target，那么就应该插在
    这个数的位置。反之，如果最后找的数小于target，那么就应该差在最后这个数的
    后面一个位置。
    明确第二个概念，在插入情况下，最后的下标状况一定是，right + 1 = left
    所以返回left代表涵盖了两种情况都满足
    1.在最后的nums[mid] < target情况下，left更新，left = mid + 1，
        这样就达成了，返回mid的后一个值
    2.在最后的nums[mid] > target情况下，right更新，而left仍然是mid，
        这样就达成了，返回mid。
    故完美
* */

