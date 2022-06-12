package Leetcode;


import java.util.HashMap;
import java.util.Map;

/*给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
*/
public class Test29 {
    public int findShortestSubArray(int[] nums) {
        int n=nums.length;
        int du=0;
        //如果数组的长度等于1，直接返回1
        if (n==1) return 1;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            //记录数组中出现的数字以及各数字出现的次数
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            //记录数组中出现数字的最大值
            if (map.get(nums[i])>du){
                du=map.get(nums[i]);
            }
        }
        //载创建一个map，统计子数组中出现最大次数
        Map<Integer,Integer> map1=new HashMap<>();
        //滑动窗口
        int i=0;
        //记录最小的数组长度
        int min=Integer.MAX_VALUE;
        //扩大窗口大小
        for (int j = 0; j <n; j++) {
            //统计数组中出现数字的次数
            map1.put(nums[j],map1.getOrDefault(nums[j],0)+1);
            //当子数组数字出现的最大次数大于等于数组的最大值时
            while (getMax(map1)>=du){
                //记录所有符合子数组中的数字出现最大次数的子数组的最小长度
                min=Math.min(min,j-i+1);
                //数字滑出窗口，将当前数字出现的次数-1
                map1.put(nums[i],map1.get(nums[i])-1);
                //继续缩小窗口
                i++;
            }
        }
        //返回最小值
        return min;
    }
    public int getMax(Map<Integer, Integer> map){
        //统计当前子数组的数字出现最大次数
        int du=0;
        //遍历map，找到所有的键值对中的最大出现次数
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            du=Math.max(entry.getValue(),du);
        }
        //返回map中，出现最多的次数
        return du;
    }
}

/*[2,1]*/