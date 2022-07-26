package codeTop;

import java.util.PriorityQueue;

/*输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
示例 1：
输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：
输入：arr = [0,1,2,1], k = 1
输出：[0]
限制：
0 <= k <= arr.length <= 10000
0 <= arr[i]<= 10000
*/
public class TestMianShi40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int n = arr.length;
        //见到最小值->想到最大堆
        //优先队列默认是最小堆，当最大堆传进蓝布塔表达式 b-a
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        //遍历数组
        for (int num : arr) {
            //当最大堆的大小小于k时，或者最大堆不为空，并且最大堆的堆顶元素大于等于当前数字num
            if (maxHeap.size() < k || !maxHeap.isEmpty() && maxHeap.peek() >= num) {
                //当最大堆的大小等于k时，弹出堆顶元素
                if (maxHeap.size() == k) {
                    maxHeap.poll();
                }
                //将当前这个数字添加到最大堆中
                maxHeap.offer(num);
            }
        }
        //结果数组
        int[] res=new int[k];
        int index=0;
        //将最大堆中的数字放进结果数组中
       while (!maxHeap.isEmpty()){
           res[index++]=maxHeap.poll();
       }
       //返回结果
       return res;
    }
}
class Solution14 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->(b-a));
        for (int num :arr) {
            if (queue.size()<k || !queue.isEmpty() && queue.peek()>num){
                if (queue.size()==k){
                    queue.poll();
                }
                queue.offer(num);
            }
        }
        int[] res=new int[queue.size()];
        int index=0;
        for (int num :queue) {
            res[index++]=num;
        }
        return res;
    }
}