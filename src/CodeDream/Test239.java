package CodeDream;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数
组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
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
        //存放滑动窗口最大值结果
        int[] res = new int[n - k + 1];
        //双端队列
        Deque<Integer> deque = new LinkedList<>();
        //i从1-k开始滑动，j从0开始滑动
        for (int i = 1 - k, j = 0; j < n; i++, j++) {
            //当双端队列不为空或者双端队列的末尾元素小于当前j位置的数字时
            //双端队列删除队列末尾的元素
            while (!deque.isEmpty() && deque.getLast() < nums[j]) {
                deque.removeLast();
            }
            //向双端队列的末尾，添加当前j位置的数字
            deque.addLast(nums[j]);
            //如果i大于等于0
            if (i >= 0) {
                //当i大于0，并且i-1位置的数字等于双端队列队首的元素时，将队首的元素弹出
                if (i > 0 && nums[i - 1] == deque.getFirst()) {
                    deque.removeFirst();
                }
                //将i位置填充上队列首的元素
                res[i] = deque.getFirst();
            }
        }
        //返回结果
        return res;
    }
}
