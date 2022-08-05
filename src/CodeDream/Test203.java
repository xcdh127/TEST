package CodeDream;

/*给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
示例 1：
输入：head = [1,2,6,3,4,5,6], val = 6
输出：[1,2,3,4,5]
示例 2：
输入：head = [], val = 1
输出：[]
示例 3：
输入：head = [7,7,7,7], val = 7
输出：[]
提示：
列表中的节点数目在范围 [0, 104] 内
1 <= Node.val <= 50
0 <= val <= 50
*/
public class Test203 {
    public ListNode removeElements(ListNode head, int val) {
        //新建哨兵节点
        ListNode dummy = new ListNode(-1);
        //原链表添加到哨兵节点后面
        dummy.next = head;
        //当前节点cur指向哨兵节点
        ListNode cur = dummy;
        //当前节点不为空，并且当前节点的下一个节点不为空时
        while (cur != null && cur.next != null) {
            //当前节点的下一个节点的值等于要删除的节点的值
            //将当前节点的下一个节点指向下一个节点
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }
            //否则当前节点向后指向
            else {
                cur = cur.next;
            }
        }
        //返回修理后的链表
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}