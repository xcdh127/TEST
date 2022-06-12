package Leetcode;
/*给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，
第 i 个水缸配备的水桶容量记作 bucket[i]。小扣有以下两种操作：
升级水桶：选择任意一个水桶，使其容量增加为 bucket[i]+1
蓄水：将全部水桶接满水，倒入各自对应的水缸
每个水缸对应最低蓄水量记作 vat[i]，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
注意：实际蓄水量 达到或超过 最低蓄水量，即完成蓄水要求。
*/
public class Test73 {

}


class Solution33 {
    public int storeWater(int[] bucket, int[] vat) {
        int max = 0;
        //记录最大的桶的容量
        for(int v : vat) {
            max = Math.max(max, v);
        }
        if(max == 0) return 0;
        int ans = Integer.MAX_VALUE;
        //枚举蓄水的次数
        for(int k=1;k<=max;k++){
            //当蓄水次数k大于当前最小的操作次数时跳出循环
            if(k>=ans) break;
            int cur = k;
            for(int i=0;i<vat.length;i++){
                //累加上水桶升级的次数(向上取整)，从蓄水次数倒推出这个桶是多大的小桶倒满的
                //此时使用的是向上取整-减去小水瓢原大小就是升级的次数
                cur += Math.max(vat[i]/k + (vat[i]%k==0?0:1) - bucket[i], 0);
            }
            //记录最次的操作次数
            ans = Math.min(ans, cur);
        }
        //返回结果
        return ans;
    }
}