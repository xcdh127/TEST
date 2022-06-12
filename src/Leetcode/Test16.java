package Leetcode;
/*给你一个二叉搜索树的根节点 root ，
返回 树中任意两不同节点值之间的最小差值 。
差值是一个正数，其数值等于两值之差的绝对值。*/
public class Test16 {
    //记录前一个节点
    TreeNode prev=null;
    //记录二叉搜索树中的所有的节点之差的最小值
    int minDiff=Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        recur(root);
        //返回最先小差值
        return minDiff;
    }
    public void recur(TreeNode root){
        //当根节点为空时，直接返回空
        if (root==null){
            return;
        }
        //左
        recur(root.left);
        //根
        //当前两个相邻的节点之间的差值小于当前树中两个节点之差的最小值时
        //就将更新最小值
        if (prev!=null){
          if (Math.abs(prev.val-root.val)<minDiff){
              minDiff=Math.abs(prev.val-root.val);
          }
        }
        //指向前一个节点的指针指向当前节点
        prev=root;
        //右
        recur(root.right);
    }
}
