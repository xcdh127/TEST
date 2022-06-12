package Leetcode;
/*给你一个下标从 0 开始的整数数组 nums ，请你找到 最左边 的中间位置 
middleIndex （也就是所有可能中间位置下标最小的一个）。
中间位置 middleIndex 是满足 nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] +
nums[middleIndex+2] + ... + nums[nums.length-1] 的数组下标。
如果 middleIndex == 0 ，左边部分的和定义为 0 。类似的，如果 middleIndex == nums.length - 1 ，右边部分的和定义为 0 。
请你返回满足上述条件 最左边 的 middleIndex ，如果不存在这样的中间位置，请你返回 -1 。
*/
public class Test182 {
    public int findMiddleIndex(int[] nums) {
        int n=nums.length;
        //记录前缀和
        int[] pre=new int[n+1];
        pre[0]=0;
        for (int i = 1; i <=n ; i++) {
            pre[i]=pre[i-1]+nums[i-1];
        }
        for (int i = 0; i < n; i++) {
            //数组左边的和等于累加到当前数字之前的前缀和
            int leftSum=pre[i];
            //当前数组的右边和等于数组总和-此时前缀和
            int rightSum=pre[n]-pre[i+1];
            //如果此时两个数字相等，就返回此时下标
            if (leftSum==rightSum){
                return i;
            }
        }
        //如果数组中没有这样的中点坐标，直接返回-1
        return -1;
    }
}
