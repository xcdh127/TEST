package Leetcode;
/*给你一个整数数组 nums （下标从 0 开始）。每一次操作中，你可以选择数组中一个元素，并将它增加 1 。
比方说，如果 nums = [1,2,3] ，你可以选择增加 nums[1] 得到 nums = [1,3,3] 。
请你返回使 nums 严格递增 的 最少 操作次数。
我们称数组 nums 是 严格递增的 ，当它满足对于所有的 0 <= i < nums.length - 1 
都有 nums[i] < nums[i+1] 。一个长度为 1 的数组是严格递增的一种特殊情况。
*/
/*输入：nums = [1,1,1]
输出：3
解释：你可以进行如下操作：
1) 增加 nums[2] ，数组变为 [1,1,2] 。
2) 增加 nums[1] ，数组变为 [1,2,2] 。
3) 增加 nums[2] ，数组变为 [1,2,3] 。

*/
public class Test217 {
    public int minOperations(int[] nums) {
        int n=nums.length;
        //数组长度为1时，直接返回0
        if (n==1)return 0;
        //记录修改次数
        int count=0;
        for (int i = 1; i <n; i++) {
            //后面数字小于等于前面数字时
            //次数累加差+1，并将后面数字加上差+1，直到遍历完数组
            if (nums[i]-nums[i-1]<=0){
                count+=nums[i-1]-nums[i]+1;
                nums[i]+=nums[i-1]-nums[i]+1;
            }
        }
        //返回计数结果
        return count;
    }
}
