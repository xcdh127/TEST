package CodeDream;

/*给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
示例 1：
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
示例 2：
输入：height = [4,2,0,3,2,5]
输出：9
提示：
n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/
public class Test42 {
    public int trap(int[] height) {
        int n = height.length;
        //从左向右统计最大高度
        int[] left = new int[n];
        //从右向左统计最大高度
        int[] right = new int[n];
        //记录接雨水的最大值
        int res = 0;
        //记录左边最大值
        int maxLeft = height[0];
        for (int i = 0; i < n; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            left[i] = maxLeft;
        }
        //记录右边最大值
        int maxRight = height[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            maxRight = Math.max(height[i], maxRight);
            right[i] = maxRight;
        }
        //遍历数组，用左右两边的较小值-当前高度
        for (int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        //返回结果
        return res;
    }
}
