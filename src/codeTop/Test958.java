package codeTop;

import java.util.LinkedList;
import java.util.Queue;

/*给定一个二叉树的 root ，确定它是否是一个 完全二叉树 。
在一个 完全二叉树 中，除了最后一个关卡外，
所有关卡都是完全被填满的，并且最后一个关卡中的所有节点都是尽可能靠左的。
它可以包含 1 到 2h 节点之间的最后一级 h 。
示例 1：
输入：root = [1,2,3,4,5,6]
输出：true
解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
示例 2：
输入：root = [1,2,3,4,5,null,7]
输出：false
解释：值为 7 的结点没有尽可能靠向左侧。
提示：
树的结点数在范围  [1, 100] 内。
1 <= Node.val <= 1000
*/
public class Test958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root==null){
            return true;
        }
        //行序遍历二叉树，使用队列存放
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        queue1.offer(root);
        //当前节点
        TreeNode cur=null;
        //当出现有左无右或者无左无右的情况时，就是true，此时遍历到了树的最后一个节点
        boolean occur=false;
        //当队列1为空时
        while (!queue1.isEmpty()){
            //记录要遍历的节点
            cur=queue1.poll();
            //occur为true时，说明已经遍历到最后一个节点，如果最后一个节点后面还有节点，就返回false
            if (occur && (cur.left!=null || cur.right!=null)){
                return false;
            }
            //当前节点有左无右
            else if (cur.left != null && cur.right == null) {
                //记录遍历到树的最后一个节点
                occur=true;
                //将当前节点的左子节点放进队列2中
                queue2.offer(cur.left);
            }
            //当前节点有右无左时，直接返回false
            else if (cur.left == null && cur.right != null) {
                return false;
            }
            //当前节点无左无右，此时到了树的末尾
            else if (cur.left == null && cur.right == null) {
                occur=true;
            }
            //当前节点的左子节点不为空，并且当前节点的右子节点不为空时
            else if (cur.left != null && cur.right != null) {
                //将当前节点的左子节点放进队列2中
                queue2.offer(cur.left);
                //将当前节点的右子节点放进队列2中
                queue2.offer(cur.right);
            }
            //当队列1为空时，将对列2赋值给队列1
            if (queue1.isEmpty()){
                queue1=queue2;
                //新建对列2
                queue2=new LinkedList<>();
            }
        }
        //返回完整二叉树
        return true;
    }
}
class Solution6 {
    public boolean isCompleteTree(TreeNode root) {
        if(root==null){
            return true;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode cur=null;
//当出现有左无右或者无左无右的情况时，就是true
        boolean occur=false;
        while(!queue.isEmpty()){
//记录要遍历的节点
            cur=queue.poll();
//occur为true时，说明已经遍历到最后一个节点，如果最后一个节点后面还有节点就返回false
            if(occur && (cur.left!=null || cur.right!=null )){
                return false;
            }
//当前节点有左无右
            else if(cur.left!=null && cur.right==null){
                occur=true;
                queue.offer(cur.left);
            }
//当前节点有右无左
            else if(cur.left==null && cur.right!=null){
                return false;
            }
//当前节点无左无右
            else if(cur.left==null && cur.right==null){
                occur=true;
            }
//左右都有
            else if(cur.left!=null && cur.right!=null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return true;
    }
}
