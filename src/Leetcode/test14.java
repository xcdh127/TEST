package Leetcode;
/*给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
注意：
给定的目标值 target 是一个浮点数
题目保证在该二叉搜索树中只会存在一个最接近目标值的数
*/
public class test14 {
    //记录最小值
    double minValue=Double.MAX_VALUE;
    //记录与目标值之差最接近的节点的值
    int nodeValue=-1;
    public int closestValue(TreeNode root, double target) {
        recur(root,target);
        //返回与目标节点最接近的节点的值
        return nodeValue;
    }

    public void recur(TreeNode root,double target){
        if (root==null){
            return;
        }
        //左
        recur(root.left,target);
        //右
        recur(root.right,target);
        //根
        //当前的节点与目标节点之差小于当前的最小差时
        //就更新当前最小值
        //并且记录下当前最小值对应的节点的值
        if(minValue>Math.abs(root.val-target)){
            minValue=Math.abs(root.val-target);
            nodeValue=root.val;
        }
    }
}
