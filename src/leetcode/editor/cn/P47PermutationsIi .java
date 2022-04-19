package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：全排列 II
public class P47PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    //排列
//    //叶子结点
//    //集合中有重复，结果中不重复 = 树层去重
//    //排列 = 树枝去重
//    (直觉)
//    //故 : 树枝去重 + 树层去重
//
//    //Tips : boolean的默认值为false
//    //故赋值策略为 用过就设为true
//
//    //但是树枝去重和树层区中直接会有重复去重，可以通过一种去重方式直接实现效果

//    //参考卡尔哥的47题图，往往树层去重更直接，更彻底，效率更高。
//    //因为树枝去重走到死路头才会返回，那么前面一部分死路就白走了
//    List<List<Integer>> result = new ArrayList<>();
//    LinkedList<Integer> path = new LinkedList<>();
//    boolean[] branchUsed;
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        branchUsed = new boolean[nums.length];
//        Arrays.sort(nums);
//        backTracing(nums);
//        return result;
//    }
//    public void backTracing(int[] nums) {
//        if (path.size() == nums.length) {
//            result.add(new ArrayList<Integer>(path));
//            return;
//        }
//        boolean[] levelUsed = new boolean[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            if (branchUsed[i]) continue;
//            if (i != 0 && nums[i] == nums[i - 1] && levelUsed[i - 1]) {
//                //如果直接continue，那么在连续三个数相同的情况下会报错
//                //因为第一个设为true，第二个被continue了，所以第二个不会为true，所以第三个不continue，所以就重复了
//                levelUsed[i] = true;
//                continue;
//            }
//            branchUsed[i] = true;
//            levelUsed[i] = true;
//            path.add(nums[i]);
//            backTracing(nums);
//            path.removeLast();
//            branchUsed[i] = false;
//        }
//    }
    //卡尔哥方法
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    //此时的used已经不再是单单是树枝或者树层去重
    //而是通过不同的使用used方式 实现树枝或者树层去重
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracing(nums);
        return result;
    }
    public void backTracing(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //树层去重思路 同样的数字在一个树层上选中一次不被选第二次

            //当 当前数字和前一个数字相等的时候，有两种情况 例如[1, 1, 2]
            // 1. 在深度上，取了第一个1，是可以取第二个1的
            // 2. 在宽度上，第一个1用完了，这时path为空，这里是不能取第二个1的，因为和第一个1相等
            // 这两种情况在used里分别对应的就是
            // 1.used[i - 1] == true 前一个节点在深度上被用过，代表这个节点还是可以用
            // 2.used[i - 1] == false 前一个节点在深度上没有被用过，在宽度上由于前一个结点在当前节点前面
            //   所以在宽度上一定被用过，所以就不能用
            //这种方式最终实现的效果就是，第一个1被取，再取第二个，再取第三个，这样保持重复数字的相对次序不变
            //从而实现去重


            //树枝去重思路 同样的数字在树枝上选中一次不选第二次
            // used数组的含义与上面一样，但是下面判断条件改成used[i - 1] == true
            // 实现的效果 对于 [1, 1, 2]来说
            //取第一个1 [1] 的时候不能取第二个1 无论是[1, 1, 2] 还是 [1, 2, 1]都不能取
            //取第二个1 [1] 的时候可以取第一个1，因为第一个1是和他前一个数字判断相同(假如有的话)

            //关于连续重复数字的问题，由于这是一个排列问题（包括组合问题）他是取叶子结点，即集合中所有元素都要取到
            //所以尽管在例如[1,1,1]中，取了第一个1之后不能取第二个1，取了第一个之后可以取第三个1，但是终归
            //是还要取第二个1，在取第二个1的时候还是不能取，这种方式还是要被continue

            //所以最终实现的效果就是，当有重复数字连续的时候，（在深度上）只能先取最后一个数字，再取倒数第二个数字,
            //再取倒数第三个数字，再取倒数第四个数字，这样取下去，才能通过，故重复数字只能保持相对次序不变被取，从而
            //保证去重
            if (i != 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            // 这里used[i]为false，代表深度上，这个节点没有被用过
            // 实现的是同一个节点不会被重复选取
            if (used[i] == false) {
                used[i] = true;
                path.add(nums[i]);
                backTracing(nums);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

