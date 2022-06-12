package Leetcode;

import java.util.Arrays;

/*给你一个整数数组 nums 和整数 k ，
返回最大和 sum ，满足存在 i < j 使得
nums[i] + nums[j] = sum 且 sum < k 。
如果没有满足此等式的 i,j 存在，则返回 -1 。
*/
public class Test56 {
    public int twoSumLessThanK(int[] nums, int k) {
        //记录结果
        int res=-1;
        //对数组进行排序
        Arrays.sort(nums);
        //双指针
        //定义i指向数组的开头
        int i=0;
        //定义j指向数组的末尾
        int j=nums.length-1;
        //当两个指针没有碰撞时
        while (i<j){
            //计算此时两个数字的和
            int sum=nums[i]+nums[j];
            //当前和大于等于k时，将指针j向前指向，使得两个数字的和变小
            if (sum>=k){
                j--;
            }
            //当前和小于k时，记录下最大值，并且将指针i向后指向胡获取更大的和
            else{
                res=Math.max(res,sum);
                i++;
            }
        }
        //返回结果
        return res;
    }
}
