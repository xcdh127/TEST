package codeTop;

/*给你一个二叉树的根节点 root ， 检查它是否轴对称。
示例 1：
输入：root = [1,2,2,3,4,4,3]
输出：true
示例 2：
输入：root = [1,2,2,null,3,null,3]
输出：false
提示：
树中节点数目在范围 [1, 1000] 内
-100 <= Node.val <= 100
进阶：你可以运用递归和迭代两种方法解决这个问题吗？
*/
public class Test101 {
    public boolean isSymmetric(TreeNode root) {
        return recur(root.left,root.right);
    }

    public boolean recur(TreeNode left, TreeNode right) {
        //当左节点为空或者右节点为空时，同时遍历完左右子树，返回true
        if (left == null && right == null) {
            return true;
        }
        //当左子树为空，或者右子树为空时，返回false
        if (left == null || right == null) {
            return false;
        }
        //返回左子节点值等于右子节点值，并且左子节点的左子节点的值等于右子节点的右子节点值 并且左子节点的右子节点值等于右子节点的左子节点值
        return left.val==right.val && recur(left.left,right.right) && recur(left.right,right.left);
    }
}
