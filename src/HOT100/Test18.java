package HOT100;
/*给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
请你找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回 [-1, -1]。
你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例 2：
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：
输入：nums = [], target = 0
输出：[-1,-1]
提示：
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums 是一个非递减数组
-109 <= target <= 109
*/
public class Test18 {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        //找目标值的前一个数字的右边界
        int right1=findRight(nums,target-1);
        //找目标数字的右边界
        int right2=findRight(nums,target);
        //如果两个数字的右边界值相等，就说明数组中不存在这个数字
        if (right1==right2){
            return new int[]{-1,-1};
        }
        //当两个右边界不相等，就返回数字在数组中出现的右边界
        return new int[]{right1,right2-1};
    }
    public int findRight(int[] nums,int target){
        int n=nums.length;
        int i=0;
        int j=n-1;
        while (i<=j){
            int m=i+(j-i)/2;
            //当中点位置的数字小于等于目标值时，搜索数组后半部分
            if (nums[m]<=target){
                i=m+1;
            }
            //当中点位置的数字大于目标值的时候，搜索数组的前半部分
            else {
                j=m-1;
            }
        }
        //返回数组右边界
        return i;
    }
}

/*class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=getRightIndex(nums,target-1);
        int right=getRightIndex(nums,target);
        if(left==right){
            return new int[]{-1,-1};
        }
        return new int[]{left,right-1};

    }

    public int getRightIndex(int[] nums,int target){
        int n=nums.length;
        int i=0;
        int j=n-1;
        while(i<=j){
            int m=i+(j-i)/2;
            if(nums[m]<=target){
                i=m+1;
            }
            else{
                j=m-1;
            }
        }
        return i;
    }
}*/
