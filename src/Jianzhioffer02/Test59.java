package Jianzhioffer02;

import java.util.Deque;
import java.util.LinkedList;

/*给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
示例:
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:
  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
提示：
你可以假设 k 总是有效的，在输入数组 不为空 的情况下，1 ≤ k ≤ nums.length。
*/
public class Test59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList();
        int n = nums.length;
        //结果数组
        int[] res = new int[n - k + 1];
        //i从1-k开始
        for (int i = 1 - k, j = 0; j < n; i++, j++) {
            //双端队列不为空，并且最后一个元素小于当前位置的数字时，删除双端队列的最后一个数字
            while (!deque.isEmpty() && deque.getLast() < nums[j]) {
                deque.removeLast();
            }
            //将当前数字添加到双端队列的末尾
            deque.addLast(nums[j]);
            //i大于等于0时
            if (i >= 0) {
                //i大于0时，双端队列队首元素等于刚刚移出滑动窗口的数字时
                if (i > 0 && deque.getFirst() == nums[i - 1]) {
                    deque.removeFirst();
                }
                //当前数组结果放置双端队列的队首元素
                res[i] = deque.getFirst();
            }
        }
        //返回结果
        return res;
    }
}
