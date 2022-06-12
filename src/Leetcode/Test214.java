package Leetcode;
/*在数组 A 和数组 B 中，对于第一个满足 A[i] != B[i] 的索引 i ，当 A[i] > B[i] 时，数组 A 大于数组 B。
例如，对于索引从 0 开始的数组：
[1,3,2,4] > [1,2,2,4] ，因为在索引 1 上， 3 > 2。
[1,4,4,4] < [2,1,1,1] ，因为在索引 0 上， 1 < 2。
一个数组的子数组是原数组上的一个连续子序列。
给定一个包含不同整数的整数类型数组 nums ，返回 nums 中长度为 k 的最大子数组。
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*输入: nums = [1,4,5,2,3], k = 3
输出: [5,2,3]
解释: 长度为 3 的子数组有： [1,4,5]、 [4,5,2] 和 [5,2,3]。
在这些数组中， [5,2,3] 是最大的。
*/
public class Test214 {
    public static void main(String[] args) {
        int[] arr=new int[]{1,4,5,2,3};
        System.out.println(largestSubarray(arr,3));
    }
    public static int[] largestSubarray(int[] nums, int k) {
        int n=nums.length;
        int[] arr=new int[k];
        int maxVal=Integer.MIN_VALUE;
        int maxIdx=-1;
        //在数组中寻找能够构成长度为k的数组的最大的下标
        for (int i = 0; i <= n - k; i++) {
            if (maxVal<nums[i]){
                maxVal=nums[i];
                maxIdx=i;
            }
        }
        //将原数组中的arr，从数组中拷贝到新数组arr中
        System.arraycopy(nums,maxIdx,arr,0,k);
        return arr;
/*        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list;
        int n=nums.length;
        for (int i = 0; i <=n-k ; i++) {
            list=new ArrayList<>();
            for (int j = i; j <i+k ; j++) {
                list.add(nums[j]);
            }
            res.add(list);
        }

        Collections.sort(res,(a,b)->(compare(a,b)));
        return res.get(0).stream().mapToInt(i->i).toArray();*/
    }
/*    public static int compare(List<Integer> list1,List<Integer> list2){
        int index=0;
        int n=list1.size();
        while (index<n && list1.get(index)==list2.get(index)){
            index++;
        }
        if (index==n){
            return 0;
        }
        else {
            return list2.get(index)-list1.get(index);
        }
    }*/
}

/*class Solution {
    public int[] largestSubarray(int[] nums, int k) {
        int[] ans = new int[k];
        int maxIdx = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        System.arraycopy(nums, maxIdx, ans, 0, maxIdx + k - maxIdx);
        return ans;
    }
}
*/