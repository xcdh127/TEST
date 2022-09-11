package CodeTop02;

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
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        if (root == null) {
            return res;
        }
        while (!queue1.isEmpty()) {
            TreeNode temp = queue1.poll();
            if (temp != null) {
                if (temp.left != null) {
                    queue2.offer(temp.left);
                }
                if (temp.right != null) {
                    queue2.offer(temp.right);
                }
            }
            //当队列1为空时，此时temp就指向当前层的最后一个元素
            if (queue1.isEmpty()) {
                res.add(temp.val);
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return res;
    }
}
