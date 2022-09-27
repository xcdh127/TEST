package codetophuawei;

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
*/
public class Test92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //新建哨兵节点
        ListNode dummy = new ListNode(0);
        //哨兵节点后面街上原链表
        dummy.next = head;
        //前一个节点prev指向dummy
        ListNode prev = dummy;
        //当i小于left-1时，prev一直向后指向一位
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        //当前节点为prev节点
        ListNode cur = prev.next;
        //当i小于right-left时
        for (int i = 0; i < right - left; i++) {
            //next节点为cur节点的next
            ListNode next = cur.next;
            //cur节点的next为next节点的next
            cur.next = next.next;
            //next节点的next为prev节点的next
            next.next = prev.next;
            //prev的next为next
            prev.next = next;
        }
        //返回修改后的原链表
        return dummy.next;
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
class Solution118 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode cur = prev.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }
}