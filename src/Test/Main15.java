package Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Main15 {
    public static void main(String[] args) throws IOException {

        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));//1 3 4 5 6352
        long start=System.currentTimeMillis();
//        Scanner sc=new Scanner(System.in);//1 3 4 5 5914
        String[] line1=sc.readLine().split(" ");
        String[] nums=sc.readLine().split(" ");
        int n=Integer.parseInt(line1[0]);
        int m=Integer.parseInt(line1[1]);
        ListNode node=toList(nums);
        ListNode res=deleteNode(node,m);
        while(res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
    //将数组转换成链表
    public static ListNode toList(String[] nums){
        //建立头结点
        ListNode head=new ListNode(Integer.parseInt(nums[0]));
        //定义一个节点指向头结点
        ListNode cur=head;
        //将数组顺次转换成链表
        for(int i=1;i<nums.length;i++){
            cur.next=new ListNode(Integer.parseInt(nums[i]));
            cur=cur.next;
        }
        //返回链表的头节点
        return head;
    }
    //删除第k个节点
    public static ListNode deleteNode(ListNode head,int k){
        ListNode cur=head;
        //遍历到第k个节点前一个节点停止，删除这个节点后面的节点
        for(int i=0;i<k-2;i++){
            cur=cur.next;
        }
        cur.next=cur.next.next;
        return head;
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}



