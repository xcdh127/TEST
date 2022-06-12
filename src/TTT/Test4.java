package TTT;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test4 {
    public static void main(String[] args) {
       int[] inventory={1000000000};
       int orders = 1000000000;
        System.out.println(maxProfit(inventory,orders));
    }
    public static int maxProfit(int[] inventory, int orders) {
       int mod=1000000007;
       Arrays.sort(inventory);
       int curIndex=inventory.length-1;
       int curValue=inventory[curIndex];
       long profit=0;
       while(orders>0){
           while(curIndex>=0 && inventory[curIndex]==curIndex){
               curIndex--;
           }
           int nextValue=curIndex<0?0:inventory[curIndex];
           int numSameColor=inventory.length-1-curIndex;
           int nums=(curValue-nextValue)*numSameColor;
           if(orders<nums){
               profit+=(long)(curValue+nextValue+1)*(curValue-nextValue)/2*numSameColor;
           }else{
               int numFullRow=orders/numSameColor;
               int remainder=orders%numSameColor;
               profit+=(long)(curValue+curValue-numFullRow+1)*numFullRow/2*numSameColor;
               profit+=(long)(curValue-numFullRow)*remainder;
           }
           orders-=nums;
           profit=profit%mod;
           curValue=nextValue;
       }
       return (int)profit;
    }
}
/*
[1000000000]
1000000000*/