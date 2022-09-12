package CodeTop02;

/*整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，
如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
给你一个整数数组 nums ，找出 nums 的下一个排列。
必须 原地 修改，只允许使用额外常数空间。
示例 1：
输入：nums = [1,2,3]
输出：[1,3,2]
示例 2：
输入：nums = [3,2,1]
输出：[1,2,3]
示例 3：
输入：nums = [1,1,5]
输出：[1,5,1]
*/
public class Test31 {
    public void nextPermutation(int[] nums) {
        //从后向前找第一个后面小于前面的数字
        int n = nums.length;
        int index = n - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }
        //如果能找到，从后向前找首个大于这个数字的数字
        if (index >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[index]) {
                j--;
            }
            //交换index位置和j位置上的数字
            swap(nums, index, j);
        }
        //反转index+1位置向后的数组
        reverse(nums, index + 1, n - 1);

    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

class Solution67 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = n - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }
        if (index >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[index]) {
                j--;
            }
            int temp = nums[index];
            nums[index] = nums[j];
            nums[j] = temp;
        }
        reverse(nums, index + 1);
    }

    public void reverse(int[] nums, int start) {
        int n = nums.length;
        int end = n - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
