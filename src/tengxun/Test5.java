package tengxun;
import java.util.*;
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }
}
public class Test5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line=sc.nextLine().split(" ");
        int n=Integer.parseInt(line[0]);
        int m=Integer.parseInt(line[1]);
        String[] str=sc.nextLine().split(" ");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(str[i]);
        }
        System.out.println(m);
    }

    public ListNode solve (ListNode[] a) {
        // write code here
        ArrayList<Integer> list=new ArrayList<>();
        for(ListNode listNode:a){
            ListNode node=listNode;
            while(node!=null && !list.contains(node.val)){
                list.add(node.val);
                node=node.next;
            }
        }
        List<String> res=getAllList(list);
        Collections.sort(res);
        String[] result=res.get(0).split("");
        ListNode head=new ListNode(Integer.parseInt(result[0]));
        ListNode node=head;
        for(int i=1;i<result.length;i++){
            node.next=new ListNode(Integer.parseInt(result[i]));
            node=node.next;
        }

        return head;
    }
    public List<String> getAllList(ArrayList<Integer> list){
        List<String> res=new ArrayList<>();
        res.add(listToString(list));
        for(int i=0;i<list.size()-1;i++){
            int val=list.remove(0);
            list.add(val);
            res.add(listToString(list));
        }
        return res;
    }
    public String listToString(ArrayList<Integer> list){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
