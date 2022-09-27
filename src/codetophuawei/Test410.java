package codetophuawei;

/*给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
设计一个算法使得这 m 个子数组各自和的最大值最小。
示例 1：
输入：nums = [7,2,5,10,8], m = 2
输出：18
解释：
一共有四种方法将 nums 分割为 2 个子数组。
其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
示例 2：
输入：nums = [1,2,3,4,5], m = 2
输出：9
示例 3：
输入：nums = [1,4,4], m = 3
输出：4
提示：
1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= m <= min(50, nums.length)
*/
public class Test410 {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        //二分查找的左边界，数组中的最大值
        int left = 0;
        //二分查找的右边界，数组的和
        int right = 0;
        for (int i = 0; i < n; i++) {
            //累加数组和
            right += nums[i];
            //记录最大值
            if (left < nums[i]) {
                left = nums[i];
            }
        }
        //在最小值和最大值之间搜索符合和最小的分割数组和
        while (left < right) {
            //mid就是此时连续子数组和中最大值
            int mid = left + (right - left) / 2;
            //如果数组符合条件，就向前搜索
            if (check(nums, mid, m)) {
                right = mid;
            }
            //如果数组不符合条件，就向后搜索
            else {
                left = mid + 1;
            }
        }
        //返回left
        return right;
    }

    //m表示子数组的段数
    public boolean check(int[] nums, int maxSum, int m) {
        int n = nums.length;
        int sum = 0;
        //记录数组的段数
        int count = 1;
        for (int i = 0; i < n; i++) {
            //如果将当前数字累加到和中大于了x
            if (sum + nums[i] > maxSum) {
                //将当前数字作为新端开始
                sum = nums[i];
                count++;
            }
            //当子数组的和加上第i个数字的和不大于sum时，就将和继续累加
            else {
                sum += nums[i];
            }
        }
        //分段次数小于分段数m
        return count <= m;
    }
}


class Solution111 {
    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (check(nums, mid, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int x, int m) {
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > x) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }
}
