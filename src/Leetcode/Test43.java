package Leetcode;

import java.util.*;

/*给你一个整数数组 nums ，
请你将数组按照每个值的频率 升序 排序。
如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
请你返回排序后的数组。*/
public class Test43 {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //统计所有的单词出现的次数
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //存放数字以及数字在数组中出现次数
        List<int[]> list=new ArrayList<>();
        //将所有的数组中出现的数字以及数字出现的次数存放到数组当中
        //以{数字，出现次数}形式存放
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            list.add(new int[]{entry.getKey(),entry.getValue()});
        }
        int[][] arr=list.toArray(new int[list.size()][2]);
        Arrays.sort(arr,(a,b)->{
            //当两个数字出现的次数不相等时，将按照出现的次数进行升序排序
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }
            //当两个数字在数组中出现的次数相同时，就比较两个数字的大小.按照数字的大小降序排序
            else {
                return b[0]-a[0];
            }
        });
        //用于存放结果的数组
        int[] res=new int[nums.length];
        //将排过序的数组存放到结果数组当中
        int index=0;
        for (int i = 0; i < arr.length; i++) {
            //将当前数字在数组中出现的次数将当前数字填充到新数组当中
            for (int j = 0; j < arr[i][1]; j++) {
                res[index++]=arr[i][0];
            }
        }
        //返回结果组
        return res;
    }
}
