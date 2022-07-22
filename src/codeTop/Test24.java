package codeTop;
/*给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
示例 1：
输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：
输入：head = []
输出：[]
示例 3：
输入：head = [1]
输出：[1]
提示：
链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100
*/
//dummy->1->2->3->4
public class Test24 {
    public ListNode swapPairs(ListNode head) {
        //创建哨兵节点
        ListNode dummy=new ListNode(0);
        //哨兵节点的下一个节点为head
        dummy.next=head;
        //cur指向dummy
        ListNode cur=dummy;
        //交换cur节点后的两个节点的次序
        while (cur.next!=null && cur.next.next!=null){
            //取到cur节点的下一个节点
            ListNode next1=cur.next;
            //取到cur节点的下一个节点的下一个节点
            ListNode next2=cur.next.next;
            //取到第二个节点后的节点next
            ListNode next=next2.next;
            //穿栈引线一顿操作
            cur.next=next2;
            next2.next=next1;
            next1.next=next;
            //指向第二个节点，进行后续的修改
            cur=cur.next.next;
        }
        //返回原链表
        return dummy.next;
    }
}
