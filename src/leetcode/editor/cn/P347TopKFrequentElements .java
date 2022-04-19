package leetcode.editor.cn;

import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

//Java：前 K 个高频元素
public class P347TopKFrequentElements{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //思路：记录频率--->hashmap
    //      对频率排序--->排序算法
    //     这里的排序与正常排序的区别，只取前面k个
    //     所以这里采用堆排序，一次加一个。到一定个数之后就开始每次加一个，减一个
    //     保持个数始终在k个，这样可以降低排序消耗时间。
    //     在所有O（logn）的排序中，只有堆排序可以满足这个需求，即
    //     即 在原先有序的基础上，插入一个新数，令其有序，所需复杂度最低
    //     不需要全部重排
    //     而堆排序即优先队列
    public int[] topKFrequent(int[] nums, int k) {
        //lamda表达式 用于简化这种一行的重写和对象声明
        //这里队列中是Map.Entry,所以o1，o2不用指定直接就读出来是Map.Entry
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        Hashtable<Integer, Integer> map = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //这里为什么使用堆排序(优先队列)不用快排，因为这里只用取前k大的数
        //堆排序可以把小的数舍去，在排序的后半部分，永远只排k+1个数，并舍去最后一个
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll().getKey();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

