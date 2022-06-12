package Leetcode;

import java.util.Arrays;

/*小扣在秋日市集选择了一家早餐摊位，
一维整型数组 staple 中记录了每种主食的价格，
一维整型数组 drinks 中记录了每种饮料的价格。
小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。
请返回小扣共有多少种购买方案。
注意：答案需要以 1e9 + 7 (1000000007) 为底取模
，如：计算初始结果为：1000000008，请返回 1
*/
public class Test48 {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        //对两个数组进行排序
        Arrays.sort(staple);
        Arrays.sort(drinks);
        //定义两个指针
        //i指向第一个数组的开头位置
        int i=0;
        //j指向第二个数组的结束位置
        int j=drinks.length-1;
        //统计结果
        int count=0;
        while (i<staple.length && j>=0){
            //求出当前两个指针位置出的和
            int sum=staple[i]+drinks[j];
            //如果当前和小于x
            if (sum<=x){
                //此时j是比较大的数字，此时如果满足题意那么j指向之前的数组都是成立的
                count+=j+1;
                //将总数对1000000007求余数
                count=count%1000000007;
                //将i指针向后移位
                i++;
            }
            //当两数字之和大于x时,将j指针向前移位
            else{
                j--;
            }
        }
        //返回结果
        return count;
    }
}

/*class Solution {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int mod = 1000000007;
        int sl=0,sd=drinks.length-1,ans=0;
        while(sl<staple.length && sd >=0){
            int sum = staple[sl] + drinks[sd];
            if(sum<=x){
                ans += sd + 1;
                ans%=mod;
                sl++;
            }else{
                sd--;
            }
        }
        return ans%=mod;
    }
}*/
