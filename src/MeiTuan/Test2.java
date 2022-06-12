package MeiTuan;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] line=sc.nextLine().split(" ");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(line[i]);
        }
        long max=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long[] temp=new long[n];
                for(int k=0;k<n;k++){
                    temp[k]=(long)arr[k];
                }
                long[] a=reverse(temp,i,j);
                long sum=getSum(a);
                if(sum>max){
                    max=sum;
                }
            }
        }
        System.out.println(max);
    }
    //反转
    public static long[] reverse(long[] arr,int a,int b){
        int n=arr.length;
        long[] temp=new long[n];
        for(int i=0;i<n;i++){
            temp[i]=arr[i];
        }
        while(a<b){
            long tem=temp[a];
            temp[a]=temp[b];
            temp[b]=tem;
            a++;
            b--;
        }
        return temp;
    }

    //求子序和
    public static long getSum(long[] arr){
        int n=arr.length;
        long[] dp=new long[n];
        dp[0]=arr[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1]+arr[i],arr[i]);
        }
        long max=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(max<dp[i]){
                max=dp[i];
            }
        }
        return max;
    }
}
