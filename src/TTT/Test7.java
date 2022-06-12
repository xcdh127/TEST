package TTT;
import java.util.*;
public class Test7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        while (t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            long[][] arr=new long[n][m];
            for(int i=0;i<n;i++){
                    arr[0][i]=sc.nextLong();
            }
            long[][] dp=new long[n][2];
            long cnt=0;
            for(int i=0;i<m;i++){
                cnt+=arr[0][i];
                dp[0][0]=Math.max(cnt,dp[0][0]);
            }
            dp[0][1]=cnt;
            for (int i = 1; i < n; i++) {
                long l=0;
                long r=0;
                for (int j = 0,k =m-1;j<m ; j++,k--) {
                    l+=arr[i][j];
                    r+=arr[i][k];
                    dp[i][0]=Math.max(dp[i][0],l);
                    dp[i][1]=Math.max(dp[i][1],r);
                }
                dp[i][0]=Math.max(dp[i][0]+dp[i-1][0],dp[i-1][1]+r);
                dp[i][1]=Math.max(dp[i][1]+dp[i-1][1],dp[i-1][0]+l);
            }
            System.out.println(Math.max(dp[n-1][0],dp[n-1][1]));
        }
    }

}
