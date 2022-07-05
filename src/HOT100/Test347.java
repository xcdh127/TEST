package HOT100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:
输入: nums = [1], k = 1
输出: [1]
提示：
1 <= nums.length <= 105
k 的取值范围是 [1, 数组中不相同的元素的个数]
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
*/
public class Test347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num :nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //最小堆
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap=new PriorityQueue<>();
        //向最小堆中添加map键值对
        for (Map.Entry<Integer, Integer> entry :map.entrySet()) {
            //当最小堆的大小小于k，或者最小堆堆顶的值小于等于当前键值对的值
            if (minHeap.size()<k || entry.getValue()>=minHeap.peek().getKey()){
                //当前堆的容量大于等于k时，将最小堆的堆顶元素弹出
                if (minHeap.size()>=k){
                    minHeap.poll();
                }
                //向最小堆中添加entry键值对
                minHeap.offer(entry);
            }
        }
        //返回结果
        return minHeap.stream().mapToInt(i->i.getKey()).toArray();
    }
}

/*class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap=new PriorityQueue<>((a,b)->(a.getValue()-b.getValue()));
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(minHeap.size()<k || minHeap.peek().getValue()<entry.getValue()){
                if(minHeap.size()==k){
                    minHeap.poll();
                }
                minHeap.offer(entry);
            }
        }
        int[] arr=new int[k];
        int index=0;
        for(Map.Entry<Integer,Integer> entry:minHeap){
            arr[index++]=entry.getKey();
        }
        return arr;
    }
}*/
