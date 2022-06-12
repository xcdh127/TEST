package Leetcode;

import java.util.Arrays;

/*给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 */
public class Test42 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        //两种最大情况：
        //（1）三个正数
        //（2）两个负数一个正数
        return Math.max(nums[n-1]*nums[n-2]*nums[n-3],nums[0]*nums[1]*nums[n-1]);
    }
}
