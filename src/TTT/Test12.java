package TTT;

public class Test12 {
}
class Solution6 {
    public boolean isSymmetric(TreeNode root) {
        //如果根节点为空，直接返回true
        if(root==null){
            return true;
        }
        return recur(root.left,root.right);
    }
    public boolean recur(TreeNode left,TreeNode right){
        //当左边的节点和右边的节点同时到达叶子节点时，返回true
        if(left==null && right==null){
            return true;
        }
        //当左边的节点或者右边的节点到达叶子节点时，返回false
        if(left==null || right==null){
            return false;
        }
        //比较左子节点的值与右子节点的值，并且比比较左子树的左子节点和右子树的右子节点是否相等，
        //并且比较左子树的右子节点和右子树的左子节点是否相等
        return left.val==right.val && recur(left.left,right.right) && recur(left.right,right.left);
    }
}