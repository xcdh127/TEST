package Leetcode;
/*给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。
如果 nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。
源数组中可能存在 重复项 。
注意：我们称数组 A 在轮转 x 个位置后得到长度相同的数组 B ，
当它们满足 A[i] == B[(i+x) % A.length] ，其中 % 为取余运算。
*/

import java.util.Arrays;

/*输入：nums = [3,4,5,1,2]
输出：true
解释：[1,2,3,4,5] 为有序的源数组。
可以轮转 x = 3 个位置，使新数组从值为 3 的元素开始：[3,4,5,1,2] 。
*/
public class Test248 {
    public static void main(String[] args) {
        int[] arr=new int[]{6,10,6};
        System.out.println(check(arr));
    }
    public static boolean check(int[] nums) {
       int n=nums.length;
       //经过轮转后的数组是单调递增的
        //没有经过轮转的数组首位大于尾部
       boolean isCount=nums[0]>=nums[n-1];
        for (int i = 1; i < n; i++) {
            //后一位小于前一位时，此时根据是否轮转过
            //判断数组中的数字是否合法
            if (nums[i]<nums[i-1]){
                //如果没有轮转过，数组又不是递增排序的，此时就标记为轮转
                if (isCount){
                    isCount=false;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}

/*class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        //有经过轮转
        boolean isCount = nums[0] >= nums[n-1];

        for(int i=1;i<n;i++){

            if(nums[i]<nums[i-1]){
                if(isCount){
                    isCount = false;
                }else{
                    return false;
                }
            }

        }
        return true;
    }
}*/

