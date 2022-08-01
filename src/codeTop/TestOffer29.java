package codeTop;

/*输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
限制：
0 <= matrix.length <= 100
0 <= matrix[i].length <= 100
*/
public class TestOffer29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int index = 0;
        //上边界
        int t = 0;
        //下边界
        int b = m - 1;
        //左边界
        int l = 0;
        //右边界
        int r = n - 1;
        while (t <= b && l <= r) {
            //左上角
            int i = t;
            int j = l;
            while (t <= b && l <= r && j <= r) {
                res[index++] = matrix[i][j++];
            }
            t++;
            //右上角
            i = t;
            j = r;
            while (t <= b && l <= r && i <= b) {
                res[index++] = matrix[i++][j];
            }
            r--;
            //右下角
            i = b;
            j = r;
            while (t <= b && l <= r && j >= l) {
                res[index++] = matrix[i][j--];
            }
            b--;
            //左下角
            i = b;
            j = l;
            while (t <= b && l <= r && i >= t) {
                res[index++] = matrix[i--][j];
            }
            l++;
        }
        //返回结果res
        return res;
    }
}
