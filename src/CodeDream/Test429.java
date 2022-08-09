package CodeDream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
示例 1：
输入：root = [1,null,3,2,4,null,5,6]
输出：[[1],[3,2,4],[5,6]]
示例 2：
输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
提示：
树的高度不会超过 1000
树的节点总数在 [0, 10^4] 之间
*/
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Test429 {
    public List<List<Integer>> levelOrder(Node root) {
        //结果集
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //队列1
        Queue<Node> queue1 = new LinkedList<>();
        //队列2
        Queue<Node> queue2 = new LinkedList<>();
        //队列1存放root
        queue1.offer(root);
        //存放n叉树的每一层节点
        List<Integer> list = new ArrayList<>();
        //当队列1不为空时
        while (!queue1.isEmpty()) {
            //处理当前节点
            Node temp = queue1.poll();
            //当前节点不为空时
            if (temp != null) {
                //将当前节点放进这一层数组中
                list.add(temp.val);
                //遍历这个节点的所有的子节点，放进队列2中
                for (Node child : temp.children) {
                    queue2.offer(child);
                }
            }
            //当队列1为空时
            if (queue1.isEmpty()) {
                //结果集添加这个一层节点
                res.add(list);
                //新建下一层数组
                list = new ArrayList<>();
                //队列2赋值给队列1
                queue1 = queue2;
                //新建队列2
                queue2 = new LinkedList<>();
            }
        }
        //返回结果
        return res;
    }
}
