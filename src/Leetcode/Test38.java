package Leetcode;

import java.util.List;

/*给你一个单链表的引用结点 head。
链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
请你返回该链表所表示数字的 十进制值 。
*/
public class Test38 {
    public int getDecimalValue(ListNode head) {
        //反转链表
        head=reverse(head);
        //记录链表表示的二进制数字
        int num=0;
        //二进制指数
        int index=0;
        //指向头节点
        ListNode cur=head;
        //当头节点不为空时
        while (cur!=null){
            //当前节点值乘上当前位置的幂次
            num+=Math.pow(2,index++)*cur.val;
            //下一个节点
            cur=cur.next;
        }
        return num;
    }
    //反转链表
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }
}
