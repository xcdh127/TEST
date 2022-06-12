package Leetcode;



/*给定链表 head 和两个整数 m 和 n. 遍历该链表并按照如下方式删除节点:
1.开始时以头节点作为当前节点.
2.保留以当前节点开始的前 m 个节点.
3.删除接下来的 n 个节点.
4.重复步骤 2 和 3, 直到到达链表结尾.
在删除了指定结点之后, 返回修改过后的链表的头节点.
*/
public class Test39 {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        //定义保留链表的尾节点
        ListNode tail=head;
        //指向头的指针
        ListNode cur=head;
        //计数保留的节点
        int baoLiu=m;
        //计数删除的节点
        int shanChu=n;
        //当前节点不为空
        while (cur!=null){
            while (cur!=null && baoLiu>0){
                //尾节点指向cur
                tail=cur;
                //指向下一个节点
                cur=cur.next;
                //保留计数器-1
                baoLiu--;
            }
            while (cur!=null && shanChu>0){
                //向后指向
                cur=cur.next;
                //删除计数器-1
                shanChu--;
            }
            //尾节点的下一个节点连接当前节点
            tail.next=cur;
            //刷新计数器
            baoLiu=m;
            shanChu=n;
        }
        //返回头节点
        return head;
    }
}
/*[1,2,3,4,5,6,7,8,9,10,11,12,13]*/
/*public ListNode deleteNodes(ListNode head, int m, int n) {
    ListNode dummy=head,tail=dummy,cur=head;
    int countM=m,countN=n;
    while(cur!=null){
        while(cur!=null&&countM>0){
            tail=cur;
            cur=cur.next;
            countM--;
        }
        while(cur!=null&&countN>0){
            cur=cur.next;
            countN--;
        }
        tail.next=cur;
        countM=m;
        countN=n;
    }
    return dummy;
}
*/