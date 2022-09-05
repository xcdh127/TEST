package Jianzhioffer02;

/*输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
示例：
输入：nums = [1,2,3,4]
输出：[1,3,2,4]
注：[3,1,2,4] 也是正确的答案之一。
提示：
0 <= nums.length <= 50000
0 <= nums[i] <= 10000
*/
public class Test21 {
    public int[] exchange(int[] nums) {
        int n = nums.length;
        //双指针，一个指向头一个指向末尾
        int i = 0;
        int j = n - 1;
        while (i < j) {
            //为奇数向后遍历
            while (i < j && nums[i] % 2 == 1) {
                i++;
            }
            //为偶数向后遍历
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            //交换这两个位置的数字
            swap(nums, i, j);
        }
        //返回修改后的数组
        return nums;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
