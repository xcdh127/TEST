package codeTop;

/*给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动k个位置。
示例 1：
输入：head = [1,2,3,4,5], k = 2
输出：[4,5,1,2,3]
示例 2：
输入：head = [0,1,2], k = 4
输出：[2,0,1]
提示：
链表中节点的数目在范围 [0, 500] 内
-100 <= Node.val <= 100
0 <= k <= 2 * 109
*/
public class Test61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        //当前节点指向头节点
        ListNode cur = head;
        //记录链表节点的个数
        int n = 1;
        /*
         * [1(cur),2,3,4,5]
         * [1(cur),2,3,4,5]
         * [1,2,3,4,5(cur)]->1
         * [1,2,3(cur),4(newHead),5]->1
         * [4(newHead),5]->1->2,3(cur)->null
         * move=5-1-2=2
         * */
        while (cur.next != null) {
            cur = cur.next;
            n++;
        }
        //将链表尾与头连接在一起
        cur.next = head;
        //要移动的步数
        int move = n - 1 - k % n;
        //如果需要移动n位，直接返回头部节点
        if (move == n) {
            return head;
        }
        //从链表尾开始向后遍历链表，遍历到新链表的尾部
        while (move >= 0) {
            move--;
            cur = cur.next;
        }
        //新链表的尾部节点的最后一个节点的next为新链表的开头
        ListNode newHead = cur.next;
        //原链表的尾部为null
        cur.next = null;
        //返回新链表的头部
        return newHead;
    }
}

class Solution12 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        //统计链表的节点个数
        int n = 1;
        while (cur.next != null) {
            cur = cur.next;
            n++;
        }
        //将链表尾与头连接在一起
        cur.next = head;
        int move = n - 1 - k % n;
        if (move == n) {
            return head;
        }
        //从链表的尾部开始向后遍历链表，遍历到新链表的尾部
        while (move >= 0) {
            move--;
            cur = cur.next;
        }
        //新链表的尾部节点的最后一个节点的next为新链表的开头
        ListNode newHead = cur.next;
        //原链表的尾部为null
        cur.next = null;
        return newHead;
    }
}