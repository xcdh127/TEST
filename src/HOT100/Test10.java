package HOT100;

import java.util.List;

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
public class Test10 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        while (n>=0){
            prev=prev.next;
            n--;
        }
        ListNode latter=dummy;
        while (prev!=null){
            prev=prev.next;
            latter=latter.next;
        }
        latter.next=latter.next.next;
        return dummy.next;
    }
}
