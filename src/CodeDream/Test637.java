package CodeDream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

/*给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：[3.00000,14.50000,11.00000]
解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
因此返回 [3, 14.5, 11] 。
示例 2:
输入：root = [3,9,20,15,7]
输出：[3.00000,14.50000,11.00000]
提示：
树中节点数量在 [1, 104] 范围内
-231 <= Node.val <= 231 - 1
*/
public class Test637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //队列1
        Queue<TreeNode> queue1 = new LinkedList<>();
        //队列2
        Queue<TreeNode> queue2 = new LinkedList<>();
        //向队列1中添加根节点
        queue1.offer(root);
        //记录每一层的和
        double sum = 0;
        //记录这一行几个节点
        int count = 0;
        //当队列1不为空时
        while (!queue1.isEmpty()) {
            //处理当前节点
            TreeNode temp = queue1.poll();
            //当前节点不为空时
            if (temp != null) {
                sum += temp.val;
                count++;
                //当前节点的左子节点不为空时
                if (temp.left != null) {
                    //向队列2添加当前节点的左子节点
                    queue2.offer(temp.left);
                }
                //当前节点额的右子节点不为空时
                if (temp.right != null) {
                    //向队列2添加当前节点的右子节点
                    queue2.offer(temp.right);
                }
            }
            //当队列1为空时
            if (queue1.isEmpty()) {
                //向结果数组中添加这个一行所有节点值的平均值
                res.add(sum / count);
                //和归零
                sum = 0;
                //记录节点数归零
                count = 0;
                //将队列2赋值给队列1
                queue1 = queue2;
                //新建队列2
                queue2 = new LinkedList<>();
            }
        }
        //返回结果集
        return res;
    }
}
