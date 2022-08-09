package CodeDream;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

/*给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：[[15,7],[9,20],[3]]
示例 2：
输入：root = [1]
输出：[[1]]
示例 3：
输入：root = []
输出：[]
提示：
树中节点数目在范围 [0, 2000] 内
-1000 <= Node.val <= 1000
*/
public class Test107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //root为空时，直接返回res
        if (root == null) {
            return res;
        }
        //队列1
        Queue<TreeNode> queue1 = new LinkedList<>();
        //队列2
        Queue<TreeNode> queue2 = new LinkedList<>();
        //向队列1中添加根节点
        queue1.offer(root);
        //存放每一层的节点
        List<Integer> list = new ArrayList<>();
        //当队列1不为空时
        while (!queue1.isEmpty()) {
            //处理当前节点
            TreeNode temp = queue1.poll();
            //当前节点不为空时
            if (temp != null) {
                //将当前节点放进这一层的数组中
                list.add(temp.val);
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
                //向结果数组中添加这个一行节点值
                res.add(list);
                //新建数组存下一行节点
                list = new ArrayList<>();
                //将队列2赋值给队列1
                queue1 = queue2;
                //新建队列2
                queue2 = new LinkedList<>();
            }
        }
        //反转数组，输出
        Collections.reverse(res);
        return res;
    }
}
