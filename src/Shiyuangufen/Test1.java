package Shiyuangufen;

import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) {
        int index=0;
        int[] s={-1,-8,0,5,-9};
        int max=0;
        System.out.println(getNum(s));
//        ArrayList<Integer> list=new ArrayList<>();
//        process(s,0,0,0,list);
//        int max=0;
//        for(int i=0;i<list.size();i++){
//            max=Math.max(max,list.get(i));
//        }
//        System.out.println(max);

    }

//    public static void process(int[] arr, int sum, int index, int num, ArrayList<Integer> list){
//        if(index==arr.length){
//            list.add(sum);
//            return;
//        }
//        process(arr,sum,index+1,num,list);
//        process(arr,sum+arr[index]*(num+1),index+1,num+1,list);
//    }

    public static int getNum(int[] s){
        int n=s.length;
        int[][] dp=new int[n][2];
//      dp[i][0]表示将这物品做了
//      dp[i][1]表示不将这个物品做了
        dp[0][0]=s[0];
        dp[0][1]=0;
        int index=0;
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0]+s[i]*(index+1),dp[i-1][1]+s[i]*(index+1));
            dp[i][1]=Math.max(dp[i-1][0],dp[i-1][1]);
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=1;j++){
                if(max<dp[i][j]){
                    max=dp[i][j];
                }
            }
        }
        return max;
    }

}
