package codeTop;
/*在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。
请完成一个高效的函数，输入这样的一个二维数组和一个整数，
判断数组中是否含有该整数。
示例:
现有矩阵 matrix 如下：
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。
给定 target = 20，返回 false。
限制：
0 <= n <= 1000
0 <= m <= 1000
*/
public class TestOffer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //当数组为空，或者数组的长度为0时，返回false
        if (matrix==null || matrix.length==0){
            return false;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        //指向数组的右上角
        int i=0;
        int j=n-1;
        while (i<m && j>=0){
            //当找到target时，返回true
            if (matrix[i][j]==target){
                return true;
            }
            //当前位置的数字小于target时，向下搜索
            else if (matrix[i][j]<target){
                i++;
            }
            //当前位置的数字大于target时，向左搜索
            else {
                j--;
            }
        }
        //没有搜索到
        return false;
    }
}
