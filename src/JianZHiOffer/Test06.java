package JianZHiOffer;

import java.util.ArrayList;
import java.util.List;

/*输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
示例 1：
输入：head = [1,3,2]
输出：[2,3,1]
限制：
0 <= 链表长度 <= 10000
*/
public class Test06 {
    public int[] reversePrint(ListNode head) {
        ListNode newList=reverseList(head);
        List<Integer> list=new ArrayList<>();
        ListNode cur=newList;
        while (cur!=null){
            list.add(cur.val);
            cur=cur.next;
        }
        return list.stream().mapToInt(i->i).toArray();
    }
    public ListNode reverseList(ListNode head){
        ListNode cur=head;
        ListNode prev=null;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }
}

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
