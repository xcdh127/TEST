package codeTop;

import java.util.ArrayList;
import java.util.List;

/*给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
示例 1：
输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]
示例 2：
输入：head = [5], left = 1, right = 1
输出：[5]
提示：
链表中节点数目为 n
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
进阶： 你可以使用一趟扫描完成反转吗？
*/
public class Test92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //prev指向哨兵节点
        ListNode prev = dummy;
        //将prev指向left位置的前一个节点
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        //当前节点为prev的下一个节点
        ListNode cur = prev.next;
        //下一个节点
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            //下一个节点为当前节点的下一个节点
            next = cur.next;
            //当前节点的一个节点为next节点的下一个节点
            cur.next = next.next;
            //next节点的下一个节点为prev的下一个节点
            next.next = prev.next;
            //prev的下一个节点为next
            prev.next = next;
        }
        //返回哨兵节点的next的节点
        return dummy.next;
    }
}

class Solution1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode prev=dummy;
        for(int i=0;i<left-1;i++){

            prev=prev.next;

        }

        ListNode cur=prev.next;
        ListNode next;
        for(int i=0;i<right-left;i++){

            next=cur.next;
            cur.next=next.next;
            next.next=prev.next;
            prev.next=next;
        }
        return dummy.next;



    }
}


