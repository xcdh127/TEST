package CodeDream;

import org.omg.CORBA.INTERNAL;

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
        Map<Integer, Integer> map = new HashMap<>();
        //map记录数字即数字出现的次数
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //最小堆，根据键值对的值排序，也就是出现次数
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
        //向最小堆中添加键值对
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //当最小堆的大小小于k，或者最小堆堆顶键值对的值小于当前键值对的值时
            if (minHeap.size() < k || minHeap.peek().getValue() < entry.getValue()) {
                //最小堆的大小等于k时
                if (minHeap.size() == k) {
                    minHeap.poll();
                }
                //最小堆放进这个键值对
                minHeap.offer(entry);
            }
        }
        int[] res = new int[k];
        int index = 0;
        //遍历键值对放进结果数组输出
        for (Map.Entry<Integer, Integer> entry : minHeap) {
            res[index++] = entry.getKey();
        }
        return res;
    }
}
