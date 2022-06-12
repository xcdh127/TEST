package Leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/*如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。

只有给定的树是单值二叉树时，才返回 true；否则返回 false。*/
public class Test258 {

    public boolean isUnivalTree(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode prev=null;
        TreeNode cur=root;
        while (!stack.isEmpty() || cur!=null){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            if (prev!=null){
                if (prev.val!=cur.val){
                    return false;
                }
            }
            prev=cur;
            cur=cur.right;
        }
        return true;
    }

}
