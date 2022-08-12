package CodeDream;

/*给定二叉树的根节点 root ，返回所有左叶子之和。
示例 1：
输入: root = [3,9,20,null,null,15,7]
输出: 24
解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
示例 2:
输入: root = [1]
输出: 0
提示:
节点数在 [1, 1000] 范围内
-1000 <= Node.val <= 1000
*/
public class Test404 {

    public int sumOfLeftLeaves(TreeNode root) {
        return recur(root);
    }

    public int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //左
        int left = recur(root.left);
        //右
        int right = recur(root.right);
        //根
        int sum = 0;
        //当前节点的左子树不为空，并且节点左子树的左子节点为空，并且左子树的右子节点为空
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        //返回所有左子节点的和
        return sum + left + right;
    }
}

class Solution5 {
    public int sumOfLeftLeaves(TreeNode root) {

        return recur(root);
    }

    public int recur(TreeNode root) {

        if (root == null) {
            return 0;
        }
        //左
        int left = recur(root.left);
        //右
        int right = recur(root.right);
        //根
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        return sum + left + right;
    }
}