package codeTop;
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
        //新建哨兵节点
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        //前指针
        ListNode first=dummy;
        //后指针
        ListNode last=dummy;
        //前指针先走n步
        while (n>=0){
            //前指针指向下一个节点
            first=first.next;
            //n减1
            n--;
        }
        //当前指针不为空时
        while (first!=null){
            //前后指针都向后移动一位
            first=first.next;
            last=last.next;
        }
        //后指针的下一个节点，指向后指针的下一个节点
        last.next=last.next.next;
        //返回哨兵节点的下一个节点
        return dummy.next;
    }
}
