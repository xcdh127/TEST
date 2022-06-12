package JianZHiOffer;
/*请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
示例 1：
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
示例 2：
输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
示例 3：
输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
示例 4：
输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。
提示：
-10000 <= Node.val <= 10000
Node.random 为空（null）或指向链表中的节点。
节点数目不超过 1000 。
*/
public class Test37 {
    public Node copyRandomList(Node head) {
        if (head==null)return null;
        //指向头节点
        Node cur=head;
        while (cur!=null){
            Node node=new Node(cur.val);
            Node temp=cur.next;
            node.next=temp;
            cur.next=node;
            cur=temp;
        }
        //指向头节点
        cur=head;
        //复制随机节点
        while (cur!=null && cur.next!=null){
            if (cur.random!=null){
                cur.next.random=cur.random.next;
            }
            cur=cur.next.next;
        }
        cur=head;
        Node newList=head.next;
        Node newCur=newList;
        while (cur!=null && newCur!=null){
            cur.next=newCur.next;
            if (cur.next!=null){
                newCur.next=cur.next.next;
            }
            cur=cur.next;
            newCur=newCur.next;
        }
        return newList;
    }
}

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
/*class Solution {
    public Node copyRandomList(Node head) {
    	if(head==null){
    		return null;
    	}

    	Node cur=head;

    	while(cur!=null){

    		Node node=new Node(cur.val);

    		Node temp=cur.next;

    		node.next=temp;

    		cur.next=node;

    		cur=temp;
    	}

    	cur=head;

    	while(cur!=null && cur.next!=null){

    		if(cur.random!=null){
    	    cur.next.random=cur.random.next;
    		}
    		cur=cur.next.next;
    	}

    	Node newList=head.next;

    	Node newCur=newList;

    	cur=head;

    	while(cur!=null && newCur!=null){

    		cur.next=newCur.next;

    		if(cur.next!=null){
    		newCur.next=cur.next.next;
    		}

    		cur=cur.next;

    		newCur=newCur.next;
    	}

    	return newList;

    }
}*/
