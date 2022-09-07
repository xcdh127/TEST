package CodeTop02;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/*给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，
那么请将最后剩余的节点保持原有顺序。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
示例 1：
输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
示例 2：
输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]
提示：
链表中的节点数目为 n
1 <= k <= n <= 5000
0 <= Node.val <= 1000*/
public class Test25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            ListNode tail = prev;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            //next记录尾节点的下一个节点
            ListNode next = tail.next;
            //反转首尾节点
            ListNode[] reverse = reverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            //前指针的next指向head
            prev.next = head;
            //指针的next指向next
            tail.next = next;
            //前指针指向尾节点
            prev = tail;
            //头节点为尾节点的next节点
            head = tail.next;
        }
        //返回dummy的下一个节点
        return dummy.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        //前指针prev指向尾节点的下一个节点
        ListNode prev = tail.next;
        //当前节点指向头节点
        ListNode cur = head;
        //当前指针没有指向尾节点时，继续反转链表
        while (prev != tail) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        //返回[尾节点，头节点]
        return new ListNode[]{tail, head};
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution50 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            ListNode tail = prev;
            //当剩余节点的个数小于k个时，直接返回链表
            for (int i = 0; i < k; i++) {
                //尾节点向后遍历
                tail = tail.next;
                //尾节点为null时
                if (tail == null) {
                    return dummy.next;
                }
            }
            //next指向当前尾节点的下一个节点
            ListNode next = tail.next;
            ListNode[] reverse = reverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            prev.next = head;
            tail.next = next;
            prev = tail;
            head = tail.next;
        }
        return dummy.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        //prev指向尾节点的下一个节点
        ListNode prev = tail.next;
        //cur指向头节点
        ListNode cur = head;
        //当prev!=tail时，继续反转链表
        while (prev != tail) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        //返回链表，[尾节点，头节点]
        return new ListNode[]{tail, head};
    }
}