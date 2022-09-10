package CodeTop02;

import java.util.List;

/*给你一个链表数组，每个链表都已经按升序排列。
请你将所有链表合并到一个升序链表中，返回合并后的链表。
示例 1：
输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
示例 2：
输入：lists = []
输出：[]
示例 3：
输入：lists = [[]]
输出：[]
提示：
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4
*/
public class Test23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        //如果链表长度为0，返回空
        if (lists.length == 0) {
            return null;
        }
        return recur(lists, 0, n - 1);
    }

    public ListNode recur(ListNode[] lists, int l, int r) {
        if (l >= r) {
            return lists[l];
        }
        //取到数组中点位置
        int m = l + (r - l) / 2;
        //将数组拆分成前半部分和后半部分
        ListNode head1 = recur(lists, l, m);
        ListNode head2 = recur(lists, m + 1, r);
        //排序合并这两个部分
        return merge(head1, head2);
    }

    //将两个有序链表合并
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }
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
class Solution58 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        return splitAndMerge(lists, 0, n - 1);
    }

    public ListNode splitAndMerge(ListNode[] lists, int l, int r) {
        int n = lists.length;
        if (l >= r) {
            return lists[l];
        }
        int m = l + (r - l) / 2;
        ListNode head1 = splitAndMerge(lists, l, m);
        ListNode head2 = splitAndMerge(lists, m + 1, r);
        return merge(head1, head2);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }
        return dummy.next;
    }
}