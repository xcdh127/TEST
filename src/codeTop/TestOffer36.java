package codeTop;
/*输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
为了让您更好地理解问题，以下面的二叉搜索树为例：
我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，
最后一个节点的后继是第一个节点。
下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
*/
public class TestOffer36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node prev=null;
    Node head=null;
    public Node treeToDoublyList(Node root) {
        //如果根节点==null，直接返回null
        if (root==null){
            return null;
        }
        //递归
        recur(root);
        //尾节点的右子节点是头节点
        prev.right=head;
        //头节点的左子节点是prev
        head.left=prev;
        //返回头节点
        return head;
    }

    public void recur(Node root){
        if (root==null){
            return;
        }
        //左
        recur(root.left);
        //根
        //当prev为空时，此时root就是双向链表的头节点
        if (prev==null){
            head=root;
        }
        //此处两步是二叉搜索树，转换成双向链表的关键
        //当prev不为空时，此时prev的右子节点就是root
        else {
            prev.right=root;
        }
        //root的左子节点为prev
        root.left=prev;
        //将prev指向当前节点root
        prev=root;
        //右
        recur(root.right);
    }
}
