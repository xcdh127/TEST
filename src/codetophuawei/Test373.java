package codetophuawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*给定两个以 升序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
示例 1:
输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
输出: [1,2],[1,4],[1,6]
解释: 返回序列中的前 3 对数：
     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
示例 2:
输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
输出: [1,1],[1,1]
解释: 返回序列中的前 2 对数：
     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
示例 3:
输入: nums1 = [1,2], nums2 = [3], k = 3
输出: [1,3],[2,3]
解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
提示:
1 <= nums1.length, nums2.length <= 105
-109 <= nums1[i], nums2[i] <= 109
nums1 和 nums2 均为升序排列
1 <= k <= 1000
*/
public class Test373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //见到最小问题，使用最大堆
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++) {
            for (int j = 0; j < Math.min(n, k); j++) {
                //当最大堆的大小小于k时，或者当前两个数字之和小于堆顶元素之和
                if (maxHeap.size() < k || nums1[i] + nums2[j] <= maxHeap.peek()[0] + maxHeap.peek()[1]) {
                    //如果当前最大堆的大小等于k时
                    if (maxHeap.size() == k) {
                        //将最大堆的堆顶元素弹出
                        maxHeap.poll();
                    }
                    //如果此时最大堆的容量没有满，就将数字组合放进最大堆中
                    maxHeap.offer(new int[]{nums1[i], nums2[j]});
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        //遍历最大堆，向最大堆汇总添加元素
        for (int[] arr : maxHeap) {
            res.add(Arrays.asList(arr[0], arr[1]));
        }
        return res;
    }
}


class Solution105 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //最大堆传入比较器(i2-i1)

        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((i1, i2) -> (i2[0] + i2[1] - i1[0] - i1[1]));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {

            for (int j = 0; j < Math.min(nums2.length, k); j++) {

                if (maxHeap.size() < k || nums1[i] + nums2[j] <= maxHeap.peek()[0] + maxHeap.peek()[1]) {

                    if (maxHeap.size() == k) {
                        maxHeap.poll();

                    }
                    maxHeap.offer(new int[]{nums1[i], nums2[j]});
                }
            }

        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int[] num : maxHeap) {
            res.add(Arrays.asList(num[0], num[1]));
        }
        return res;
    }
}