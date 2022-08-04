package CodeDream;

import java.util.Arrays;

/*给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
示例 1：
输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]
示例 2：
输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]
提示：
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 已按 非递减顺序 排序
*/
public class Test977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        int j = n - 1;
        int index = n - 1;
        while (i <= j) {
            //如果i小于等于j，并且i位置数字乘积大于j位置数字乘积
            //放到结果数组的最后位置上,i向后指向一位
            if (i <= j && nums[i] * nums[i] > nums[j] * nums[j]) {
                res[index--] = nums[i] * nums[i];
                i++;
            }
            //如果i小于等于j，并且i位置数字乘积小于等于j位置数字乘积
            //放到结果数组的最后位置上,j向前指向一位
            else if (i <= j && nums[i] * nums[i] <= nums[j] * nums[j]) {
                res[index--] = nums[j] * nums[j];
                j--;
            }
        }
        //返回结果
        return res;
    }
}

class Solution2 {
    public int[] sortedSquares(int[] nums) {


        int n = nums.length;
        int[] arr = new int[n];
        int i = 0;
        int j = n - 1;
        int index = n - 1;
        while (i <= j) {

            if (i <= j && nums[i] * nums[i] > nums[j] * nums[j]) {
                arr[index--] = nums[i] * nums[i];
                i++;
            } else if (i <= j && nums[i] * nums[i] <= nums[j] * nums[j]) {
                arr[index--] = nums[j] * nums[j];
                j--;
            }
        }
        return arr;
    }
}