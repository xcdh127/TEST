package Leetcode;
/*给你一个大小为 rows x cols 的矩阵 mat，
其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），
则位置 (i, j) 被称为特殊位置。
*/
public class Test246 {
    public int numSpecial(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //等前数字是1时，并且这行与列的数字都是0
                //count++
                if (mat[i][j]==1 && valid(mat,i,j)){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean valid(int[][] mat,int i,int j){
        //检查同一列
        for (int k = i+1; k <mat.length ; k++) {
            if (mat[k][j]!=0){
                return false;
            }
        }
        //检查同一列
        for (int k = 0; k <i; k++) {
            if (mat[k][j]!=0){
                return false;
            }
        }
        //检查同一行
        for (int k = 0; k <j ; k++) {
            if (mat[i][k]!=0){
                return false;
            }
        }
        //检查同一行
        for (int k = j+1; k <mat[0].length ; k++) {
            if (mat[i][k]!=0){
                return false;
            }
        }
        return true;
    }
}
