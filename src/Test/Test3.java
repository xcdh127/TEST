package Test;


import java.util.Stack;

/*给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树
（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
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
 //二叉搜索树的中序遍历是从小遍历整颗二叉树，二叉树的逆中序遍历就是右->根->左
public class Test3 {
//    public TreeNode convertBST(TreeNode root) {
//        //迭代遍历二叉树，使用一个栈来存放沿途经过的节点
//        Stack<TreeNode> stack=new Stack<>();
//        //指向根节点
//        TreeNode cur=root;
//        //求节点总和
//        int sum=0;
//        while(!stack.isEmpty() || cur!=null){
//            //右
//            while(cur!=null){
//                stack.push(cur);
//                cur=cur.right;
//            }
//            //根
//            cur=stack.pop();
//            //累积当前节点的值
//            sum+=cur.val;
//            //更新当前节点的值
//            cur.val=sum;
//            //左
//            cur=cur.left;
//
//        }
//        return root;
//    }
     int sum=0;
     public TreeNode convertBST(TreeNode root) {
         recur(root);
         return root;
     }
     public void recur(TreeNode root){
         if (root==null){
             return;
         }
         //右
         recur(root.right);
         //根
         sum+=root.val;
         root.val=sum;
         //左
         recur(root.left);
     }

}
