package CodeTop02;

import java.util.PriorityQueue;

/*给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
示例 1:
输入: [3,2,1,5,6,4], k = 2
输出: 5
示例 2:
输入: [3,2,3,1,2,4,5,5,6], k = 4
输出: 4
提示：
1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
*/
public class Test215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (queue.size() < k || queue.peek() < nums[i]) {
                if (queue.size() == k) {
                    queue.poll();
                }
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
}
