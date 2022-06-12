package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。

请你找到并返回这个整数*/
public class Test240 {
    public int findSpecialInteger(int[] arr) {
        int n=arr.length;

        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            if (entry.getValue()>n/4){
                return entry.getKey();
            }
        }
        return -1;
    }
}
