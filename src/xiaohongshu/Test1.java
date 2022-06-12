package xiaohongshu;
import java.util.*;
public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line1=sc.nextLine().split(" ");
        int M=Integer.parseInt(line1[0]);
        int N=Integer.parseInt(line1[1]);
        int[][] arr=new int[M][N];
        for(int i=0;i<M;i++){
            String[] line2=sc.nextLine().split(" ");
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(line2[j]);
            }
        }
        int[][] dp=new int[M+1][N+2];
        for(int i=1;i<=M;i++){
            for(int j=1;j<=N;j++){
                dp[i][j]=arr[i-1][j-1]+Math.max(Math.max(dp[i-1][j-1],dp[i-1][j]),dp[i-1][j+1]);
            }
        }
        int max=0;
        for(int i=0;i<=N+1;i++){
            max=Math.max(max,dp[M][i]);
        }
        System.out.println(max);



    }

}
