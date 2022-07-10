package codeTop;

import java.util.PriorityQueue;

/*给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
示例 1:
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
提示：
1 <= k <= nums.length <= 104
-104 <= nums[i] <= 104
*/
public class Test215 {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        //最小堆
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for (int num :nums) {
            //当最小堆的大小小于k，或者最小堆的堆顶元素小于当前数字时，将当前元素放进最小堆中
            if (minHeap.size()<k || minHeap.peek()<num){
                //最小堆满时
                if (minHeap.size()==k){
                    //将最小堆的堆顶元素弹出
                    minHeap.poll();
                }
                //放入当前数字
                minHeap.offer(num);
            }
        }
        //弹出最小堆的堆顶元素
        return minHeap.peek();
    }
}
