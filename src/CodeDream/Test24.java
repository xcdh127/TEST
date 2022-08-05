package CodeDream;

import java.util.List;

/*给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
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
public class Test24 {
    public ListNode swapPairs(ListNode head) {
        //哨兵节点
        ListNode dummy = new ListNode(0);
        //哨兵节点后根原链表
        dummy.next = head;
        //当前节点指向哨兵节点
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            /*0[1,2,3,4]*/
            //取到要交换位置的两个节点
            ListNode head1 = cur.next;
            ListNode head2 = cur.next.next;
            //temp记录head2的后面节点
            ListNode temp = head2.next;
            //当前节点后面跟head2
            cur.next = head2;
            //head2后面跟head1
            head2.next = head1;
            //head1后面跟temp
            head1.next = temp;
            //越过这两个节点
            cur = cur.next.next;
        }
        //返回修改后的链表
        return dummy.next;
    }
}
