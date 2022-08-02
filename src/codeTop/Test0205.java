package codeTop;

/*给定两个用链表表示的整数，每个节点包含一个数位。
这些数位是反向存放的，也就是个位排在链表首部。
编写函数对这两个整数求和，并用链表形式返回结果。
示例：
输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
输出：2 -> 1 -> 9，即912
进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
示例：
输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
输出：9 -> 1 -> 2，即912
*/
public class Test0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //哨兵节点
        ListNode dummy = new ListNode(0);
        //cur指向哨兵节点
        ListNode cur = dummy;
        //当前位置数字和
        int sum = 0;
        //进位
        int carry = 0;
        //当没有加到数字末尾时
        while (l1 != null || l2 != null) {
            //加数1
            int numA = l1 != null ? l1.val : 0;
            //加数2
            int numB = l2 != null ? l2.val : 0;
            //求和
            sum = numA + numB + carry;
            //处理进位
            carry = sum >= 10 ? 1 : 0;
            //当前数位和
            sum = sum >= 10 ? sum - 10 : sum;
            //根据当前数位和新建节点
            cur.next = new ListNode(sum);
            //向后指向一位
            cur = cur.next;
            //l1不为空时，向后指向一位
            if (l1 != null) {
                l1 = l1.next;
            }
            //l2不为空时，向后指向一位
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //进位信息1，新建节点
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        //返回哨兵的下一个节点
        return dummy.next;
    }
}
