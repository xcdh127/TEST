package CodeDream;

/*给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明：叶子节点是指没有子节点的节点。
示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：2
示例 2：
输入：root = [2,null,3,null,4,null,5,null,6]
输出：5
提示：
树中节点数的范围在 [0, 105] 内
-1000 <= Node.val <= 1000
*/
public class Test111 {
    public int minDepth(TreeNode root) {
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
        //如果只有左子树，返回1+left
        if (left != 0 && right == 0) {
            return 1 + left;
        }
        //如果只有右子树，返回1+right
        else if (left == 0 && right != 0) {
            return 1 + right;
        }
        //返回1+左右子树较小者
        return 1 + Math.min(left, right);
    }
}
