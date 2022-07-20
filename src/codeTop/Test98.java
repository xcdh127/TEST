package codeTop;

import java.util.Stack;

/*给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1：
输入：root = [2,1,3]
输出：true
示例 2：
输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。
提示：
树中节点数目范围在[1, 104] 内
-231 <= Node.val <= 231 - 1
*/
public class Test98 {
    public boolean isValidBST(TreeNode root) {
        //prev为null
        TreeNode prev=null;
        //cur指向根节点
        TreeNode cur=root;
        //栈
        Stack<TreeNode> stack=new Stack<>();
        //当栈不为空，或者当前节点不为空时
        while (!stack.isEmpty() || cur!=null){
            //当cur不为空时
            while (cur!=null){
                //将当前节点放进stack中
                stack.push(cur);
                //当前节点指向当前节点的左子节点
                cur=cur.left;
            }
            //弹出栈顶元素，处理当前元素
            cur=stack.pop();
            //当prev为空时
            if (prev!=null){
                //prev的值大于等于cur的值，不符合二插搜索树的概念，返回false
                if (prev.val>=cur.val){
                    return false;
                }
            }
            //前一个节点指向后一个节点
            prev=cur;
            //当前节点指向当前节点的右子节点
            cur=cur.right;
        }
        return true;
    }
}
