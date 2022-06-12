package Test;

import java.util.Scanner;

public class Main16 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line=sc.nextLine().split(",");
        int n=Integer.parseInt(line[0]);
        int m=Integer.parseInt(line[1]);
        int res=playNum(n,m);
        System.out.println(res);
    }

    public static int playNum(int n,int m){
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            dp[i]=(dp[i-1]+m)%i;
        }
        return dp[n]+1;
    }
}
