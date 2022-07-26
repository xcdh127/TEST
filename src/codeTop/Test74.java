package codeTop;
/*编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1：
输入：matrix =
[[1,3,5,7],
[10,11,16,20],
[23,30,34,60]], target = 3
输出：true
示例 2：
输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
输出：false
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
*/
public class Test74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        //从右上角搜索到左下角
        int i=m-1;
        int j=0;
        while (i>=0 && j<n){
            //当前值等于目标值target时
            if (target==matrix[i][j]){
                return true;
            }
            //当前值大于目标值时，向左搜索
            else if (matrix[i][j] > target) {
                i--;
            }
            //当前值小于目标值时，向下搜索
            else if (matrix[i][j] < target) {
                j++;
            }
        }
        //返回没有搜索到
        return false;
    }
}
