package codeTop;
/*给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
示例 1：
输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
示例 2：
输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]
提示：
链表中的节点数目为 n
1 <= k <= n <= 5000
0 <= Node.val <= 1000
进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
*/
public class Test25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        while (head!=null){
            ListNode tail=prev;
            //当剩余节点的个数小于k个时，直接返回链表
            for (int i = 0; i < k; i++) {
                //尾节点向后遍历
                tail=tail.next;
                //尾节点为null时
                if (tail==null){
                    return dummy.next;
                }
            }
            //next指向当前尾节点的下一个节点
            ListNode next=tail.next;
            ListNode[] reverse=reverse(head,tail);
            head=reverse[0];
            tail=reverse[1];
            prev.next=head;
            tail.next=next;
            prev=tail;
            head=tail.next;
        }
        return dummy.next;
    }

    public ListNode[] reverse(ListNode head,ListNode tail){
        //prev指向尾节点的下一个节点
        ListNode prev=tail.next;
        //cur指向头节点
        ListNode cur=head;
        //当prev!=tail时，继续反转链表
        while (prev!=tail){
            ListNode temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        //返回链表，[尾节点，头节点]
        return new ListNode[]{tail,head};
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}



class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //新建一个哨兵节点
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode prev=dummy;
        //当头节点不为空时
        while(head!=null){
            ListNode tail=prev;
            //判断当前链表的长度还够不够k个，不足k个直接将链表返回
            for(int i=0;i<k;i++){
                //尾节点指向尾节点的下一个节点
                tail=tail.next;
                //如果尾节点为空，直接将链表返回
                if(tail==null){
                    return dummy.next;
                }
            }
            //记录next指向尾节点的下一个节点
            ListNode next=tail.next;
            //拿到反转后的链表的头节点以及尾节点
            ListNode[] reverse=reverse(head,tail);
            //反转后的尾节点赋值给头节点
            head=reverse[0];
            //反转后的头结点赋值给尾节点
            tail=reverse[1];
            //将head接在prev的后面
            prev.next=head;
            //将next接在tail的后面
            tail.next=next;
            //将prev指向tail
            prev=tail;
            //将tail.next赋值给head
            head=tail.next;
        }
        return dummy.next;
    }
    //反转头和尾之间(包含头尾)的链表
    public ListNode[] reverse(ListNode head,ListNode tail){
        //将prev指向尾节点的下一个节点
        ListNode prev=tail.next;
        //将cur指向当前的头节点
        ListNode cur=head;
        //当prev不等于tail时,继续反转链表
        while(prev!=tail){
            ListNode temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return new ListNode[]{tail,head};
    }
}