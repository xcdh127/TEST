package codetophuawei;

import java.util.Arrays;

/*给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
示例 1:
输入: nums = [2,2,3,4]
输出: 3
解释:有效的组合是:
2,3,4 (使用第一个 2)
2,3,4 (使用第二个 2)
2,2,3
示例 2:
输入: nums = [4,2,3,4]
输出: 4
提示:
1 <= nums.length <= 1000
0 <= nums[i] <= 1000
*/
public class Test611 {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int count_sub = find(nums, i, j);
                count += count_sub == -1 ? 0 : count_sub - j;
            }
        }
        return count;
    }

    public int find(int[] nums, int i, int j) {
        int n = nums.length;
        int k = n - 1;
        int index = j + 1;
        //当k指针与index没有相遇时
        while (index <= k) {
            int m = index + (k - index) / 2;
            if (nums[i] + nums[j] <= nums[m]) {
                k = m - 1;
            } else {
                if (m == n - 1 || nums[i] + nums[j] <= nums[m + 1]) {
                    return m;
                }
                //中间位置+1
                index = m + 1;
            }
        }
        return -1;
    }
}


class Solution151 {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int count_sub = find(nums, i, j);
                count += count_sub == -1 ? 0 : count_sub - j;
            }
        }
        return count;
    }

    public int find(int[] nums, int i, int j) {
        int n = nums.length;
        int k = n - 1;
        int index = j + 1;
        while (index <= k) {
            int m = index + (k - index) / 2;
            if (nums[i] + nums[j] <= nums[m]) {
                k = m - 1;
            } else {
                if (m == n - 1 || nums[i] + nums[j] <= nums[m + 1]) {
                    return m;
                }
                index = m + 1;
            }
        }
        return -1;
    }
}