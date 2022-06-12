package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*给你一个下标从 0 开始的整数数组 nums ，同时给你一个整数 key ，它在 nums 出现过。
统计 在 nums 数组中紧跟着 key 后面出现的不同整数 target 的出现次数。换言之，
target 的出现次数为满足以下条件的 i 的数目：
0 <= i <= n - 2
nums[i] == key 且
nums[i + 1] == target 。
请你返回出现 最多 次数的 target 。测试数据保证出现次数最多的 target 是唯一的。
。*/
/*输入：nums = [1,100,200,1,100], key = 1
输出：100
解释：对于 target = 100 ，在下标 1 和 4 处出现过 2 次，且都紧跟着 key 。
没有其他整数在 key 后面紧跟着出现，所以我们返回 100 。

输入：nums = [2,2,2,2,3], key = 2
输出：2
解释：对于 target = 2 ，在下标 1 ，2 和 3 处出现过 3 次，且都紧跟着 key 。
对于 target = 3 ，在下标 4 出出现过 1 次，且紧跟着 key 。
target = 2 是紧跟着 key 之后出现次数最多的数字，所以我们    返回 2 。

*/
public class Test171 {
    public int mostFrequent(int[] nums, int key) {
        int n=nums.length;
        //使用map存放所有的key后出现的数字及其出现的次数
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            //当出现key时，统计紧跟其后数字即其出现的次数
            if (nums[i]==key){
                map.put(nums[i+1],map.getOrDefault(nums[i+1],0)+1);
            }
        }
        //记录最大值
        int maxValue=0;
        //最大值为-1
        int maxKey=-1;
        //遍历所有的键值对
        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            //出现次数大于之前最大值，更新，赋值最大key
            if (entry.getValue()>maxValue){
                maxKey=entry.getKey();
                maxValue=entry.getValue();
            }
        }
        //返回最大Key
        return maxKey;
    }
}
