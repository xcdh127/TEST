package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和
（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
*/
/*
输入：n = 13
输出：4
解释：总共有 9 个组，将 1 到 13 按数位求和后这些组分别是：
[1,10]，[2,11]，[3,12]，[4,13]，[5]，[6]，[7]，[8]，[9]。总共有 4 个组拥有的数字并列最多。
*/
public class Test163 {
    public int countLargestGroup(int n) {
        //存放不同数位和的个数
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 1; i <=n ; i++) {
            //计算数位和
            int sum=sumNum(i);
            //统计数位为当前数字的个数
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        //记录最大个数
        int maxVlaue=0;
        //记录最大个有多少个
        int count=0;
        //遍历所有键值对
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            //获取当前键值判断是否大于当前最大个数
            //如果大于就将当前数字记录下来，将此时值的个数是最大值的值赋值为1
            if (entry.getValue()>maxVlaue){
                maxVlaue=entry.getValue();
                count=1;
            }
            //否则判断个数是否等于最大值，如果等于就+1
            else if (entry.getValue()==maxVlaue){
                count++;
            }
        }
        //返回结果
        return count;
    }
    //计算数位和
    public int sumNum(int n){
        int count=0;
        while (n>0){
            //取出各位
            int yuShu=n%10;
            //计算数位和
            count+=yuShu;
            n/=10;
        }
        return count;
    }
}
