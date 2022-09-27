package codetophuawei;

import java.util.HashMap;
import java.util.Map;

/*给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
示例 1：
输入：nums = [1,1,1], k = 2
输出：2
示例 2：
输入：nums = [1,2,3], k = 3
输出：2
提示：
1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*/
public class Test560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        //记录数组的和
        int sum = 0;
        //记录count值
        int count = 0;
        //map存放数组和以及和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        //将和为0的数组的次数记为1次
        map.put(0, 1);
        //遍历数组
        for (int j = 0; j < n; j++) {
            //求子数组的和
            sum += nums[j];
            //如果 map中存在子数组和-k的值时
            if (map.containsKey(sum - k)) {
                //count累加sum-k出现的次数
                count += map.get(sum - k);
            }
            //向map中存放和以及当前和出现的次数
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        //返回和为k的子数组的个数
        return count;
    }
}
