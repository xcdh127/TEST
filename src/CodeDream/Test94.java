package CodeDream;

import java.util.ArrayList;
import java.util.List;

/*给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
示例 1：
输入：root = [1,null,2,3]
输出：[1,3,2]
示例 2：
输入：root = []
输出：[]
示例 3：
输入：root = [1]
输出：[1]
提示：
树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100
*/
public class Test94 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        recur(root);
        return res;
    }

    public void recur(TreeNode root) {
        if (root == null) {
            return;
        }
        //左
        recur(root.left);
        //根
        res.add(root.val);
        //右
        recur(root.right);
    }
}
