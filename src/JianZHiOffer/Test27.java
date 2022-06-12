package JianZHiOffer;
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
public class Test27 {
    public TreeNode mirrorTree(TreeNode root) {
        return recur(root);

    }

    public TreeNode recur(TreeNode root){
        if (root==null){
            return null;
        }
        //根
        TreeNode right=root.right;
        root.right=root.left;
        root.left=right;
        //左
        recur(root.left);
        //右
        recur(root.right);
        return root;
    }
}
