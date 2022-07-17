package HOT100;

import java.util.HashMap;
import java.util.Map;

/*给你一个整数数组 nums 和一个整数k ，请你统计并返回 该数组中和为k的子数组的个数。
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
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        //初始化和为0的数组个数为1
        map.put(0,1);
        //记录数组的和
        int sum=0;
        //记录和为k的子数组的个数
        int count=0;
        for (int num :nums) {
            //求数组总和
            sum+=num;
            //如果map中包含sum-k，那么和为k的子数组的个数就累加
            if (map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            //将和为sum的数组的个数+1
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}

/*class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        //统计和为k子数组的个数
        int count=0;
        //记录数组和
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for (int num : nums) {
            sum+=num;
            //如果map中含有sum-k，那么此时的子数组和sum-(sum-k)就会出现和为k的子数组
            if (map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}*/
