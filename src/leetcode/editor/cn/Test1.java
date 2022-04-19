package leetcode.editor.cn;

import org.junit.jupiter.api.Test;

/**
 * Created on 2022/1/15 -- 9:41.
 *
 * @author 金伸睿
 * @version 1.0
 */

public class Test1 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3,3,5,5,5};
        int target = 2;
        System.out.println(Solution1.searchRange(nums, target));
    }
}

class Solution1 {
    public static int[] searchRange(int[] nums, int target) {
        int[] arr = new int[10];
        arr[1] = searchLeftBorder(nums, target);
        return arr;

    }

    public static int searchLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBoreder = -2;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid - 1;
            } else if (nums[mid] == target) {
                leftBoreder = mid;
                left = mid - 1;
            }
        }
        return leftBoreder;
    }
}
