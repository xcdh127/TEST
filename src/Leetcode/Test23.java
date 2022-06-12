package Leetcode;

/*给你一个 二叉树 的根结点 root，
该二叉树由恰好 3 个结点组成：根结点、左子结点和右子结点。
如果根结点值等于两个子结点值之和，返回 true ，否则返回 false 。
*/
public class Test23 {
    public boolean checkTree(TreeNode root) {
        //不用多说了吧，这很清晰了
        return root.left.val+root.right.val==root.val;
    }

    /*public void recur(TreeNode root){
        if (root==null){
            return;
        }
        //左
        recur(root.left);
        //右
        recur(root.right);
        //根

    }*/
}
