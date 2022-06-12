package Leetcode;

import java.util.Arrays;

/*如果数组是单调递增或单调递减的，那么它是 单调 的。
如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。
如果对于所有 i <= j，nums[i]> = nums[j]，那么数组 nums 是单调递减的。
当给定的数组 nums 是单调数组时返回 true，否则返回 false。
*/
public class Test196 {
    public boolean isMonotonic(int[] nums) {
        int n=nums.length;
        //首先拷贝一份元数组
        int[] copyOf = Arrays.copyOf(nums, n);
        //将原始数组排序
        Arrays.sort(nums);
        //判断原始数组是否是正序排序的数组
        boolean flag1=isTrue1(nums,copyOf);
        //判断原始数组是否是逆序排序的数组
        boolean flag2=isTrue2(nums,copyOf);
        return flag1 || flag2;
    }
    //将数组与正序排序的数组依次比较，如果值全部相等就说明原始的数组是正序排序的
    public boolean isTrue1(int[] arr1,int[] arr2){
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    //将数组与按照倒序的与原始数组进行比较，如果此时数字全部相同就说明此时数组是按照逆序排序的
    public boolean isTrue2(int[] arr1,int[] arr2){
        int index=0;
        for (int i = arr1.length-1; i >=0; i--) {
            if (arr1[i]!=arr2[index++]){
                return false;
            }
        }
        return true;
    }
}
