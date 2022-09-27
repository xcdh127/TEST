package codetophuawei;

/*给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
示例 1：
输入：nums = [10,5,2,6], k = 100
输出：8
解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
示例 2：
输入：nums = [1,2,3], k = 0
输出：0
提示: 
1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106
*/
public class Test713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int res = 1;
        //滑动窗口的左边界
        int i = 0;
        //记录个数
        if (k <= 1) {
            return 0;
        }
        int count = 0;
        //滑动窗口的右边界
        for (int j = 0; j < n; j++) {
            //窗口向右滑动，累乘当前数字
            res *= nums[j];
            //乘积大于等于k时
            while (res >= k) {
                //缩小窗口，乘积除以窗口的左边界值
                res /= nums[i];
                //继续缩小窗口
                i++;
            }
            //累加乘积小于k的子数组个数
            count += j - i + 1;
        }
        //返回个数
        return count;
    }
}


class Solution115 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int mutil = 1;
        int count = 0;
        if (k <= 1) {
            return 0;
        }
        for (int j = 0; j < n; j++) {
            mutil *= nums[j];
            while (mutil >= k) {
                mutil /= nums[i++];
            }
            count += j - i + 1;
        }
        return count;
    }
}