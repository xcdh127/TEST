package CodeDream;

import java.util.Stack;

/*给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1：
输入：root = [2,1,3]
输出：true
示例 2：
输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。
提示：
树中节点数目范围在[1, 104] 内
-231 <= Node.val <= 231 - 1
*/
public class Test98 {
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        //迭代中序遍历二叉搜索树，为单调递增
        Stack<TreeNode> stack = new Stack<>();
        //当前节点指向root
        TreeNode cur = root;
        //当前节点不为空，或者当前栈为空
        while (cur != null || !stack.isEmpty()) {
            //当前节点不为空时
            while (cur != null) {
                //压入栈中
                stack.push(cur);
                //指向左子节点
                cur = cur.left;
            }
            //弹出栈顶节点
            cur = stack.pop();
            //前一个节点不为空
            if (prev != null) {
                //前一个节点大于等于后一个节点，返回false
                if (prev.val >= cur.val) {
                    return false;
                }
            }
            //前一个节点指向当前节点
            prev = cur;
            //当前节点指向右子节点
            cur = cur.right;
        }
        //返回true
        return true;
    }
}
