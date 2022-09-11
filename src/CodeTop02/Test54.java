package CodeTop02;

import java.util.ArrayList;
import java.util.List;

/*给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/
public class Test54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int t = 0;
        int b = m - 1;
        int l = 0;
        int r = n - 1;
        int i = t;
        int j = l;
        while (l <= r && t <= b) {
            while (l <= r && t <= b && j <= r) {
                res.add(matrix[i][j++]);
            }
            t++;
            i = t;
            j = r;
            while (l <= r && t <= b && i <= b) {
                res.add(matrix[i++][j]);
            }
            r--;
            i = b;
            j = r;
            while (l <= r && t <= b && j >= l) {
                res.add(matrix[i][j--]);
            }
            b--;
            i = b;
            j = l;
            while (l <= r && t <= b && i >= t) {
                res.add(matrix[i--][j]);
            }
            l++;
            i = t;
            j = l;
        }
        return res;
    }
}
