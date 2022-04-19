package leetcode.editor.cn;

import java.util.*;

//Java：重新安排行程
public class P332ReconstructItinerary{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
//
//        一个行程中，如果航班处理不好容易变成一个圈，成为死循环
//        有多种解法，字母序靠前排在前面，让很多同学望而退步，如何该记录映射关系呢 ？
//        使用回溯法（也可以说深搜） 的话，那么终止条件是什么呢？
//        搜索的过程中，如何遍历一个机场所对应的所有机场。
class Solution {
    Map<String, Map<String, Integer>> map = new HashMap<>();
    //因为每回都走最后一个，所以这里用Deque，效率更高,也可以直接用Linklist，deque是个接口
    LinkedList<String> results = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            if (map.containsKey(ticket.get(0))) {
                Map<String, Integer> tmp = map.get(ticket.get(0));
                tmp.put(ticket.get(1), tmp.getOrDefault(ticket.get(1), 0) + 1);
            } else {
                //这里选择TreeMap，会对key进行自然排序，升序
                Map<String, Integer> tmp = new TreeMap<>();
                tmp.put(ticket.get(1), 1);
                map.put(ticket.get(0), tmp);
            }
        }
        results.add("JFK");
        backTracing(tickets.size());
        return results;
    }

    public boolean backTracing(int rmCount) {
        if (rmCount == 0) {
            return true;
        }
        String start = results.getLast();
        if (map.containsKey(start)){
            Map<String, Integer> ends = map.get(start);
            for (Map.Entry<String, Integer> end : ends.entrySet()) {
                if (end.getValue() > 0) {
                    results.add(end.getKey());
                    end.setValue(end.getValue() - 1);
                    if (backTracing(rmCount - 1)) return true;
                    end.setValue(end.getValue() + 1);
                    results.removeLast();
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

