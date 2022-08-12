package CodeDream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
叶子节点 是指没有子节点的节点。
示例 1：
输入：root = [1,2,3,null,5]
输出：["1->2->5","1->3"]
示例 2：
输入：root = [1]
输出：["1"]
提示：
树中节点的数目在范围 [1, 100] 内
-100 <= Node.val <= 100
*/
public class Test257 {
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> subset = new LinkedList<>();
        recur(root, subset);
        return res;
    }

    public void recur(TreeNode root, LinkedList<String> path) {
        if (root == null) {
            return;
        }
        //根
        //根节点 左子节点为空并且右子节点为空
        if (root.left == null && root.right == null) {
            //将数字添加到路径中
            path.addLast(String.valueOf(root.val));
            //拼接路径字符串
            StringBuilder sb = new StringBuilder();
            for (String s : path) {
                sb.append(s);
            }
            //向结果集中添加字符串
            res.add(sb.toString());
        }
        //向路径中添加最后一个节点的值->
        else {
            path.addLast(root.val + "->");
        }
        //左
        recur(root.left, path);
        //右
        recur(root.right, path);
        //删除最后放进路径的内容
        path.removeLast();
    }
}
