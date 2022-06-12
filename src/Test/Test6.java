package Test;

import java.util.HashMap;
import java.util.Map;

/*给你一个整数数组 nums 和一个整数 k ，
请你统计并返回 该数组中和为 k 的子数组的个数 。
*/
public class Test6 {
/*    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        //统计和为k子数组的个数
        int count=0;
        //从0~n-1确定子数组开头元素
        for (int i = 0; i <n; i++) {
            int sum=0;
            //从前向后累加各子数组的和
            //如果和为k，count+1
            for (int j = i; j < n; j++) {
                sum+=nums[j];
                if (sum==k){
                    count++;
                }
            }
        }
        return count;
    }*/

    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        //统计和为k子数组的个数
        int count=0;
        //记录数组和
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        //和为0的子数组出现1次
        map.put(0,1);
        for (int num : nums) {
            //求数组加到当前数字的子数组和
            sum+=num;
            //如果map中含有sum-k，那么此时的子数组和sum-(sum-k)就会出现和为k的子数组
            //count累加和为sum-k的子数组的个数
            if (map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            //将当前数组的和sum，以及和为sum的子数组的个数添加到map中
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
