package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三数之和
public class P15ThreeSum{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    * 多指针思路
      拿这个nums数组来举例，首先将数组排序，然后有一层for循环，
      i从下标0的地方开始，同时定一个下标left 定义在i+1的位置上，
      定义下标right 在数组结尾的位置上。
      依然还是在数组中找到 abc 使得a + b +c =0，
      我们这里相当于 a = nums[i] b = nums[left] c = nums[right]。
      下来如何移动left 和right呢， 如果nums[i] + nums[left] + nums[right] > 0
      就说明此时三数之和大了，因为数组是排序后了，所以right下标就应该向左移动，
      这样才能让三数之和小一些。
      如果 nums[i] + nums[left] + nums[right] < 0
      说明此时三数之和小了，left 就向右移动，才能让三数之和大一些，
      直到left与right相遇为止。

    * 哈希法解这题不合适
      两层for循环就可以确定 a 和b 的数值了，可以使用哈希法来确定 0-(a+b)
      是否在 数组里出现过，其实这个思路是正确的，但是我们有一个非常棘手的问题，就是题目中说的不可以包含重复的三元组。
      把符合条件的三元组放进vector中，然后再去重，这样是非常费时的，
      很容易超时，也是这道题目通过率如此之低的根源所在。
      去重的过程不好处理，有很多小细节，如果在面试中很难想到位。
      时间复杂度可以做到$O(n^2)$，但还是比较费时的，因为不好做剪枝操作。
      大家可以尝试使用哈希法写一写，就知道其困难的程度了。
    */

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null && nums.length < 3) {
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //nums[left]和nums[right]大于nums[i]
            //如果nums[i]大于0，那么三数之和和不可能等于，直接break
            if (nums[i] > 0){
                return ans;
            }
            //num[i]如果等于nums[i - 1]，那么其结果是一样的，导致重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //left或right 用过一次就用不了第二次了
                    //因为i已经确定了，如果接着用一个数，那么第三个数唯一确定，则重复
                    //所以left和right都要更新
                    while (left < right && nums[left+1] == nums[left]) left++;
                    while (left < right && nums[right-1] == nums[right]) right--;
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

