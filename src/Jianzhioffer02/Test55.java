package Jianzhioffer02;

/*输入一棵二叉树的根节点，求该树的深度。
从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
例如：
给定二叉树 [3,9,20,null,null,15,7]，
    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
提示：
节点总数 <= 10000
*/
public class Test55 {
    public int maxDepth(TreeNode root) {
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
        //左右子树最大深度+1
        return 1 + Math.max(left, right);
    }
}
