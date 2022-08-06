package CodeDream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。
示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
示例 2：
输入：nums = []
输出：[]
示例 3：
输入：nums = [0]
输出：[]
提示：
0 <= nums.length <= 3000
-105 <= nums[i] <= 105
*/
public class Test15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        int i = 0;
        //排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //指针i没有指到n-2位置就继续向后指
        while (i < n - 2) {
            //双指针
            int j = i + 1;
            int k = n - 1;
            //当两个指针没有相遇时
            while (j < k) {
                //三个指针指向的数字之和为0时
                if (nums[i] + nums[j] + nums[k] == 0) {
                    //添加三元组进结果中
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    //找下一个不同的j
                    int temp = nums[j];
                    while (j < k && temp == nums[j]) {
                        j++;
                    }
                }
                //当三数之和小于0时，指针j向后指
                else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }
                //当三数之和大于0时，指针k向前指
                else {
                    k--;
                }
            }
            //找下一个不同的i
            int temp = nums[i];
            while (i < n - 2 && temp == nums[i]) {
                i++;
            }
        }
        //返回结果
        return res;
    }
}
