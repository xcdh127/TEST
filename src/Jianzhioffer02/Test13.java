package Jianzhioffer02;

/*地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、
下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
例 1：
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
    int m;
    int n;
    int k;
    boolean[][] isVisited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        //记录当前位置是否遍历过
        isVisited = new boolean[m][n];
        return recur(0, 0);
    }

    public int recur(int i, int j) {
        //当前位置超出矩阵的范围，或者当前位置遍历过，或者当前位置的和大于K
        if (i < 0 || i >= m || j < 0 || j >= n || isVisited[i][j] || count(i) + count(j) > k) {
            return 0;
        }
        //标记（i,j）位置已经遍历过
        isVisited[i][j] = true;
        //返回（i,j）位置出可以走几个格子
        return 1 + recur(i + 1, j) + recur(i - 1, j) + recur(i, j + 1) + recur(i, j - 1);
    }

    //计算数字的数位和
    public int count(int n) {
        int res = 0;
        while (n > 0) {
            int yushu = n % 10;
            res += yushu;
            n /= 10;
        }
        //返回结果
        return res;
    }
}

class Solution50 {
    int m;
    int n;
    int k;
    boolean[][] isVisited;

    public int movingCount(int m, int n, int k) {

        this.m = m;
        this.n = n;
        this.k = k;

        this.isVisited = new boolean[m][n];
        return recur(0, 0);
    }

    public int sum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public int recur(int i, int j) {

        if (i < 0 || j < 0 || i >= m || j >= n || isVisited[i][j] || sum(i) + sum(j) > k) {
            return 0;
        }
        isVisited[i][j] = true;
        return 1 + recur(i + 1, j) + recur(i - 1, j) + recur(i, j - 1) + recur(i, j + 1);
    }
}
