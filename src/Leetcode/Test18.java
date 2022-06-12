package Leetcode;
/*给定二叉搜索树的根结点 root，
返回值位于范围 [low, high] 之间的所有结点的值的和。*/
public class Test18 {
    //记录值位于low,high之间的所有节点值的和
    int sum=0;
    //节点最小值
    int low;
    //节点最大值
    int high;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low=low;
        this.high=high;
        recur(root);
        //将总和返回
        return sum;
    }
    public void recur(TreeNode root){
        //当根节点为空时，直接返回空
        if(root==null){
            return;
        }
        //左
        recur(root.left);
        //根
        //当根节点的值大于等于low并且小于等于high时，累加到和sum中
        if (root.val>=low && root.val<=high){
            sum+=root.val;
        }
        //右
        recur(root.right);
    }
}
