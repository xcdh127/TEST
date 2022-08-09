package CodeDream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test199 {
    public List<Integer> rightSideView(TreeNode root) {
        //存放每一层最右边的节点数字
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //队列1
        Queue<TreeNode> queue1 = new LinkedList<>();
        //队列2
        Queue<TreeNode> queue2 = new LinkedList<>();
        //向队列1中添加根节点
        queue1.offer(root);
        //当队列1不为空时
        while (!queue1.isEmpty()) {
            //处理当前节点
            TreeNode temp = queue1.poll();
            //当前节点不为空时
            if (temp != null) {
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
                //将最后一个节点的值放进结果数组中
                res.add(temp.val);
                //将队列2赋值给队列1
                queue1 = queue2;
                //新建队列2
                queue2 = new LinkedList<>();
            }
        }
        return res;
    }
}
