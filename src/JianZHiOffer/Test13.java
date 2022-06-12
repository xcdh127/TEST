package JianZHiOffer;
/*地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
因为3+5+3+8=19。请问该机器人能够到达多少个格子？
示例 1：
输入：m = 2, n = 3, k = 1
输出：3
示例 2：
输入：m = 3, n = 1, k = 0
输出：1
提示：
1 <= n,m <= 100
0 <= k <= 20
*/
public class Test13 {
    public int movingCount(int m, int n, int k) {

        boolean[][] isVisited=new boolean[m][n];
        return recur(m,n,0,0,k,isVisited);


    }
    public int recur(int m,int n,int i,int j,int k,boolean[][] isVisited){
        if (i<0 || i>=m || j<0 || j>=n || sum(i)+sum(j)>k || isVisited[i][j]){
            return 0;
        }
        isVisited[i][j]=true;
        return 1+recur(m,n,i+1,j,k,isVisited)+recur(m,n,i-1,j,k,isVisited)
                +recur(m,n,i,j+1,k,isVisited)+recur(m,n,i,j-1,k,isVisited);
    }

    public int sum(int num){
        int res=0;
        while (num>0){
            int yuShu=num%10;
            res+=yuShu;
            num/=10;
        }
        return res;
    }
}
