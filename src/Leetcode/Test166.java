package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

/*给你一个整数数组 arr ，数组中的每个整数 互不相同 。
另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。
请你以 任意顺序 连接 pieces 中的数组以形成 arr 。
但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
*/
/*输入：arr = [15,88], pieces = [[88],[15]]
输出：true
解释：依次连接 [15] 和 [88]
输入：arr = [49,18,16], pieces = [[16,18,49]]
输出：false
解释：即便数字相符，也不能重新排列 pieces[0]

输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
输出：true
解释：依次连接 [91]、[4,64] 和 [78]

*/
public class Test166 {
    public static void main(String[] args) {
        int[] arr=new int[]{91,4,64,78};
        int[][] pieces=new int[][]{{78},{4,64},{91}};
        System.out.println(canFormArray(arr, pieces));
    }
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        //将数组pieces放进双端队列
        Deque<int[]> deque=new LinkedList<>();
        for (int[] piece :pieces) {
            deque.offer(piece);
        }
        //指针指向待形成数组
        int index=0;
        //拿到当前队列的大小
        int size=deque.size();
        //当队列不为空时
        while (!deque.isEmpty()){
            //如果队列不为空并且队头数组的首元素等于数组当前位置的值
            if (!deque.isEmpty() && deque.peek()[0]==arr[index]){
                //弹出当前数组
                int[] temp=deque.pollFirst();
                //更新此时队列的大小
                size=deque.size();
                //比对当前数组中的每一个元素与arr中是否一一对应
                for (int i = 0; i < temp.length; i++) {
                    //如有不对应就返回false
                    if (arr[index++]!=temp[i]){
                        return false;
                    }
                }
            }
            //否则将队头数字放到队尾
            else {
                deque.addLast(deque.pollFirst());
                //此处计数-1，目的是保证只遍历队列中的元素一遍
                size--;
                //遍历全部数组后没有与原数值index位置对应的数字
                if (size<0){
                    return false;
                }
            }
        }
        //全部的数字都能与原数组对应
        return true;
    }
}
