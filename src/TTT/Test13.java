package TTT;

public class Test13 {
    public void rotate(int[][] matrix) {
        //(n-j-1,i)
        int m=matrix.length;
        for (int i = 0; i < m/ 2; i++) {
            for (int j = 0; j < (m+1) / 2; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[m-j-1][i];
                matrix[m-j-1][i]=matrix[m-i-1][m-j-1];
                matrix[m-i-1][m-j-1]=matrix[j][m-i-1];
                matrix[j][m-i-1]=temp;
            }
        }
    }
}
/*输入：matrix =
[[1,2,3],
 [4,5,6],
 [7,8,9]]
输出：
[[7,4,1],
 [8,5,2],
 [9,6,3]]*/