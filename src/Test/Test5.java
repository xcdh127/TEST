package Test;
/*给定一棵二叉树，你需要计算它的直径长度。
一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点*/
public class Test5 {
    int maxDeep=0;
    public int diameterOfBinaryTree(TreeNode root) {
        recur(root);
        return maxDeep;
    }
    public int recur(TreeNode root){
        if (root==null){
            return 0;
        }
        //左
        int left=recur(root.left);
        //右
        int right=recur(root.right);
        //根(左边树深+右边树深就是两个节点之间的距离)
        maxDeep=Math.max(maxDeep,left+right);
        return 1+Math.max(left,right);
    }
}
