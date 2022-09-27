package codetophuawei;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回 滑动窗口中的最大值 。
示例 1：
输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
示例 2：
输入：nums = [1], k = 1
输出：[1]
提示：
1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
*/
public class Test239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        //维系最大值的队列，从队尾放置，将队尾与要入队的数字进行比较，当数字大于队尾数字时，就将队尾数字弹出
        //直到相等将当前节点入队
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1 - k, j = 0; j < n; i++, j++) {
            while (!queue.isEmpty() && ((LinkedList<Integer>) queue).peekLast() < nums[j]) {
                queue.removeLast();
            }
            queue.offer(nums[j]);
            //当i大于等于0时
            if (i >= 0) {
                //当i大于0时，如果滑出窗口的数字等于队列的队首元素，将队首元素删除
                if (i > 0 && queue.peekFirst() == nums[i - 1]) {
                    queue.removeFirst();
                }
                //记录在i位置，当前队列中的最大值
                res[i] = queue.getFirst();
            }
        }
        //返回结果
        return res;
    }
}
