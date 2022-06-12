package Leetcode;

import java.util.Arrays;

/*给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
与 标准答案 误差在 10-5 的结果都被视为正确结果。*/
public class Test61 {
    public double trimMean(int[] arr) {
        int n=arr.length;
        //将数组进行排序
        Arrays.sort(arr);
        //求得数组前百分5的下标位置
        int deleteTop=(int)(n*0.05);
        //去掉后百分之5的数组位置
        int deleteTail=n-1-deleteTop;
        //统计数组中的剩余数字和
        double sum=0.0;
        for (int i = deleteTop; i <= deleteTail; i++) {
            sum+=arr[i];
        }
        //求出平均值
        return sum/(deleteTail-deleteTop+1);
    }
}
