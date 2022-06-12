package Leetcode;
/*给你两个大小为 n x n 的二进制矩阵 mat 和 target 。
现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与 target 一致，
返回 true ；否则，返回 false 。
*/
/*输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
输出：true
解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
*/
public class Test235 {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length;
        boolean b1=true;
        boolean b2=true;
        boolean b3=true;
        boolean b4=true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[n-j-1][i]!=target[i][j]){
                    b1=false;
                }
                if (mat[n-i-1][n-j-1]!=target[i][j]){
                    b2=false;
                }
                if (mat[j][n-i-1]!=target[i][j]){
                    b3=false;
                }
                if (mat[i][j]!=target[i][j]){
                    b4=false;
                }
            }
        }
        return b1 || b2 || b3 || b4;
    }
}
/*public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean b1 = true,b2 = true,b3 = true,b4 = true;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                //旋转90度
                if(mat[n - j - 1][i] != target[i][j]){
                    b1 = false;
                }
                //旋转180度
                if (mat[n - i - 1][n - j - 1] != target[i][j]){
                    b2 = false;
                }
                //旋转270度
                if (mat[j][n- i- 1] != target[i][j]){
                    b3 = false;
                }
                //旋转360度
                if (mat[i][j] != target[i][j]){
                    b4 = false;
                }
            }
        }
        return b1 || b2 || b3 || b4;
    }
*/