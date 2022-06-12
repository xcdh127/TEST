package Test;

public class Main13 {
    public static void main(String[] args) {
        int[][] nums=new int[][]{{1,2,4,2},{2,3,1,6},{3,7,1,3},{1,6,8,2}};
        int n=nums.length;
        int row=1;
        int col=2;
        int[][] dp=new int[n][n];
        for(int i=0;i<=row;i++){
            for(int j=0;j<=col;j++){
                if(i==0 && j==0){
                    dp[i][j]=nums[i][j];
                }
                else if(i!=0 && j==0){
                    dp[i][j]=dp[i-1][j]+nums[i][j];
                }
                else if(i==0 && j!=0){
                    dp[i][j]=dp[i][j-1]+nums[i][j];
                }
                else if(i!=0 && j!=0){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+nums[i][j];
                }

            }

        }
        System.out.println(dp[row][col]);
    }
}
