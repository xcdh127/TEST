package CodeTop02;

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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        //比较当前相邻的两个节点
        while (cur.next != null && cur.next.next != null) {
            //当前节点的下一个值等于当前节点的下一个值的下一个值时，向后找首个不等于当前节点的值
            if (cur.next.val == cur.next.next.val) {
                //取到当前数字
                int curNum = cur.next.val;
                //取到后一个节点
                ListNode temp = cur.next.next;
                while (temp != null && temp.val == curNum) {
                    temp = temp.next;
                }
                //删掉数字相等的节点
                cur.next = temp;
            } else {
                //节点先后遍历
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution66 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            //如果前后两个节点值相等
            if (cur.next.val == cur.next.next.val) {
                int curNum = cur.next.val;
                ListNode temp = cur.next.next;
                while (temp != null && temp.val == curNum) {
                    temp = temp.next;
                }
                cur.next = temp;
            }
            //如果前后两个节点值不相等
            else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
