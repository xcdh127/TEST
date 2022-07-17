package codeTop;

/*给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
示例 1：
输入：nums = [1,2,0]
输出：3
示例 2：
输入：nums = [3,4,-1,1]
输出：2
示例 3：
输入：nums = [7,8,9,11,12]
输出：1
提示：
1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
*/
public class Test41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //当前位置的数字大于0，并且小于等于n，并且nums[nums[i]-1]!=nums[i]时
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                //交换 nums[i] - 1 与 i 位置上的值
                swap(nums, nums[i] - 1, i);
            }
        }
        //从头到尾检查数组值的数字，当nums[i] != i + 1时，此时就是第一个缺失的整数
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        //当遍历完数字没有缺失数字，就返回数组长度+1
        return n + 1;
    }
    //交换数组中的两个数字
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
