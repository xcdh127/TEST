package codetophuawei;

/*给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个下标。
示例 1：
输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
示例 2：
输入：nums = [3,2,1,0,4]
输出：false
解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
提示：
1 <= nums.length <= 3 * 104
0 <= nums[i] <= 105
*/
public class Test55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxPos = 0;
        //当前位置没有到达跳到当前能跳到的最远距离时，继续向后跳跃
        for (int i = 0; i <= maxPos; i++) {
            //更新最远跳到的距离
            maxPos = Math.max(maxPos, i + nums[i]);
            //最大位置大于等于数组的最后位置时，返回true
            if (maxPos >= n - 1) {
                return true;
            }
        }
        //到不了数组的最后位置，返回flase
        return false;
    }
}

class Solution86 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxPos = 0;
        for (int i = 0; i <= maxPos; i++) {
            maxPos = Math.max(i + nums[i], maxPos);
            if (maxPos >= n - 1) {
                return true;
            }
        }
        return false;
    }
}