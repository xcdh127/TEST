package CodeDream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
示例1：
输入: root = [1,3,2,5,3,null,9]
输出: [1,3,9]
示例2：
输入: root = [1,2,3]
输出: [1,3]
提示：
二叉树的节点个数的范围是 [0,104]
-231 <= Node.val <= 231 - 1
*/
public class Test515 {
    public List<Integer> largestValues(TreeNode root) {
        //存放结果的数组
        List<Integer> res = new ArrayList<>();
        //root==null直接返回res
        if (root == null) {
            return res;
        }
        //定义每一层的最大值
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        //当队列1不为空时
        while (!queue1.isEmpty()) {
            //处理当前节点
            TreeNode temp = queue1.poll();
            //当前节点不为空时
            if (temp != null) {
                //记录这一层的最大值
                max = Math.max(max, temp.val);
                //当前节点的左子节点不为空时，放进队列2
                if (temp.left != null) {
                    queue2.offer(temp.left);
                }
                //当前节点的右子节点不为空时，放进对列2
                if (temp.right != null) {
                    queue2.offer(temp.right);
                }
            }
            //队列1为空时
            if (queue1.isEmpty()) {
                //数组放进最大值
                res.add(max);
                //最大值恢复为最小整数
                max = Integer.MIN_VALUE;
                //队列2赋值给队列1
                queue1 = queue2;
                //队列2创建新的队列
                queue2 = new LinkedList<>();
            }
        }
        //返回结果res
        return res;
    }
}
