package HOT100;
/*给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意 ，必须在不复制数组的情况下原地对数组进行操作。
示例 1:
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
示例 2:
输入: nums = [0]
输出: [0]
提示:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
进阶：你能尽量减少完成的操作次数吗？
*/
public class Test283 {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=0;
        while (right<n){
            //当右指针指向的数字不为0时，交换两个数字的位置，将0向后交换
            if (nums[right]!=0){
                swap(nums,right,left);
                //将左指针向左移动
                left++;
            }
            //将右指针向右移动，直到遍历完数组
            right++;
        }
    }
    public void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
/*
class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=0;
        // 0 1 0 3 12
        while(right<n){
            if(nums[right]!=0){
                swap(nums,right,left);
                left++;
            }
            right++;
        }
    }
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
*/
