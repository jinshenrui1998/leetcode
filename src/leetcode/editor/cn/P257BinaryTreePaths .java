package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

//Java：二叉树的所有路径
public class P257BinaryTreePaths{
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
    *  自己想的方法 效果并不好
     * 经验教训：在递归中，如果是得到多个结果，放在数据结构中
     * 还是可以把整个记录结果的容器作为参数传下去，这样虽然多一个参数，但是操作起来更简单
     * 使用回溯可以重复使用一个结构多次
    * */
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> resList = new ArrayList<>();
//        if (root == null) return resList;
//        String curString = root.val + "";
//        if (root.left == null && root.right == null) {
//            resList.add(curString);
//            return resList;
//        }
//        if (root.left != null)
//            resList.addAll(process(root.left, curString));
//        if (root.right != null)
//            resList.addAll(process(root.right, curString));
//        return resList;
//    }
//    public List<String> process(TreeNode curNode, String curString) {
//        List<String> curList = new ArrayList<>();
//        curString += "->" + curNode.val;
//        if (curNode.left == null && curNode.right == null) {
//            curList.add(curString);
//            return curList;
//        }
//        if (curNode.left != null)
//            curList.addAll(process(curNode.left, curString));
//        if (curNode.right != null)
//            curList.addAll(process(curNode.right, curString));
//        return curList;
//    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resList = new ArrayList<>();
        if (root == null) return resList;

        List<Integer> curPath = new ArrayList<>();
        process(root, curPath, resList);

        return resList;
    }
    //对于递归函数返回值的思考，有两种方案
    //1.把结果string作为返回值，但是这样的话，在根节点要一次添加全部string，难以实现
    //2.把结果作为参数传下去，这样正好符合每个叶子节点一个路径，每个叶子结点添加一次

    //由于回溯，要对字符串加加减减，所以这里List与StringBuilder记录结果
    public void process(TreeNode curNode, List<Integer> curPath, List<String> resList) {
        //1.确定递归基 递归应该为叶子结点 就返回路径
        //应该自然想到使用 不遍历空值的模式
        //仔细思考能想到，如果使用空值，那么在每个叶子结点下有左右两个，一条路径就要添加两次
        curPath.add(curNode.val);
        if(curNode.left == null && curNode.right == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(curPath.get(0));
            for (int i = 1; i < curPath.size(); i++) {
                sb.append("->" + curPath.get(i));
            }
            resList.add(sb.toString());
            return;
        }
        if(curNode.left != null) {
            process(curNode.left, curPath, resList);
            curPath.remove(curPath.size() - 1);
        }
        if(curNode.right != null) {
            process(curNode.right, curPath, resList);
            curPath.remove(curPath.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

