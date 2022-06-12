package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*给你个整数数组 arr，其中每个元素都 不相同。
请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。*/
public class Test49 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n=arr.length;
        //对数组进行排序
        Arrays.sort(arr);
        //存放结果的集合
        List<List<Integer>> res=new ArrayList<>();
        //记录最小元素差
        int minDiff=Integer.MAX_VALUE;
        //计算相邻数组的差值
        for (int i = 1; i < n; i++) {
            //如果两个相邻的数字之差小于最小值
            if (arr[i]-arr[i-1]<minDiff){
                //更新最小值
                minDiff=arr[i]-arr[i-1];
                //更新结果数组
                res=new ArrayList<>();
                //向结果中添加这两个元素
                res.add(Arrays.asList(arr[i-1],arr[i]));
            }
            //如果和最小差相等就直接添加到结果中
            else if (arr[i]-arr[i-1]==minDiff){
                res.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return res;
    }
}
