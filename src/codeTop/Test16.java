package codeTop;

import java.util.Arrays;

/*给你一个长度为 n 的整数数组 nums 和 一个目标值 target。
请你从 nums 中选出三个整数，使它们的和与 target 最接近。
返回这三个数的和。
假定每组输入只存在恰好一个解。
示例 1：
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
示例 2：
输入：nums = [0,0,0], target = 1
输出：0
提示：
3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104
*/
public class Test16 {
    public int threeSumClosest(int[] nums, int target) {
        //对nums进行排序
        Arrays.sort(nums);
        //数组长度为n
        int n = nums.length;
        //最佳和best
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            //保证与上次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //双指针j指向i的后面一位
            int j = i + 1;
            //k指向数组的最后一位
            int k = n - 1;
            //当j<k时
            while (j < k) {
                //求三个指针数字之和
                int sum = nums[i] + nums[j] + nums[k];
                //当sum==target时，返回target
                if (sum == target) {
                    return target;
                }
                //根据差值的绝对值，更新答案
                //当sum的值更接近target时，best=sum
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                //和sum大于target时
                if (sum > target) {
                    //指针k向里指向
                    int k0 = k - 1;
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                }
                //和sum小于target时
                else {
                    //指针j向外指向
                    int j0 = j + 1;
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        //返回最接近target的和
        return best;
    }
}

class Solution29 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }
}
