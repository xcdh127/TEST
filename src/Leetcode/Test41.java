package Leetcode;

import java.util.Arrays;

/*给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对,
 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
返回该 最大总和 。
*/
public class Test41 {
    public int arrayPairSum(int[] nums) {
        //排序
        Arrays.sort(nums);
        int sum=0;
        //两两取最小值，累加求和
        for (int i = 0; i < nums.length / 2; i++) {
            sum+=Math.min(nums[i*2],nums[i*2+1]);
        }
        return sum;
    }
}
