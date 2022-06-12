package Leetcode;

import TTT.A;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
序号代表了一个元素有多大。序号编号的规则如下：
序号从 1 开始编号。
一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
每个数字的序号都应该尽可能地小。
*/
public class Test45 {
    public int[] arrayRankTransform(int[] arr) {
        //首先拷贝一份原数组
        int[] copy=Arrays.copyOf(arr,arr.length);
        Arrays.sort(arr);
        //新建一个hash表，将排序后的数字添加到hash表中，序号+1
        Map<Integer,Integer> map=new HashMap<>();
        //用于比较前后两个数字是否相等
        int prev=Integer.MAX_VALUE;
        //排序后数组中数字的占位
        int index=1;
        for (int num :arr) {
            //如果记录
            if (prev!=Integer.MAX_VALUE){
                //前后数字不相等，就增加排序序号
                if (prev!=num){
                    index++;
                }
            }
            //前一个数字记录当前数字
            prev=num;
            //将当前数字以及当前数字在数组中的位置记录到map中
            map.put(num,index);
        }
        //用于返回结果的数组
        int[] res=new int[arr.length];
        //原数组的拷贝数组没有发生变化
        for (int i = 0; i < copy.length; i++) {
            //将排序后的数字下标放置到原数组中对应的位置上
            res[i]=map.get(copy[i]);
        }
        //返回结果
        return res;
    }
}
