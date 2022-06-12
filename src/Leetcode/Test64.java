package Leetcode;

import java.util.Arrays;

/*给你一个数字数组 arr 。
如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
*/
public class Test64 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        //将数组排序
        Arrays.sort(arr);
        int n=arr.length;
        //比较相邻两个数字之差是不是相同的
        int diff=arr[1]-arr[0];
        for (int i = 2; i < n; i++) {
            //如果有一个差值不是diff就不是等差数列
            if (diff!=arr[i]-arr[i-1]){
                return false;
            }
        }
        //两两之差都是diff说明此数组就是等差数列
        return true;
    }
}
