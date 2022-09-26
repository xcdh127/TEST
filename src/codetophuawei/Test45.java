package codetophuawei;

/*给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
你的目标是使用最少的跳跃次数到达数组的最后一个位置。
假设你总是可以到达数组的最后一个位置。
示例 1:
输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
示例 2:
输入: nums = [2,3,0,1,4]
输出: 2
提示:
1 <= nums.length <= 104
0 <= nums[i] <= 1000
*/
public class Test45 {
    public int jump(int[] nums) {
        int n = nums.length;
        //可以跳到的最远距离
        int maxPos = 0;
        //记录跳跃的步数
        int count = 0;
        //记录当前最远距离
        int end = 0;
        for (int i = 0; i < n - 1; i++) {
            //更新能够跳跃的最远距离
            maxPos = Math.max(maxPos, i + nums[i]);
            //当到达最远距离的时候，更新最远距离为maxPos
            if (end == i) {
                end = maxPos;
                //开启一次跳跃
                count++;
            }
        }
        //返回跳跃的次数
        return count;
    }
}


class Solution95 {
    public int jump(int[] nums) {
        int n = nums.length;
        //统计步数
        int count = 0;
        //记录最远距离
        int maxPos = 0;
        //记录当前最远位置
        int end = 0;
        for (int i = 0; i < n - 1; i++) {
            //更新最远距离
            maxPos = Math.max(maxPos, i + nums[i]);
            //当前位置就是此时能够到达的最远距离
            if (end == i) {
                end = maxPos;
                count++;
            }
        }
        //返回最少跳跃次数
        return count;
    }
}