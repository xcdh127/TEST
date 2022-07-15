package codeTop;
/*给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
示例 1：
输入：head = [1,2,3,3,4,4,5]
输出：[1,2,5]
示例 2：
输入：head = [1,1,1,2,3]
输出：[2,3]
提示：
链表中节点数目在范围 [0, 300] 内
-100 <= Node.val <= 100
题目数据保证链表已经按升序 排列
*/
public class Test82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        //当前节点首先指向哨兵节点
        ListNode cur=dummy;
        //当前节点的下一个节点不为空，并且当前节点的下一个节点的下一个节点不为空时
        while (cur.next!=null && cur.next.next!=null){
            //如果前后两个节点值相等
            if (cur.next.val==cur.next.next.val){
                //拿到当前值，向后比较，直到不相等
                int curNum=cur.next.val;
                ListNode temp=cur.next.next;
                //后面的节点值等于当前值，继续向后遍历
                while (temp!=null && temp.val==curNum){
                    temp=temp.next;
                }
                //当前节点的下一个节点指向temp
                cur.next=temp;
            }
            //如果前后两个节点值不相等，当前节点指向下一个节点
            else {
                cur=cur.next;
            }
        }
        //返回去掉重复数字的节点
        return dummy.next;
    }
}
