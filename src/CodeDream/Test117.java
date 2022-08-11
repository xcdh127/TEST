package CodeDream;

import java.util.LinkedList;
import java.util.Queue;

/*给定一个二叉树
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。
进阶：
你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
示例：
输入：root = [1,2,3,4,5,null,7]
输出：[1,#,2,3,#,4,5,7,#]
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
提示：
树中的节点数小于 6000
-100 <= node.val <= 100
*/
// Definition for a Node.

public class Test117 {
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
