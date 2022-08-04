package CodeDream;

/*给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
示例 1
输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
示例 2：
输入：n = 1
输出：[[1]]
提示：
1 <= n <= 20
*/
public class Test59 {
    public int[][] generateMatrix(int n) {
        int index = 1;
        int[][] res = new int[n][n];
        //左
        int l = 0;
        //右
        int r = n - 1;
        //上
        int t = 0;
        //下
        int b = n - 1;
        while (l <= r && t <= b) {
            //左上
            int i = t;
            int j = l;
            while (l <= r && t <= b && j <= r) {
                res[i][j++] = index++;
            }
            t++;
            //右上
            i = t;
            j = r;
            while (l <= r && t <= b && i <= b) {
                res[i++][j] = index++;
            }
            r--;
            //右下
            i = b;
            j = r;
            while (l <= r && t <= b && j >= l) {
                res[i][j--] = index++;
            }
            b--;
            //左下
            i = b;
            j = l;
            while (l <= r && t <= b && i >= t) {
                res[i--][j] = index++;
            }
            l++;
        }
        return res;
    }
}