package CodeTop02;


/*给定一个单链表 L 的头节点 head ，单链表 L 表示为：
L0 → L1 → … → Ln - 1 → Ln
请将其重新排列后变为：
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
示例 1：
输入：head = [1,2,3,4]
输出：[1,4,2,3]
示例 2：
输入：head = [1,2,3,4,5]
输出：[1,5,2,4,3]
提示：
链表的长度范围为 [1, 5 * 104]
1 <= node.val <= 1000
*/
public class Test143 {
    public void reorderList(ListNode head) {
        ListNode head1 = head;
        ListNode head2 = split(head);
        head2 = reverse(head2);
        //合并两个链表
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head1 != null || head2 != null) {
            //对链表首尾重排序时，两个链表的if语句都要将当前指针向后指向一位
            if (head1 != null) {
                cur.next = head1;
                head1 = head1.next;
                cur = cur.next;
            }
            if (head2 != null) {
                cur.next = head2;
                head2 = head2.next;
                cur = cur.next;
            }
        }
    }

    //将链表从中间一分为二
    public ListNode split(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = slow.next;
        //拆分链表时，快指针不为空，并且快指针的下一个指针不为空
        while (fast != null && fast.next != null) {
            //慢指针向后指一步，快指针向后指两步
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        ListNode newList = slow.next;
        slow.next = null;
        return newList;
    }

    //反转链表
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
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
class Solution60 {
    public void reorderList(ListNode head) {
        ListNode head1 = head;
        ListNode head2 = split(head);
        head2 = reverse(head2);
        merge(head1, head2);
    }

    public ListNode split(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        ListNode newList = slow.next;
        slow.next = null;
        return newList;
    }

    public ListNode reverse(ListNode root) {
        ListNode prev = null;
        ListNode cur = root;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head1 != null || head2 != null) {
            if (head1 != null) {
                cur.next = head1;
                head1 = head1.next;
                cur = cur.next;
            }
            if (head2 != null) {
                cur.next = head2;
                head2 = head2.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}