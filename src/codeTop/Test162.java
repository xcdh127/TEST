package codeTop;
/*峰值元素是指其值严格大于左右相邻值的元素。
给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
你可以假设nums[-1] = nums[n] = -∞ 。
你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
示例 1：
输入：nums = [1,2,3,1]
输出：2
解释：3 是峰值元素，你的函数应该返回其索引 2。
示例2：
输入：nums = [1,2,1,3,5,6,4]
输出：1 或 5
解释：你的函数可以返回索引 1，其峰值元素为 2；
   或者返回索引 5， 其峰值元素为 6。
提示：
1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
对于所有有效的 i 都有 nums[i] != nums[i + 1]
*/
public class Test162 {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        //当数组的长度为1时，返回0
        if (n==1){
            return 0;
        }
        //当数组长度大于1时
        if (n>1){
            //当数组第一位置的元素等于数组第二位置上的元素时，返回下标0
            if (nums[0]>nums[1]){
                return 0;
            }
            //当数组最后一位置上的元素等于数组倒数第二位置上的元素时，返回数组最后一位置的下标
            if (nums[n-1]>nums[n-2]){
                return n-1;
            }
        }
        //找数组中，当前位置大于前后两个位置的数字，或者当前位置小于前后两个位置的数字
        for (int i = 1; i <n-1 ; i++) {
            if ((nums[i]>nums[i-1] && nums[i]>nums[i+1]) || (nums[i]<nums[i-1] && nums[i]<nums[i+1])){
                return i;
            }
        }
        //没有找到，返回-1
        return -1;
    }
}
