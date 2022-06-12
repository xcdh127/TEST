package TTT;

import java.util.Arrays;

public class Test8 {
    public int smallestRangeI(int[] nums, int k) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        //最大值与最小值的差值小于等于2k时，可以通过加减使得数组中的数字搜都相等
        if(max-min<=2*k){
            return 0;
        }
        //不能使得数组中的数字都相等，那么最小差值就是最大值与最小值之差-2*k
        else{
            return max-min-2*k;
        }
    }
}
/*给你一个整数数组 nums，和一个整数 k 。
在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。将 nums[i] 改为
nums[i] + x ，其中 x 是一个范围为 [-k, k] 的整数。对于每个索引 i ，最多 只能 应用 一次 此操作。
nums 的 分数 是 nums 中最大和最小元素的差值。 
在对  nums 中的每个索引最多应用一次上述操作后，返回 nums 的最低 分数 。
*/