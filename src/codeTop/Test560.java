package codeTop;

import java.util.HashMap;
import java.util.Map;

/*给你一个整数数组 nums 和一个整数k ，请你统计并返回 该数组中和为k的连续子数组的个数 。
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
        //记录前缀和
        Map<Integer,Integer> map=new HashMap<>();
        //和为0的子数组的个数为1个
        map.put(0,1);
        //记录数组前缀和
        int sum=0;
        //记录和为k的子数组的个数
        int count=0;
        //遍历数组
        for (int num :nums) {
            //求子数组的和
            sum+=num;
            //寻找map中有几个和为sum-k的子数组
            if (map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            //将前缀和以及这个和出现的次数添加到map中存放
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        //返回结果
        return count;
    }
}
