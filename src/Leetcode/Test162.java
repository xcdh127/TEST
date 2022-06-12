package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*在整数数组中，如果一个整数的出现频次和它的数值大小相等，
我们就称这个整数为「幸运数」。
给你一个整数数组 arr，请你从中找出并返回一个幸运数。
如果数组中存在多个幸运数，只需返回 最大 的那个。
如果数组中不含幸运数，则返回 -1 。
 */
public class Test162 {
    public int findLucky(int[] arr) {
        int n=arr.length;
        //map存放所有数字出现的次数
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        //记录最大值
        int  maxValue=-1;
        //遍历所有的键值对，记录值等于出现次数的数字，然后将最大值记录
        for (Map.Entry<Integer, Integer> entry :map.entrySet()) {
            if (maxValue<entry.getKey() && entry.getKey()==entry.getValue()){
                maxValue=entry.getKey();
            }
        }
        //返回最大值
        return maxValue;
    }
}
