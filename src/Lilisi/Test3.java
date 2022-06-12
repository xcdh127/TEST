package Lilisi;

import java.util.*;


public class Test3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param a int整型一维数组
     * @return long长整型
     */
    public long minimum (int[] a) {
        // write code here
        long sum=0;
        int n=a.length;
        for(int i=0;i<n;i++){
            sum+=a[i];
        }
        long min=Long.MAX_VALUE;
        int i=0;
        for(;i<n;i++){
            int j=i;
            long subSum=0;
            while(j<n){
                long Sum=sum;
                subSum+=a[j];
                long sum1=Sum-subSum;
                long dif=Math.abs(sum1-subSum);
                min=Math.min(dif,min);
                j++;
            }
        }
        return min;
    }
}
