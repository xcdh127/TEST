package codeTop;
/*给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回[-1, -1]。
你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例2：
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：
输入：nums = [], target = 0
输出：[-1,-1]
提示：
0 <= nums.length <= 105
-109<= nums[i]<= 109
nums是一个非递减数组
-109<= target<= 109
*/
public class Test34 {
    public int[] searchRange(int[] nums, int target) {
        //获取target-1的右边界
        int left=getRight(nums,target-1);
        //获取target的右边界
        int right=getRight(nums,target);
        //当left==right时，说明此数字没有出现在数组中
        if (left==right){
            return new int[]{-1,-1};
        }
        //返回target数字在数组中出现的区间
        return new int[]{left,right-1};
    }

    //获取数组中target的右边界
    public int getRight(int[] nums,int target){
        int n=nums.length;
        int i=0;
        int j=n-1;
        //当i小于等于j时，继续二分查找有边界
        while (i<=j){
            int m=i+(j-i)/2;
            //当中点值小于等于target时，搜索数组的右半部分
            if (nums[m]<=target){
                i=m+1;
            }
            //当中点值大于target时，搜索数组的左半部分
            else {
                j=m-1;
            }
        }
        //返回i值
        return i;
    }
}
