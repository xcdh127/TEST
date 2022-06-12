package Test;


import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] dp=new int[n+1];
        dp[0]=0;
        int a=0;
        int b=0;
        for(int i=1;i<=n;i++){
            dp[i]=Math.min(dp[a]*2+1,dp[b]*3+1);
            if(dp[i]==dp[a]*2+1){
                a++;
            }
            if(dp[i]==dp[b]*3+1){
                b++;
            }
        }

//        int[] dp=new int[n+1];
//        dp[0]=0;
//        for(int i=1;i<=n;i++){
//            if(i%2==1) {
//                dp[i] = dp[i-1] * 2 + 1;
//            }
//            else {
//                dp[i] = dp[i - 2] * 3 + 1;
//            }
//        }

            System.out.println(dp[n]);
    }
}
