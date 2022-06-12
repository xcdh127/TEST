package JianZHiOffer;
/*输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
要求不能创建任何新的节点，只能调整树中节点指针的指向。
为了让您更好地理解问题，以下面的二叉搜索树为例：
我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
特别地，我们希望可以就地完成转换操作。当转化完成以后，
树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
*/
public class Test38 {
    Node_ head=null;
    Node_ prev=null;
    public Node_ treeToDoublyList(Node_ root) {
        if (root==null) return null;
        recur(root);
        prev.right=head;
        head.left=prev;
        return head;
    }

    public void recur(Node_ root){
        if (root==null)return;
        //左
        recur(root.left);
        //根
        //前一个节点为空时，头节点为root
        if (prev==null){
            head=root;
        }
        //前一个节点不为空时，前一个节点的右子节点(双向链表的next)为root
        else {
            prev.right=root;
        }
        //当前节点的左子节点(双向链表的prev)为prev
        root.left=prev;
        //前一个节点指向当前节点
        prev=root;
        //右
        recur(root.right);
    }
}

class Node_ {
    public int val;
    public Node_ left;
    public Node_ right;

    public Node_() {}

    public Node_(int _val) {
        val = _val;
    }

    public Node_(int _val,Node_ _left,Node_ _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

/*class Solution {
	  Node prev=null;
	  Node head=null;

    public Node treeToDoublyList(Node root) {

			if(root==null){

				return null;
			}
			recur(root);
			prev.right=head;
			head.left=prev;
			return head;

    }

		public void recur(Node cur){

			if(cur==null){
				return ;
			}
			//左
			recur(cur.left);
			//根
			if(prev==null){

				head=cur;
			}else{
			prev.right=cur;
			}
			cur.left=prev;
			prev=cur;
			recur(cur.right);
		}

}*/
