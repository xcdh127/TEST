package codetophuawei;

/*给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
示例 1：
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：
输入：head = [1], n = 1
输出：[]
示例 3：
输入：head = [1,2], n = 1
输出：[1]
提示：
链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
*/
public class Test19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //哨兵节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //前指针
        ListNode prev = dummy;
        //后指针
        ListNode next = dummy;
        //当n大于等于0时，前指针向后指向一位
        while (n >= 0) {
            prev = prev.next;
            n--;
        }
        //当前指针没有指向空时
        while (prev != null) {
            //前指针向后指向
            prev = prev.next;
            //后指针先后指向
            next = next.next;
        }
        //删掉后指针后的节点
        next.next = next.next.next;
        //返回删除节点后的原链表
        return dummy.next;
    }
}
