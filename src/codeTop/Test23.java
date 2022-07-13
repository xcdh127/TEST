package codeTop;
/*给你一个链表数组，每个链表都已经按升序排列。
请你将所有链表合并到一个升序链表中，返回合并后的链表。
示例 1：
输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
示例 2：
输入：lists = []
输出：[]
示例 3：
输入：lists = [[]]
输出：[]
提示：
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4
*/
public class Test23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        //如果连标数组为空，直接返回null
        if (n==0){
            return null;
        }
        return splitAndMerge(lists,0,n-1);
    }

    public ListNode splitAndMerge(ListNode[] lists,int l,int r){
        //获取链表的长度
        int n=lists.length;
        if (l>=r){
            return lists[l];
        }
        //求出中点
        int m=l+(r-l)/2;
        //将链表拆分成两部分，直到只剩下一个节点为止，(l,m)  (m+1,r) 两部分
        ListNode head1=splitAndMerge(lists,l,m);
        ListNode head2=splitAndMerge(lists,m+1,r);
        //合并链表
        return merge(head1,head2);
    }
   //按照大小顺序对链表进行排序
    public ListNode merge(ListNode head1,ListNode head2){
        //新建头节点
        ListNode dummy=new ListNode(0);
        //当前节点指向头节点
        ListNode cur=dummy;
        while (head1!=null && head2!=null){
            if (head1.val<=head2.val){
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
        if (head2!=null){
            cur.next=head2;
        }
        return dummy.next;
    }
}
