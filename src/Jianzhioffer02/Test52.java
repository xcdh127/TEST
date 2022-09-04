package Jianzhioffer02;

/*输入两个链表，找出它们的第一个公共节点。
如下面的两个链表
在节点 c1 开始相交。
示例 1：
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
示例 2：
输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Reference of the node with value = 2
输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
示例 3
输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
解释：这两个链表不相交，因此返回 null。
*/
public class Test52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //curA指向headA
        ListNode curA = headA;
        //curB指向headB
        ListNode curB = headB;
        //记录两个节点的节点个数
        int countA = 0;
        int countB = 0;
        //当curA不为空时记录A链表的节点个数
        while (curA != null) {
            curA = curA.next;
            countA++;
        }
        //当curB不为空时记录B链表的节点个数
        while (curB != null) {
            curB = curB.next;
            countB++;
        }
        //当前节点指向A链表的头节点
        curA = headA;
        //当前节点指向B链表的头节点
        curB = headB;
        //记录节点个数差值
        int dif = countA - countB;
        //如果差值大于0，指向1A链表的指针向后指向，直到dif等于0
        if (dif > 0) {
            while (dif > 0) {
                curA = curA.next;
                dif--;
            }
        }
        //如果差值小于0，指向B链表的指针向后指向，直到dif等于0
        else {
            dif = -dif;
            while (dif > 0) {
                curB = curB.next;
                dif--;
            }
        }
        //当前节点不为空，并且两个节点不相等时，继续向后遍历
        while (curA != curB && curA != null && curB != null) {
            curA = curA.next;
            curB = curB.next;
        }
        //返回相同的节点
        return curA;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution37 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //记录A链表的长度
        int lenA = 0;
        //记录B链表的长度
        int lenB = 0;
        //curA指向A链表的头节点
        ListNode curA = headA;
        //curB指向B链表的头节点
        ListNode curB = headB;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        //指针重写指回两个链表的头节点
        curA = headA;
        curB = headB;
        //求两个链表长度之差
        int dif = lenA - lenB;
        //如果差大于0
        if (dif > 0) {
            //当差大于0时，A链表向后指向，直到dif等于0
            while (dif > 0) {
                curA = curA.next;
                dif--;
            }
        }
        //如果差小于等于0
        else {
            //差为相反数
            dif = -dif;
            //当差大于0时，B链表向后指向，直到dif等于0
            while (dif > 0) {
                curB = curB.next;
                dif--;
            }
        }
        //当指向A链表的指针不等于指向B链表的指针时，两个指针向后遍历
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}