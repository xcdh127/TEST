 package Leetcode;
/*给定一个头结点为 head 的非空单链表，返回链表的中间结点。

如果有两个中间结点，则返回第二个中间结点。*/

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class Test37 {
    public ListNode middleNode(ListNode head) {
        return split(head);
    }

    public ListNode split(ListNode head){
        //当头节点为空或者头节点后的节点为空时，直接返回head
        if (head==null || head.next==null){
            return head;
        }
        //慢指针指向头节点的后一个节点
        ListNode slow=head.next;
        //快指针指向慢指针的后一个节点
        ListNode fast=slow.next;
        //当快指针不为空并且快指针的下一个节点不为空时
        //慢指针向后指一步，快指针向后指两步
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
            if (fast!=null){
                fast=fast.next;
            }
        }
        //返回链表后一半的头指针
        return slow;
    }
}
