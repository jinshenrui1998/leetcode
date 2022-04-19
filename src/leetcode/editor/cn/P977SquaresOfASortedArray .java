package leetcode.editor.cn;
//Java：有序数组的平方
public class P977SquaresOfASortedArray{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}

//细节 : (int)Math.pow(a, 2) 速度慢得多 比 a * a
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        //当数组只有非正数或者非负数时，直接处理
        if (nums[0] >= 0){
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }
            return nums;
        } else if (nums[nums.length - 1] <= 0) {
            int[] res = new int[nums.length];
            int i = 0;
            while (i < nums.length) {
                res[i] = nums[nums.length - 1 - i] * nums[nums.length - 1 - i];
                i++;
            }
            return res;
        }

        //找到正负分隔处
        int division = 0;
        while (division < nums.length) {
            if (nums[division] >= 0) {
                break;
            }
            division++;
        }

        //开始merge
        int left = division - 1;
        int right = division;
        int i = 0;
        int[] res = new int[nums.length];
        while (left >= 0 && right < nums.length) {
            res[i++] = nums[left] * nums[left] < nums[right] * nums[right]
                    ? nums[left] * nums[left--] : nums[right] * nums[right++];
        }
        while (left >= 0) {
            res[i++] = nums[left] * nums[left--];
        }
        while (right < nums.length) {
            res[i++] = nums[right] * nums[right++];
        }
        return res;
        //代码随想录答案 比我的答案消耗内存更多 耶
//        int l = 0;
//        int r = nums.length - 1;
//        int[] res = new int[nums.length];
//        int j = nums.length - 1;
//        while(l <= r){
//            if(nums[l] * nums[l] > nums[r] * nums[r]){
//                res[j--] = nums[l] * nums[l++];
//            }else{
//                res[j--] = nums[r] * nums[r--];
//            }
//        }
//        return res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

