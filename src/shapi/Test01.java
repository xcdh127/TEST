package shapi;


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
public class Test01 {
    public static void main(String[] args) {

    }


    public static int mergeTwoLists(ListNode list1, ListNode list2,int startIndex,int endIndex) {
        //哨兵
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        //当list1与list2都不为空时
        while(list1!=null && list2!=null){
            //list1链表的当前值小于list2链表的当前值时，将list1链表当前节点
            //放到哨兵节点的后面
            if(list1.val<list2.val){
                cur.next=list1;
                list1=list1.next;
            }
            //list2链表的当前值小于list1链表的当前值时，将list2链表当前节点
            //放到哨兵节点的后面
            else{
                cur.next=list2;
                list2=list2.next;
            }
            cur=cur.next;
        }
        //list1不为空就将List1链表放到哨兵节点的后面
        if(list1!=null){
            cur.next=list1;
        }
        //list2不为空就将List2链表放到哨兵节点的后面
        if(list2!=null){
            cur.next=list2;
        }
//        return dummy.next;
        int sum=0;
        int index=0;
        ListNode newCur=dummy;
        while(cur!=null){
            newCur=newCur.next;
            index++;
            if(index>=startIndex && index<=endIndex){
                sum+=newCur.val;
            }
        }
        return sum;
    }
}
