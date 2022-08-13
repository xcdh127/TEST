package CodeDream;

import java.util.LinkedList;
import java.util.Queue;

/*给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
假设二叉树中至少有一个节点。
示例 1:
输入: root = [2,1,3]
输出: 1
示例 2:
输入: [1,2,3,4,null,5,6,null,null,7]
输出: 7
提示:
二叉树的节点个数的范围是 [1,104]
-231 <= Node.val <= 231 - 1 
*/
public class Test513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        //记录最后一行节点的值
        int value = root.val;
        //当队列1不空时
        while (!queue1.isEmpty()) {
            //处理当前节点
            TreeNode temp = queue1.poll();
            //当前节点不为空
            if (temp != null) {
                //当前节点的左子节点不空，入队列
                if (temp.left != null) {
                    queue2.offer(temp.left);
                }
                //当前节点的右子节点不空，入队列
                if (temp.right != null) {
                    queue2.offer(temp.right);
                }
            }
            //队列为空时
            if (queue1.isEmpty()) {
                //队列2赋值给队列1
                queue1 = queue2;
                //队列1不为空时
                if (!queue1.isEmpty()) {
                    //记录下一层的第一个节点的值
                    value = ((LinkedList<TreeNode>) queue1).getFirst().val;
                }
                //新建队列2
                queue2 = new LinkedList<>();
            }
        }
        //返回最后一层节点的值
        return value;
    }
}
