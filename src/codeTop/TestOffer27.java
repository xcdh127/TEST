package codeTop;

/*请完成一个函数，输入一个二叉树，该函数输出它的镜像。
例如输入：
     4
   /   \
  2     7
 / \   / \
1   3 6   9
镜像输出：
     4
   /   \
  7     2
 / \   / \
9   6 3   1
示例 1：
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
限制：
0 <= 节点个数 <= 1000
*/
public class TestOffer27 {
    public TreeNode mirrorTree(TreeNode root) {
        return recur(root);
    }

    public TreeNode recur(TreeNode root) {
        if (root == null) {
            return null;
        }
        //根
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        //左
        recur(root.left);
        //右
        recur(root.right);
        //返回根节点
        return root;
    }
}
