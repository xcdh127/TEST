package Leetcode;

import java.util.Arrays;

/*给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。
年份 x 的 人口 定义为这一年期间活着的人的数目。
第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内。
注意，人不应当计入他们死亡当年的人口中。

返回 人口最多 且 最早 的年份。
*/
/*输入：logs = [[1993,1999],[2000,2010]]
输出：1993
解释：人口最多为 1 ，而 1993 是人口为 1 的最早年份。*/
/*1 <= logs.length <= 100
1950 <= birthi < deathi <= 2050*/
public class Test186 {
    public int maximumPopulation(int[][] logs) {
        //用于记录每一个年份活着的人数
        int[] arr=new int[1001];
        for (int[] log :logs) {
            //从出生年份到死亡年份前一年时间，遍历这个人的生命线
            for (int i = log[0]; i <log[1] ; i++) {
                arr[i-1950]++;
            }
        }
        //记录人数最多的年份的人数
        int maxPeople=0;
        //记录人数最多的年份
        int maxYear=-1;
        for (int i = 0; i < 1001; i++) {
            //当前年的人数大于历年的最大值时
            //更新当前人最值
            //记录人数最大值的年份
            if (arr[i]>maxPeople){
                maxPeople=arr[i];
                maxYear=1950+i;
            }
        }
        //返回最大年份
        return maxYear;
    }
}
