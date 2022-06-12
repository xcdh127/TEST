package Leetcode;

import java.util.*;

/*给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
请你返回排序后的数组。
*/
public class Test50 {
    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        Pairs[] pairs=new Pairs[n];
        //记录数字在数组中出现的次数
        Map<Integer,Integer> map=new HashMap<>();
        //将数字以及数字中二进制中1的个数统计下来
        for (int i = 0; i < n; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int index=0;
        //遍历map集合，将集合中的数字的出现次数以及1的个数一并统计
        for (Map.Entry<Integer, Integer> entry :map.entrySet()) {
            //拿到当前数字
            int num=entry.getKey();
            //计算当前数字二进制中的个数
            int bitCount=bitCount(num);
            //当前数字出现的次数
            int ciShu=entry.getValue();
            for (int i = 0; i < ciShu; i++) {
                //将当前数字以及数字中存在的1的个数记录在pairs中
                pairs[index++]=new Pairs(num,bitCount,ciShu);
            }
        }

        //对Pairs数组进行排序
        Arrays.sort(pairs,(a,b)->(compare(a,b)));
        //存放结果的数组
        int[] res=new int[n];
        for (int i = 0; i < arr.length; i++) {
            //将pairs对象中的当前数字添加到结果数组中
            res[i]=pairs[i].num;
        }
        return res;
    }
    public int bitCount(int num){
        //将一个数字与比它小1的数字比较可以消去最右边的1
        //可以操作的次数就是当前数字二进制中含有1的个数
        int count=0;
        while (num>0){
            num=num&(num-1);
            count++;
        }
        return count;
    }

    //定义排序规则
    public int compare(Pairs pairs1,Pairs pairs2){
        //拿到两个对象的二进制中1的个数
        int bitCount1=pairs1.bitCount;
        int bitCount2=pairs2.bitCount;
        //排序规则
        //如果两个数字二进制数字1的个数不相等时
        //按照二进制中1的个数进行排序
        if (bitCount1!=bitCount2){
            return bitCount1-bitCount2;
        }
        //如果两个1的个数相同，就按照数字的大小进行升序排序
        return pairs1.num-pairs2.num;
    }

}

//自定义一个存放当前数字二进制中1的个数和这个数字在数组中出现的次数
class Pairs{
    //当前数字
    int num;
    int bitCount;
    int count=0;
    Pairs(int num,int bitCount,int count){
        this.num=num;
        this.bitCount=bitCount;
        this.count=count;
    }
}
