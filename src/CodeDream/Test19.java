package CodeDream;

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
        //原链表接在哨兵节点后面
        dummy.next = head;
        //前指针
        ListNode prev = dummy;
        //后指针
        ListNode post = dummy;
        //前指针先走n步
        while (n >= 0) {
            prev = prev.next;
            n--;
        }
        //然后一起向后走，直到前指针为空
        while (prev != null) {
            prev = prev.next;
            post = post.next;
        }
        //删除这个节点
        post.next = post.next.next;
        //返回修改后的链表
        return dummy.next;
    }
}
