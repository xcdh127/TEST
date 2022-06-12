package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*
你在一家生产小球的玩具厂工作，有 n 个小球，编号从 lowLimit 开始，
到 highLimit 结束（包括 lowLimit 和 highLimit ，即 n == highLimit - lowLimit + 1）。
另有无限数量的盒子，编号从 1 到 infinity 。
你的工作是将每个小球放入盒子中，其中盒子的编号应当等于小球编号上每位数字的和。
例如，编号 321 的小球应当放入编号 3 + 2 + 1 = 6 的盒子，而编号 10 的小球应当放入编号 1 + 0 = 1 的盒子。
给你两个整数 lowLimit 和 highLimit ，返回放有最多小球的盒子中的小球数量。
如果有多个盒子都满足放有最多小球，只需返回其中任一盒子的小球数量。
*/
public class Test167 {
    public int countBalls(int lowLimit, int highLimit) {
        //存放所有数组中的数字的数位和的个数
        Map<Integer,Integer> map=new HashMap<>();
        //从数字lowLimit   到数字hightLimit，统计数位和统计个数，添加到map中
        for (int i = lowLimit; i <=highLimit ; i++) {
            int sum=countNum(i);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        //记录最大的数字
        int maxValue=0;
        for (Map.Entry<Integer, Integer> entry:map.entrySet()){
            //遍历所有的键值对，获取最大键值
            if (maxValue<entry.getValue()){
                maxValue=entry.getValue();
            }
        }
        //返回最大值
        return maxValue;
    }
    //计算数位和
    public int countNum(int num){
        int count=0;
        while (num>0){
            //取每一位数字
            int yuShu=num%10;
            //累加求和
            count+=yuShu;
            num/=10;
        }
        //返回结果
        return count;
    }
}
