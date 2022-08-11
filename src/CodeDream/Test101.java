package CodeDream;

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
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);

    }

    public boolean recur(TreeNode left, TreeNode right) {
        //左右子树都到达叶子节点后，返回true
        if (left == null && right == null) {
            return true;
        }
        //某一个树遍历结束，返回false
        if (left == null || right == null) {
            return false;
        }
        //返回左右子节点的值是否相等，并且继续比较左子树的左子节点与右子树的右子节点
        //继续比较左子树的右子节点与右子树的左子节点
        return left.val == right.val && recur(left.left, right.right) && recur(left.right, right.left);
    }
}
