package codeTop;
/*给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意，必须在不复制数组的情况下原地对数组进行操作。
示例 1:
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
示例 2:
输入: nums = [0]
输出: [0]
提示:
1 <= nums.length <= 104
-231<= nums[i] <= 231- 1
进阶：你能尽量减少完成的操作次数吗？
*/
public class Test283 {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        //初始值指向数组的初始位置
        int left=0;
        //当数组的right位置指向的值不等于0时，继续向后遍历数组
        for (int right = 0; right < n; right++) {
            if (nums[right]!=0){
                swap(nums,left,right);
                left++;
            }
        }
    }
    //交换数组中两个位置上的数字
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
