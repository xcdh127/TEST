package CodeDream;
/*给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。
示例 1：
输入：root = [1,2,3,4,5,6,7]
输出：[1,#,2,3,#,4,5,6,7,#]
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
示例 2:
输入：root = []
输出：[]
提示：
树中节点的数量在 [0, 212 - 1] 范围内
-1000 <= node.val <= 1000
进阶：
你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
*/
// Definition for a Node.

import java.util.LinkedList;
import java.util.Queue;

public class Test116 {
    public Node connect(Node root) {
        Node prev = null;
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        //向队列1中放进root
        queue1.offer(root);
        //当队列1不为空时
        while (!queue1.isEmpty()) {
            //处理当前节点
            Node temp = queue1.poll();
            //当前节点不为空
            if (temp != null) {
                //prev不为空时
                if (prev != null) {
                    //prev的next连temp
                    prev.next = temp;
                }
                //前一个节点指向temp
                prev = temp;
                //当前节点的left不为空时，放进队列2
                if (temp.left != null) {
                    queue2.offer(temp.left);
                }
                //当前节点的right不为空时，放进队列2
                if (temp.right != null) {
                    queue2.offer(temp.right);
                }
            }
            //当队列1位空时
            if (queue1.isEmpty()) {
                //prev置为空
                prev = null;
                //队列2赋值给队列1
                queue1 = queue2;
                //新建队列2
                queue2 = new LinkedList<>();
            }
        }
        //返回修改后的树
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
