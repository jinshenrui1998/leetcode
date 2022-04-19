package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

//Java：根据身高重建队列
public class P406QueueReconstructionByHeight{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    渔（套路）：一般这种数对，还涉及排序的，根据第一个元素正向排序，根据第二个元素反向排序，
//    或者根据第一个元素反向排序，根据第二个元素正向排序，往往能够简化解题过程。
//    在本题目中，我首先对数对进行排序，按照数对的元素 1 降序排序，按照数对的元素 2 升序排序。
//    原因是，按照元素 1 进行降序排序，对于每个元素，在其之前的元素的个数，
//    就是大于等于他的元素的数量，而按照第二个元素正向排序，我们希望 k 大的尽量在后面，减少插入操作的次数。
//    不止是为了减少插入次数，也是为了保证正确性。
//    举个例子，在身高一样，k不一样的时候，譬如[5,2]和[5,3],
//    对于最后排完的数组，[5,2]必然在[5,3]的前面。所以如果遍历的时候[5,3]在前面，
//    等它先插入完，这个时候它前面会有3个大于等于它的数组对，遍历到[5,2]的时候，
//    它必然又会插入[5,3]前面（因为它会插入链表索引为2的地方），
//    这个时候[5,3]前面就会有4个大于等于它的数组对了，这样就会出错。



    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        //后面根据前方人数插入，多次改变前面的顺序，数组不方便，故采用链表

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] tmp : people) {
            list.add(tmp[1], tmp);
        }

        return list.toArray(new int[people.length][]);
    }


    //题目的意思就是，现在有每个人的身高和，前面比该人高的人数，两个变量
    //根据这两个变量，还原队列顺序
    //遇到两个维度权衡的时候，一定要先确定一个维度，再确定另一个维度。
    //如果两个维度一起考虑一定会顾此失彼。
    //那么这一题的两个维度怎么考虑合适
    //考虑两个维度的标准就是，考虑第二个维度的时候，不能打破第一个维度的规则

    //这里有一个维度很特殊，就是高度，高度高的一定要比高度低的先入队
    //因为如果高度低的先入队，后插入高度高的，那么在高度高的入队的时候，
    //即可以插在高度低的前面，也可以后面，出现多种结果，这样就更不好考虑

    //所以当考虑多个维度的时候有个原则就是，如果后考虑某个维度，会丧失唯一性，那么就要优先考虑
}
//leetcode submit region end(Prohibit modification and deletion)

