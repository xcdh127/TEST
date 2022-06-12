package Leetcode;

import java.util.Arrays;

/*给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，
使 (nums[i]-1)*(nums[j]-1) 取得最大值。
请你计算并返回该式的最大值。
*/
public class Test51 {
    public int maxProduct(int[] nums) {
        //对数组进行排序
        Arrays.sort(nums);
        int n=nums.length;
        //由于数组中的数字全是正数，所以排序后，最大乘积位于数组的最后两个数字
        return (nums[n-1]-1)*(nums[n-2]-1);
    }
}
