package codetophuawei;

/*给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
示例 1：
输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
输出：4
解释：最长递增路径为 [1, 2, 6, 9]。
示例 2：
输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
输出：4
解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
示例 3：
输入：matrix = [[1]]
输出：1
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1
*/
public class Test329 {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxLen = 0;
        int[][] length = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, recur(matrix, i, j, length));
            }
        }
        //返回最大长度
        return maxLen;
    }

    public int recur(int[][] matrix, int i, int j, int[][] length) {
        //如果（i，j）位置上的数字大于0，说明此位置遍历过，直接返回路径长度
        if (length[i][j] > 0) {
            return length[i][j];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        //初始化路径长度为1
        int path = 1;
        for (int[] dir : dirs) {
            int row = dir[0] + i;
            int col = dir[1] + j;
            //坐标不越界，新坐标值大于原坐标值
            if (row >= 0 && row < m && col >= 0 && col < n && matrix[row][col] > matrix[i][j]) {
                //深度优先搜索，获取路径长度
                int len = recur(matrix, row, col, length);
                //更新最大长度
                if (len + 1 > path) {
                    path = len + 1;
                }
            }
        }
        //将路径长度记录下来，避免重复搜索
        length[i][j] = path;
        //返回最大长度
        return path;
    }
}


class Solution117 {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxLen = 0;
        int[][] lenth = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //递归出此位置的连续数组的长度
                int len = recur(matrix, lenth, i, j);
                //找出最大的maxLen
                maxLen = Math.max(maxLen, len);
            }
        }
        //返回最大长度
        return maxLen;
    }

    public int recur(int[][] matrix, int[][] length, int i, int j) {
        //当记录长度的矩阵大于0时
        if (length[i][j] > 0) {
            return length[i][j];
        }
        //长度m
        int m = matrix.length;
        //宽度n
        int n = matrix[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //初始化path为1
        int path = 1;
        //遍历(i,j)位置周围的四个位置
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            //新位置在矩阵内部，并且新位置的值大于(i,j)位置的值
            if (row >= 0 && row < m && col >= 0 && col < n && matrix[row][col] > matrix[i][j]) {
                //递归遍历(row,col)位置开始递增数组的长度len
                int len = recur(matrix, length, row, col);
                //如果path的长度小于len+1时，将len+1赋值给path
                if (path < len + 1) {
                    path = len + 1;
                }
            }
        }
        //当记录最长路径的数组，更新(i,j)位置，length[i][j]=path
        length[i][j] = path;
        //返回最长递增路径的长度
        return length[i][j];
    }
}