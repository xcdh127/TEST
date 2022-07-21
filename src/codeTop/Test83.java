package codeTop;
/*给定一个已排序的链表的头head，删除所有重复的元素，使每个元素只出现一次。返回 已排序的链表。
示例 1：
输入：head = [1,1,2]
输出：[1,2]
示例 2：
输入：head = [1,1,2,3,3]
输出：[1,2,3]
提示：
链表中节点数目在范围 [0, 300] 内
-100 <= Node.val <= 100
题目数据保证链表已经按升序 排列
*/
public class Test83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        //当前节点指向head
        ListNode cur=head;
        //当cur不为空，并且cur.next不为空时
        while (cur!=null && cur.next!=null){
            //比较前后两个节点的值是否相等
            if (cur.val==cur.next.val){
                //取到当前节点的值
                int num=cur.next.val;
                //temp指向后面到节点
                ListNode temp=cur.next;
                //当temp指向的节点不为空时，并且temp指向的节点的值等于num时，temp继续向后指向
                while (temp!=null && temp.val==num){
                    temp=temp.next;
                }
                //当前cur节点的下一个节点指向temp，此时删掉了所有等于num值的节点
                cur.next=temp;
            }
            //当前后两个节点不相等时，指向cur的后一个节点
            else {
                cur=cur.next;
            }
        }
        //返回当前链表
        return dummy.next;
    }
}
