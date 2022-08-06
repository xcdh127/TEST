package CodeDream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 
[nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。
示例 1：
输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
示例 2：
输入：nums = [2,2,2,2,2], target = 8
输出：[[2,2,2,2]]
提示：
1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
*/
public class Test18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //将target换成long
        long tar = target;
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        while (i < n - 3) {
            int j = i + 1;
            while (j < n - 2) {
                //双指针
                int k = j + 1;
                int z = n - 1;
                while (k < z) {
                    //四数之和都转成long，相加，和等于target时，放进结果中
                    if ((long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[z] == tar) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[z]));
                        //找下一个不同的k
                        int temp = nums[k];
                        while (k < z && nums[k] == temp) {
                            k++;
                        }
                    }
                    //四数之和大于target时，指针z--
                    else if ((long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[z] > tar) {
                        z--;
                    }
                    //四数之和小于target时，指针k++
                    else {
                        k++;
                    }
                }
                //找下一个不同的j
                int temp = nums[j];
                while (j < n - 2 && temp == nums[j]) {
                    j++;
                }
            }
            //找下一个不同的i
            int temp = nums[i];
            while (i < n - 3 && nums[i] == temp) {
                i++;
            }
        }
        //返回结果
        return res;
    }
}
