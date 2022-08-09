package CodeDream;

import java.util.ArrayList;
import java.util.List;

/*给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
示例 1：
输入：root = [1,null,2,3]
输出：[3,2,1]
示例 2：
输入：root = []
输出：[]
示例 3：
输入：root = [1]
输出：[1]
提示：
树中节点的数目在范围 [0, 100] 内
-100 <= Node.val <= 100
*/
public class Test145 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        recur(root);
        return res;
    }

    public void recur(TreeNode root) {
        if (root == null) {
            return;
        }
        //左
        recur(root.left);
        //右
        recur(root.right);
        //根
        res.add(root.val);
    }
}
