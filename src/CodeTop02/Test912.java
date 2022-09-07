package CodeTop02;

/*给你一个整数数组 nums，请你将该数组升序排列。
示例 1：
输入：nums = [5,2,3,1]
输出：[1,2,3,5]
示例 2：
输入：nums = [5,1,1,2,0,0]
输出：[0,0,1,1,2,5]
提示：
1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104
*/
public class Test912 {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        recur(nums, 0, n - 1);
        return nums;
    }

    public void recur(int[] nums, int l, int r) {
        //当l大于r时，返回
        if (l > r) {
            return;
        }
        //i指针指向数组的左边界
        int i = l;
        //j指针指向数组的右边界
        int j = r;
        //哨兵节点为左边界的值
        int p = l;
        //当两个指针没有相遇时，
        while (i < j) {
            //当j指针指向的数字大于等于哨兵节点位置的数字时，指针j--
            while (i < j && nums[j] >= nums[p]) {
                j--;
            }
            //当i指针指向的数字小于等于哨兵节点位置的数字时，指针i++
            while (i < j && nums[i] <= nums[p]) {
                i++;
            }
            //交换数组中这两个数字
            swap(nums, i, j);
        }
        //更新哨兵位置
        p = i;
        //交换哨兵和数组左边界的数字
        swap(nums, l, p);
        //数组左半部分排序
        recur(nums, l, p - 1);
        //数组右半部分排序
        recur(nums, p + 1, r);
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
