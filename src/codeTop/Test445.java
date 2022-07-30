package codeTop;

public class Test445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //反转链表l1
        l1=reverse(l1);
        //反转链表l2
        l2=reverse(l2);
        //curA指向链表l1的头部
        ListNode curA = l1;
        //curB指向链表l2的头部
        ListNode curB = l2;
        //新建哨兵节点
        ListNode dummy = new ListNode(0);
        //cur指向哨兵节点
        ListNode cur = dummy;
        //求和
        int sum = 0;
        //进位信息carry
        int carry = 0;
        //当没有指向两个链表的末尾时
        while (curA != null || curB != null) {
            //加数A
            int numA = curA == null ? 0 : curA.val;
            //加数B
            int numB = curB == null ? 0 : curB.val;
            //求此位的和，加数A+加数B+进位数字
            sum = numA + numB + carry;
            //进位信息，判断和是否大于等于10，决定进位信息1或者0
            carry = sum >= 10 ? 1 : 0;
            //此位的和
            sum = sum >= 10 ? sum - 10 : sum;
            //当前节点cur的下一个节点sum
            cur.next = new ListNode(sum);
            //当前节点指向下一个节点
            cur = cur.next;
            //如果l1链表没有指到尾部，继续向后指向一位
            if (curA != null) {
                curA = curA.next;
            }
            //如果l2链表没与直到尾部，继续向后指向一位
            if (curB != null) {
                curB = curB.next;
            }
        }
        //如果进位信息为1，当前节点后面添加进位信息
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        //
        return reverse(dummy.next);
    }

    //反转链表
    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
