package JianZHiOffer;

import java.util.Stack;

/*给你二叉树的根结点 root ，请你将它展开为一个单链表：
展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，
而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。
示例 1：
输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]
示例 2：
输入：root = []
输出：[]
示例 3：
输入：root = [0]
输出：[0]
提示：
树中结点数在范围 [0, 2000] 内
-100 <= Node.val <= 100
进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
*/
public class Test57 {
    public void flatten(TreeNode root) {
        if (root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        //记录前一个节点
        TreeNode prev=null;
        //将当前节点放入栈中
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur=stack.pop();
            //前一个节点不为空时
            if (prev!=null){
                //前一个节点的左子节点置为空
                prev.left=null;
                //前一个节点的右子节点置为当前节点
                prev.right=cur;
            }
            //右
            if (cur.right!=null){
                stack.push(cur.right);
            }
            //左
            if (cur.left!=null){
                stack.push(cur.left);
            }
            //前一个节点指向当前节点
            prev=cur;
        }
    }
}
