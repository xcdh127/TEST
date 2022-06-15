package JianZHiOffer;

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
你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
*/
public class Test64 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n==0) {
            return new int[0];
        }
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[n - k + 1];
        int i = 1 - k;
        for (int j = 0; j < n; i++, j++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[j]) {
                queue.removeLast();
            }
            queue.addLast(nums[j]);
            if (i >= 0) {
                if (i > 0 && nums[i - 1] == queue.peekFirst()) {
                    queue.removeFirst();
                }
                res[i] = queue.getFirst();
            }
        }
        return res;
    }
}
