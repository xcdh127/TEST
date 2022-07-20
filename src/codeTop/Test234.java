package codeTop;

import java.util.ArrayList;
import java.util.List;

/*给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
示例 1：
输入：head = [1,2,2,1]
输出：true
示例 2：
输入：head = [1,2]
输出：false
提示：
链表中节点数目在范围[1, 105] 内
0 <= Node.val <= 9
进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
*/
public class Test234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> res=new ArrayList<>();
        //将链表中的数字存到数组中
        while (head!=null){
            res.add(head.val);
            head=head.next;
        }
        //转数组
        int[] arr=res.stream().mapToInt(i->i).toArray();
        //返回判断结果
        return isHuiWen(arr);
    }
    //判断数组是否为回文数组
    public boolean isHuiWen(int[] arr){
        int n=arr.length;
        int start=0;
        int end=n-1;
        while (start<end){
            if (arr[start]!=arr[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
