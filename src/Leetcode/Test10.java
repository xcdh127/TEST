package Leetcode;

/*给你两棵二叉树： root1 和 root2 。
想象一下，当你将其中一棵覆盖到另一棵之上时，
两棵树上的一些节点将会重叠（而另一些不会）。
你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，
那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
返回合并后的二叉树。
注意: 合并过程必须从两个树的根节点开始。
*/
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class Test10 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return recur(root1,root2);
    }
    public TreeNode recur(TreeNode root1,TreeNode root2){
        //当两个节点root1和roo2都为空时将返回空值
        if (root1==null && root2==null){
            return null;
        }
        //当root1不为空,并且当root2为空时，将返回root1节点
        else if(root1!=null && root2==null){
            return root1;
        }
        //当root2节点不为空，并且当root1为空时，将返回root2节点
        else if (root2!=null && root1==null){
            return root2;
        }
        //此时时是连个节点都为空时将返回两个之和形成的新节点
        TreeNode node=new TreeNode(root1.val+root2.val);
        //左(处理两个节点的左子节点的值)
        node.left=recur(root1.left,root2.left);
        //右(处理两个节点的右子节点的值)
        node.right=recur(root1.right,root2.right);
        //将node节点返回
        return node;
    }
}


/*
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

 return recur(root1,root2);
    }

 public TreeNode recur(TreeNode root1,TreeNode root2){

 if(root1==null && root2==null){
 return null;
 }
 else if(root1!=null && root2==null){
 return root1;
 }
  else if(root1==null && root2!=null){
 return root2;
 }
 TreeNode node=new TreeNode(root1.val+root2.val);
 node.left=recur(root1.left,root2.left);
 node.right=recur(root1.right,root2.right);
 return node;
 }

}*/
