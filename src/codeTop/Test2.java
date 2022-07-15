package codeTop;
/*给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例 1：
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
示例 2：
输入：l1 = [0], l2 = [0]
输出：[0]
示例 3：
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
提示：
每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零
*/
public class Test2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //哨兵节点
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        //和
        int sum=0;
        //进位
        int carry=0;
        //当指针没有指向两个链表的末尾时，继续向后指向
        while (l1!=null || l2!=null){
            //加数A
            int numA=l1!=null?l1.val:0;
            //加数B
            int numB=l2!=null? l2.val : 0;
            //求数位和
            sum=numA+numB+carry;
            //处理进位
            carry=sum>=10?1:0;
            //处理次位和
            sum=sum>=10?sum-10:sum;
            //将次位和的结果添加到链表的末尾
            cur.next=new ListNode(sum);
            //cur向后指向一位
            cur=cur.next;
            //l1不为空时，继续向后遍历
            if (l1!=null){
                l1=l1.next;
            }
            //l2不为空时，继续向后遍历
            if (l2!=null){
                l2=l2.next;
            }
        }
        //当有进位时，向链表的末尾添加进位信息1
        if (carry==1){
            cur.next=new ListNode(1);
        }
        //返回链表
        return dummy.next;
    }
}
