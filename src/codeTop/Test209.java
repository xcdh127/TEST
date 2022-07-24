package codeTop;
/*给定一个含有n个正整数的数组和一个正整数 target 。
找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
示例 1：
输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组[4,3]是该条件下的长度最小的子数组。
示例 2：
输入：target = 4, nums = [1,4,4]
输出：1
示例 3：
输入：target = 11, nums = [1,1,1,1,1,1,1,1]
输出：0
提示：
1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 105
*/
public class Test209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        //记录滑动窗口中的数字和
        int sum=0;
        //记录和为target的最小长度
        int minLen=Integer.MAX_VALUE;
        //滑动窗口的左端点
        int i=0;
        //滑动窗口的右端点
        for (int j = 0; j < n; j++) {
            //当前数字进入窗口，累加和添加当前数字
            sum+=nums[j];
            //当窗口内的和大于的等于target时
            while (sum>=target){
                //当前和为target的子数组的长度小于当前最小窗口长度时
                if (minLen>j-i+1){
                    //当前最小窗口的长度赋值给minLen
                    minLen=j-i+1;
                }
                //数字滑出窗口
                sum-=nums[i];
                //缩小当前窗口
                i++;
            }
        }
        //返回和为target的窗口大小
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}
/*class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int i=0;
        int minLen=Integer.MAX_VALUE;
        int sum=0;
        for(int j=0;j<n;j++){
            sum+=nums[j];
            while(sum>=target){
                minLen=Math.min(minLen,j-i+1);
                sum-=nums[i];
                i++;
            }
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}*/