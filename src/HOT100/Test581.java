package HOT100;

import java.util.Arrays;

/*给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
请你找出符合题意的 最短 子数组，并输出它的长度。
示例 1：
输入：nums = [2,6,4,8,10,9,15]
2,4,6,8,9,10,15
输出：5
解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
示例 2：
输入：nums = [1,2,3,4]
输出：0
示例 3：
输入：nums = [1]
输出：0
提示：
1 <= nums.length <= 104
-105 <= nums[i] <= 105
*/
public class Test581 {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int[] arr= Arrays.copyOf(nums,n);
        Arrays.sort(arr);
        int i=0;
        int j=n-1;
        //将指针i指向数组的开头，当两个数组首部相等时，一直向数组的后方指向
        while (i<n && arr[i]==nums[i]){
            i++;
        }
        //当i==n时，返回0，此时数组本身就是升序排序的
        if (i==n){
            return 0;
        }
        //将指针j指向数组的末尾，当两个数组尾部相等时，一直向数组的前方指向
        while (j>=0 && arr[j]==nums[j]){
            j--;
        }
        //返回两个指针直线的距离
        return j-i+1;
    }
}
/*class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        //将数组进行升序排序
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
        int i=0;
        int j=n-1;
        while (i<n && copy[i]==nums[i]) {
            i++;
        }
        if (i==n){
            return 0;
        }
        while (j>=0 && copy[j]==nums[j]){
            j--;
        }
        return j-i+1;
    }
}*/
