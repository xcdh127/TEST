package Leetcode;
/*如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
只有给定的树是单值二叉树时，才返回 true；否则返回 false。*/
public class Test19 {
    //记录二叉树的前一个节点
    TreeNode prev=null;
    //定义一个标志位，来记录当前二叉树中的节点是不是单值
    boolean flag=true;
    public boolean isUnivalTree(TreeNode root) {
        recur(root);
        return flag;
    }
    public void recur(TreeNode root){
        if (root==null){
            return ;
        }
        //左
        recur(root.left);
        //根
        //当前一个节点不为空时
        //判断当前节点是不是和当前节点的是一致，如果不一致就将返回false
        if(prev!=null){
            if(prev.val!=root.val){
                flag=false;
            }
        }
        prev=root;
        //右
        recur(root.right);
    }
}
