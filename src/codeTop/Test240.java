package codeTop;
/*编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
示例 1：
输入：matrix =
[[1,4,7,11,15],
[2,5,8,12,19],
[3,6,9,16,22],
[10,13,14,17,24],
[18,21,23,26,30]], target = 5
输出：true
示例 2：
输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
输出：false
提示：
m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109<= matrix[i][j] <= 109
每行的所有元素从左到右升序排列
每列的所有元素从上到下升序排列
-109<= target <= 109
*/
public class Test240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        //从右上角开始搜索
        int i=0;
        int j=n-1;
        //当没有搜索到左下角时
        while (i<m && j>=0){
            //如果当前位置的值等于target时，说明target在数组中存在
            if (matrix[i][j]==target){
                return true;
            }
            //如果当前值小于目标值，向下搜索目标值
            else if (matrix[i][j] < target) {
                i++;
            }
            //如果当前值大于目标值时，向左搜索目标值
            else if (matrix[i][j]>target) {
                j--;
            }
        }
        return false;
    }
}
