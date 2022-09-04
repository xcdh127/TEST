package Jianzhioffer02;

/*输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
示例1：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
限制：
0 <= 链表长度 <= 1000
*/
public class Test25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        //当前指针指向当前节点
        ListNode cur = dummy;
        //l1不为空并且l2不为空时
        while (l1 != null && l2 != null) {
            //l1的值小于l2的值
            if (l1.val < l2.val) {
                //当前节点的下一个
                cur.next = l1;
                l1 = l1.next;
            }
            //l2的值小于l1的值
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            //当前节点的下一个节点
            cur = cur.next;
        }
        //l1节点不为空时，当前节点指向l1节点
        if (l1 != null) {
            cur.next = l1;
        }
        //l2节点不为空时，当前节点指向l2节点
        else {
            cur.next = l2;
        }
        //返回新的头节点
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


