package CodeTop02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j],
nums[k]] 满足 i != j、i != k 且 j != k ，
同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
你返回所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。
示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
示例 2：
输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
示例 3：
输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。
提示：
3 <= nums.length <= 3000
-105 <= nums[i] <= 105
*/
public class Test15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //对数组进行排序
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        //i指针小于数组的倒数第二位置
        while (i < n - 2) {
            int j = i + 1;
            int k = n - 1;
            //当j小于k时
            while (j < k) {
                //三数和为0时，将三个数字放进结果集中
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    //记录j位置的数字，向后寻找不同的数字
                    int temp = nums[j];
                    while (j < k && temp == nums[j]) {
                        j++;
                    }
                }
                //三数之和大于0时，k--
                else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                //三数之和小于0时，j++
                else {
                    j++;
                }
            }
            //记录i位置的数字，向后寻找不同的数字
            int temp = nums[i];
            while (i < n - 2 && temp == nums[i]) {
                i++;
            }
        }
        //返回结果
        return res;
    }
}
