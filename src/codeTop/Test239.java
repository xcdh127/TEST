package codeTop;

import java.util.Deque;
import java.util.LinkedList;

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
        //存放最大的值
        Deque<Integer> queue = new LinkedList<>();
        //存放结果
        int[] res = new int[n - k + 1];
        //滑动窗口，i初始值为1-k，j初始值为0
        for (int i = 1 - k, j = 0; j < n; i++, j++) {
            //当队列不为空时，并且刚刚进入窗口的值大于队列末尾值（维持最大值队列）
            while (!queue.isEmpty() && nums[j] > queue.peekLast()) {
                queue.pollLast();
            }
            //将当前数字放进到最大值队列末尾
            queue.offerLast(nums[j]);
            //当i大于等于0时
            if (i >= 0) {
                //当i大于0时，并且队列首部元素等于刚刚弹出队列的元素时
                //将队列首部元素弹出，处理刚刚滑出窗口的数字
                if (i > 0 && nums[i - 1] == queue.peekFirst()) {
                    queue.pollFirst();
                }
                //将队列的首部元素放进结果数组中
                res[i] = queue.peekFirst();
            }
        }
        //返回结果数组
        return res;
    }
}
