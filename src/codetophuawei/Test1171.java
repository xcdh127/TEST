package codetophuawei;

/*给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
删除完毕后，请你返回最终结果链表的头节点。
你可以返回任何满足题目要求的答案。
（注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
示例 1：
输入：head = [1,2,-3,3,1]
输出：[3,1]
提示：答案 [1,2,1] 也是正确的。
示例 2：
输入：head = [1,2,3,-3,4]
输出：[1,2,4]
示例 3：
输入：head = [1,2,3,-3,-2]
输出：[1]
提示：
给你的链表中可能有 1 到 1000 个节点。
对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
*/
public class Test1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev != null) {
            //取prev节点的后一个节点
            ListNode next = prev.next;
            int sum = 0;
            while (next != null) {
                sum += next.val;
                //当和等于0时，prev节点的next指向next节点的next
                if (sum == 0) {
                    prev.next = next.next;
                    break;
                }
                //和不为0，next继续向后指向
                else {
                    next = next.next;
                }
            }
            //当next指针为空时
            if (next == null) {
                //prev向后指向一位
                prev = prev.next;
            }
        }
        //返回修改后的链表
        return dummy.next;
    }
}


class Solution155 {

    public ListNode removeZeroSumSublists(ListNode head) {

        if (head == null) return head;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        while (pre != null) {

            ListNode p = pre.next;
            int sum = 0;
            while (p != null) {

                sum += p.val;
                if (sum == 0) {

                    pre.next = p.next;
                    break;
                } else {

                    p = p.next;
                }
            }
            if (p == null) pre = pre.next;
        }
        return dummyHead.next;
    }
}
