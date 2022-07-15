package codeTop;


/*输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
示例：
给定一个链表: 1->2->3->4->5, 和 k = 2.
返回链表 4->5.
*/
public class Test22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        //前指针
        ListNode prev=dummy;
        //后指针
        ListNode next=dummy;
        //当k大于等于0时，前指针向后指向，k--
        while (k>=0){
            prev=prev.next;
            k--;
        }
        //当前指针不为空时，前指针和后指针都向后指向一位
        while (prev!=null){
            prev=prev.next;
            next=next.next;
        }
        //返回后指针的后指针
        return next.next;
    }
}
