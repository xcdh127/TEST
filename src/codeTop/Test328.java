package codeTop;

/*给定单链表的头节点head，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
第一个节点的索引被认为是 奇数 ， 第二个节点的索引为偶数 ，以此类推。
请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
你必须在O(1)的额外空间复杂度和O(n)的时间复杂度下解决这个问题。
示例 1:
输入: head = [1,2,3,4,5]
输出:[1,3,5,2,4]
示例 2:
输入: head = [2,1,3,5,6,4,7]
输出: [2,3,6,7,1,5,4]
提示:
n == 链表中的节点数
0 <= n <= 104
-106<= Node.val <= 106
*/
public class Test328 {
    public ListNode oddEvenList(ListNode head) {
        //当头节点等于null
        if (head == null) {
            return null;
        }
        //cur节点指向头节点
        ListNode cur = head;
        //新链表指向head.next
        ListNode newList = head.next;
        //newCur指向新链表
        ListNode newCur = newList;
        //当cur.next不为空，并且newCur.next不为空
        while (cur.next != null && newCur.next != null) {
            //cur.next指向新节点newCur的next
            cur.next = newCur.next;
            //cur.next不为空时，newCur.next指向cur.next.next
            if (cur.next != null) {
                newCur.next = cur.next.next;
            }
            //两个节点都向后指向一位
            cur = cur.next;
            newCur = newCur.next;
        }
        //将原链表的next接在新链表中
        cur.next = newList;
        //返回头节点head
        return head;
    }
}

class Solution22 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = head.next;
        ListNode newCur = newHead;
        ListNode cur = head;
        while (cur.next != null && newCur.next != null) {

            cur.next = newCur.next;
            if (cur.next != null) newCur.next = cur.next.next;
            cur = cur.next;
            newCur = newCur.next;
        }
        cur.next = newHead;
        return head;

    }
}
