package CodeTop02;

/*整数数组 nums 按升序排列，数组中的值 互不相同 。
在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
（下标 从 0 开始 计数）。
例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，
则返回它的下标，否则返回 -1 。
你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
示例 1：
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
示例 2：
输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
示例 3：
输入：nums = [1], target = 0
输出：-1
提示：
1 <= nums.length <= 5000
-104 <= nums[i] <= 104
nums 中的每个值都 独一无二
题目数据保证 nums 在预先未知的某个下标上进行了旋转
-104 <= target <= 104
*/
public class Test33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int m = i + (j - i) / 2;
            if (nums[m] == target) {
                return m;
            }
            //目标位于数组的前半部分
            if (nums[m] >= nums[0]) {
                //中点大于目标值，并且数组0位置的数字小于等于target时
                if (nums[m] > target && nums[0] <= target) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            }
            //目标位于数组的后半部分
            else {
                if (nums[m] < target && target <= nums[n - 1]) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }
        }
        return -1;
    }
}

class Solution52 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        //双指针，一个指向数组的开头，一个指向数组的末尾
        int i = 0;
        int j = n - 1;
        //当i小于j时
        while (i < j) {
            //求出中点位置
            int m = i + (j - i) / 2;
            //中点位置就是目标值时，返回m
            if (nums[m] == target) {
                return m;
            }
            //目标值位于数组的前半部分
            if (nums[m] >= nums[0]) {
                //当目标值位于0和m之间时，搜索数组的前半部分
                if (nums[m] < target && nums[0] <= target) {
                    j = m - 1;
                }
                //当目标值位于中点之后时，搜索数组的后半部分
                else {
                    i = m + 1;
                }
            }
            //目标值位于数组的后半部分
            else {
                if (nums[m] < target && target <= nums[n - 1]) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }
        }
        //没有找到返回-1
        return -1;
    }
}