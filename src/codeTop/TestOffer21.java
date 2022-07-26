package codeTop;

/*输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
示例：
输入：nums =[1,2,3,4]
输出：[1,3,2,4]
注：[3,1,2,4] 也是正确的答案之一。
提示：
0 <= nums.length <= 50000
0 <= nums[i] <= 10000
*/
public class TestOffer21 {
    public int[] exchange(int[] nums) {
        int n = nums.length;
        //i指针从前到后指向奇数
        int i = 0;
        //j指针从前到后指向偶数
        int j = n - 1;
        //当i<j时
        while (i < j) {
            //当i<j时，i指针指向的数字是奇数，就继续向后指向
            while (i < j && nums[i] % 2 == 1) {
                i++;
            }
            //当i<j时，j指针指向的数字是偶数时，就继续向前指向
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            //交换数组中的两个数字i，j
            swap(nums, i, j);
        }
        //返回数组
        return nums;
    }
    //交换数组的两个数字
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
