package codeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
示例 1:
输入: [1,2,3,null,5,null,4]
输出: [1,3,4]
示例 2:
输入: [1,null,3]
输出: [1,3]
示例 3:
输入: []
输出: []
提示:
二叉树的节点个数的范围是 [0,100]
-100 <= Node.val <= 100 
*/
public class Test199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //当根节点为空时，直接返回空数组
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        //将根节点放进队列1中
        queue1.offer(root);
        //当队列1不为空时
        while (!queue1.isEmpty()) {
            //处理当前节点
            TreeNode temp = queue1.poll();
            //当前节点不为空时
            if (temp != null) {
                //当前节点的左子节点不为空时，左子节点入队
                if (temp.left != null) {
                    queue2.offer(temp.left);
                }
                //当前节点的右子节点不为空时，右子节点入队
                if (temp.right != null) {
                    queue2.offer(temp.right);
                }
            }
            //当队列1为空时
            if (queue1.isEmpty()) {
                //说明此时这一层的数字已经遍历完毕，当前节点就是这一层最后一个节点
                res.add(temp.val);
                //更新队列1
                queue1 = queue2;
                //新建队列2
                queue2 = new LinkedList<>();
            }
        }
        //返回结果
        return res;
    }
}
