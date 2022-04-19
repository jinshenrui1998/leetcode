package leetcode.editor.cn;

//Java：在排序数组中查找元素的第一个和最后一个位置
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        int[] nums = {1, 2, 3};
        int target = 2;
        System.out.println(solution.searchRange());
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //plan2
    //此方法相对方法1的优化思路： 将等于和大于或者小于优化到一起
    //这里搜索出来的是一个开区间，所以在最后要进行+1，-1
    //有以下四种情况
    //1.数字在中间并且找到，这自然是没什么问题
    //2.数字不在这整个范围之内，这样左边缘或者右边缘，一定有一个是-2，就直接pass
    //3.数字在这个范围之内，但是没有。这样左边缘和右边缘会一直更新，而且会指向同一个位置
    //因为只有相等的情况不一样，而这里没有相等的情况。所以在最后处理的时候，要加上一个
    //处理后的边缘如果不相等就代表搜索成功，否则搜索失败
    //
    public int[] searchRange(int[] nums, int target) {
        int leftBorder = searchLeftBorder(nums, target);
        int rightBorder = searchRightBorder(nums, target);
        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1, -1};
        }
        //这里条件既可以写rightBorder-leftBorder>0,也可以写大于1
        //但是写  >1 比 >0, 不知道为什么可以节约0.2MB的内存
        if (rightBorder - leftBorder > 1) {
            return new int[]{leftBorder + 1, rightBorder - 1};
        }
        return new int[]{-1, -1};
    }

    public int searchLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
                leftBorder = right;
            }
        }
        return leftBorder;
    }

    public int searchRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }
//plan1 自己悟的
/*    public int[] searchRange(int[] nums, int target) {
        int leftBorder = searchLeftBorder(nums, target);
        int rightBorder = searchRightBorder(nums, target);
        if (leftBorder == -2 || rightBorder == -2){
            return new int[] {-1, -1};
        }
        else {
            return new int[] {leftBorder, rightBorder};
        }
    }

    public int searchLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBoreder = -2;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
                leftBoreder = mid;
            }
        }
        return leftBoreder;
    }

    public int searchRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target){
                rightBorder = mid;
                left = mid + 1;
            }
        }
        return rightBorder;
    }*/
}
//第二遍刷 想的代码 但是感觉都没有第一种好 plan1 自己想的
//class Solution {
//    int[] res = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
//    public int[] searchRange(int[] nums, int target) {
//        if (nums.length == 0) return new int[] {-1, -1};
//        if (nums[0] > target || nums[nums.length - 1] < target) return new int[] {-1, -1};
//        process(nums, target, 0, nums.length - 1);
//        if (res[0] == Integer.MAX_VALUE) res[0] = -1;
//        if (res[1] == Integer.MIN_VALUE) res[1] = -1;
//        return res;
//    }
//    public void process(int[] nums, int target, int left, int right) {
//        if (left > right) return;
//        int mid = left + (right - left >> 1);
//        if (nums[mid] == target) {
//            res[0] = Math.min(res[0], mid);
//            res[1] = Math.max(res[1], mid);
//            process(nums, target, left, mid - 1);
//            process(nums, target, mid + 1, right);
//        } else if (nums[mid] > target) {
//            process(nums, target, left, mid - 1);
//        } else {
//            process(nums, target, mid + 1, right);
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

