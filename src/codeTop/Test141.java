package codeTop;
/*给你一个链表的头节点 head ，判断链表中是否有环。
如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
如果链表中存在环 ，则返回 true 。 否则，返回 false 。
示例 1：
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
示例 2：
输入：head = [1,2], pos = 0
输出：true
解释：链表中有一个环，其尾部连接到第一个节点。
示例 3：
输入：head = [1], pos = -1
输出：false
解释：链表中没有环。
提示：
链表中节点的数目范围是 [0, 104]
-105 <= Node.val <= 105
pos 为 -1 或者链表中的一个 有效索引 。
*/
public class Test141 {
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null){
            return false;
        }
        ListNode slow=head.next;
        ListNode fast=slow.next;
        //当fast!=slow时，并且fast!=null时，继续向后遍历,慢指针走一步，快指针走两步
        while (fast!=null && fast!=slow){
            slow=slow.next;
            fast=fast.next;
            if (fast!=null){
                fast=fast.next;
            }
        }
        //慢指针指向头节点
        slow=head;
        //当fast!=slow时，并且fast!=null时，继续向后遍历，快指针走一步，慢指针走一步
        while (fast!=slow && fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        //当快指针和慢指针相遇时，判断两个指针是否相遇
        return fast==slow;
    }
}
