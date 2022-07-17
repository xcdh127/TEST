package codeTop;
/*给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
示例 1:
输入：head = [4,2,1,3]
输出：[1,2,3,4]
示例 2:
输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
示例 3：
输入：head = []
输出：[]
提示：
链表中节点的数目在范围 [0, 5 * 104] 内
-105 <= Node.val <= 105
进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
*/
public class Test148 {
    public ListNode sortList(ListNode head) {
        return splitAndMerge(head);
    }

    public ListNode splitAndMerge(ListNode head){
        //拆分并且合并，当头节点为空时，或者头节点的下一个节点为空时，直接返回head
        if (head==null || head.next==null){
            return head;
        }
        //拆分链表
        ListNode head1=head;
        ListNode head2=split(head);
        head1=splitAndMerge(head1);
        head2=splitAndMerge(head2);
        //合并链表
        return merge(head1,head2);
    }
    //拆分链表
    public ListNode split(ListNode head){
        ListNode slow=head;
        ListNode fast=slow.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
            if (fast!=null){
                fast=fast.next;
            }
        }
        ListNode newList=slow.next;
        slow.next=null;
        return newList;
    }

    //合并链表
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        while (head1!=null && head2!=null){
            if (head1.val<head2.val){
                cur.next=head1;
                head1=head1.next;
            }
            else {
                cur.next=head2;
                head2=head2.next;
            }
            cur=cur.next;
        }
        if (head1!=null){
            cur.next=head1;
        }
        else{
            cur.next=head2;
        }
        return dummy.next;
    }
}
