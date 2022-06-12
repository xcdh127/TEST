package Leetcode;

import java.util.Arrays;

/*你有一些苹果和一个可以承载 5000 单位重量的篮子。
给定一个整数数组 weight ，
其中 weight[i] 是第 i 个苹果的重量，返回 你可以放入篮子的最大苹果数量 。
*/
public class Test60 {
    public int maxNumberOfApples(int[] weight) {
        //对水果的重量数组排序
        Arrays.sort(weight);
        int n=weight.length;
        //从头累加当前数组中的元素当总重量小于5000时
        //放进去的总的品苹果重量
        int total=0;
        //放进去的苹果数量
        int count=0;
        for (int i = 0; i < n; i++) {
            //将当前苹果重量添加到总重量中
            total+=weight[i];
            //当总重量小于等于5000时，累加苹果的数量
            if (total<=5000){
                count++;
            }
        }
        //返回苹果的数量
        return count;
    }
}
