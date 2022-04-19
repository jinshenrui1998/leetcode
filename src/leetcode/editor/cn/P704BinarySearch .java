/*
* 已刷次数 : 2
* 目前状态 : 细节仍有问题
* */

package leetcode.editor.cn;

//Java：二分查找
public class P704BinarySearch {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 5;
        int result = solution.search(nums, target);
        System.out.println("result = " + result);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1])
            return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target){
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

//自己想的第一种方法，递归
/*class Solution {
    public int search(int[] nums, int target) {
        return process(nums, target, 0, nums.length - 1);
    }
    public int process(int[] nums, int target, int left, int right){
        if (left > right){
            return -1;
        }
        int mid = left + (right - left >> 1);
        if (nums[mid] > target){
            right = mid - 1;
        } else if (nums[mid] < target){
            left = mid + 1;
        } else {
            return mid;
        }
        return process(nums, target, left, right);
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
/*
* 第二次刷细节问题如下 :
* 1. 在闭区间搜索，这里要用小于等于号，否则只有区间只有一个数的情况搜不到
* 2. 更新left和right指针要用 mid-1， mid+1. 第一减小计算量，第二避免死循环
*    在left = right = mid 时仍未找到，会出现死循环*/
