package HOT100;
/*给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
示例 :
给定二叉树
          1
         / \
        2   3
       / \
      4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
注意：两结点之间的路径长度是以它们之间边的数目表示。
*/
public class Test543 {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        recur(root);
        return max;
    }
    public int recur(TreeNode root){
        if (root==null){
            return 0;
        }
        //左
        int left=recur(root.left);
        //右
        int right=recur(root.right);
        //左+右不经过根节点
        max=Math.max(max,left+right);
        //根节点+左和右中的较大值
        return 1+Math.max(left,right);
    }
}
