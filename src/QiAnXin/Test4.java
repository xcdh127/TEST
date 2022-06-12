package QiAnXin;

import java.util.ArrayList;
import java.util.Arrays;

public class Test4 {
    public static void main(String[] args) {
        ArrayList<Integer> res=new ArrayList<>();
//        res.add(2);
//        res.add(100);
//        res.add(2);
//        res.add(3);
//        res.add(3);
//        res.add(90);
//        res.add(3);
//        res.add(2);
//        res.add(80);
//        res.add(2);
        res.add(4);
        res.add(9);
        res.add(24);
        System.out.println(min(res));
    }

    public static int min(ArrayList<Integer> goods){
        int size=goods.size();
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=goods.get(i);
        }
        int[] dp=new int[size+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[size-1]=arr[size-1];
        dp[size-2]=arr[size-2];
        for(int i=size-3;i>=0;i--){
            dp[i]=arr[i]+Math.min(dp[i+1],dp[i+2]);
        }
        return Math.min(dp[0],dp[1]);
    }
}
