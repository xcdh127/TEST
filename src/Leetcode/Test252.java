package Leetcode;
/*给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数 target 和 start ，
请你找出一个下标 i ，满足 nums[i] == target 且 abs(i - start) 最小化 。注意：abs(x) 表示 x 的绝对值。
返回 abs(i - start) 。
题目数据保证 target 存在于 nums 中。
*/
public class Test252 {
    public int getMinDistance(int[] nums, int target, int start) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i]==target){
                if (min>Math.abs(i-start)){
                    min=Math.abs(i-start);
                }
            }
        }
        return min;
    }
}
