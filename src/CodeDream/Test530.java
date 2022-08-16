package CodeDream;

import java.util.Stack;

/*给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
差值是一个正数，其数值等于两值之差的绝对值。
示例 1：
输入：root = [4,2,6,1,3]
输出：1
示例 2：
输入：root = [1,0,48,null,null,12,49]
输出：1
提示：
树中节点的数目范围是 [2, 104]
0 <= Node.val <= 105
*/
public class Test530 {
    TreeNode prev = null;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
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
                min = Math.min(cur.val - prev.val, min);
            }
            //前一个节点指向当前节点
            prev = cur;
            //当前节点指向右子节点
            cur = cur.right;
        }
        return min;
    }
}
