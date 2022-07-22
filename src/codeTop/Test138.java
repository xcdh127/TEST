package codeTop;


/*给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
返回复制链表的头节点。
用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
你的代码 只 接受原链表的头节点 head 作为传入参数。
示例 1：
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
示例 2：
输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
示例 3：
输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
提示：
0 <= n <= 1000
-104 <= Node.val <= 104
Node.random 为 null 或指向链表中的节点。
*/
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

public class Test138 {
    public Node copyRandomList(Node head) {
        //当头节点为空时，返回null
        if (head == null) {
            return null;
        }
        //当前节点指向头节点
        Node cur = head;
        //复制普通节点
        while (cur != null) {
            //记录下当前节点的下一个节点
            Node temp = cur.next;
            //新建节点cur.val
            Node node = new Node(cur.val);
            //将新创建的节点添加到当前节点的next
            cur.next = node;
            //新建节点的next指向temp
            node.next = temp;
            //当前节点为node节点的next
            cur = node.next;
        }
        //cur指向头节点
        cur = head;
        //当前节点不为null并且当前节点的next不为空
        while (cur != null && cur.next != null) {
            //当前节点的随机节点不为null
            if (cur.random != null) {
                //当前节点的下一个节点的随机节点为当前节点的随机节点的next
                cur.next.random = cur.random.next;
            }
            //当前节点指向当前节点的next的next
            cur = cur.next.next;
        }
        //cur指向头节点
        cur = head;
        //新链表为头节点的next节点
        Node newList = head.next;
        //newCur指向新链表
        Node newCur = newList;
        //当cur!=null 并且 newCur!=null
        while (cur != null && newCur != null) {
            //当前节点的next放置newCur.next
            cur.next = newCur.next;
            //当cur.next!=null时
            if (cur.next != null) {
                //newCur.next=cur.next.next
                newCur.next = cur.next.next;
            }
            //两个节点都向后指向
            cur = cur.next;
            newCur = newCur.next;
        }
        //返回新的链表
        return newList;
    }
}
/*class Solution {
public Node copyRandomList(Node head) {
if(head==null){
return null;
}
Node cur=head;
while(cur!=null){
Node temp=cur.next;
Node node=new Node(cur.val);
cur.next=node;
node.next=temp;
cur=temp;
}
cur=head;
while(cur!=null && cur.next!=null ){
if(cur.random!=null){
cur.next.random=cur.random.next;
}
if(cur!=null){
cur=cur.next.next;
}
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