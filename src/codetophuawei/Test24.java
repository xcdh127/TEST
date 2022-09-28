package codetophuawei;

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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        //当链表后面有两个节点时，交换这两个节点的位置
        while (cur.next != null && cur.next.next != null) {
            //头节点1
            ListNode head1 = cur.next;
            //头节点2
            ListNode head2 = cur.next.next;
            //临时记录头节点2后的节点
            ListNode temp = head2.next;
            //当前节点后的节点为头结点2
            cur.next = head2;
            //头结点2后的节点时头节点1
            head2.next = head1;
            //头节点1后的节点是临时节点
            head1.next = temp;
            //当前节点指向头结点1
            cur = head1;
        }
        //返回修改后的链表
        return dummy.next;
    }
}
