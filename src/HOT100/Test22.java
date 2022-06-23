package HOT100;
/*给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[[7,4,1],[8,5,2],[9,6,3]]
示例 2：
输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
提示：
n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
*/
public class Test22 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp=matrix[i][j];
                //套旋转公式：(i,j)->(n-j-1,i)
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=temp;
            }
        }
    }
}
/*class Solution {
 public void rotate(int[][] matrix) {
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
}*/
