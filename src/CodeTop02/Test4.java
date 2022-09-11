package CodeTop02;

import java.util.PriorityQueue;

/*给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
算法的时间复杂度应该为 O(log (m+n)) 。
示例 1：
输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：
输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
提示：
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/
public class Test4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m + n];
        int index = 0;
        for (int num : nums1) {
            arr[index++] = num;
        }
        for (int num : nums2) {
            arr[index++] = num;
        }
        for (int i = 0; i < m + n; i++) {
            if (minHeap.size() == maxHeap.size()) {
                maxHeap.offer(arr[i]);
                minHeap.offer(maxHeap.poll());
            } else {
                minHeap.offer(arr[i]);
                maxHeap.offer(minHeap.poll());
            }
        }
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return minHeap.peek() / 1.0;
        }
    }
}
