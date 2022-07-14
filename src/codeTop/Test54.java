package codeTop;

import java.util.ArrayList;
import java.util.List;

/*给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2:
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
        int m=matrix.length;
        int n=matrix[0].length;
        //定义上下左右边界
        int t=0;
        int b=m-1;
        int l=0;
        int r=n-1;
        //定义初始位置
        int i=t;
        int j=l;
        //存放结果
        List<Integer> list=new ArrayList<>();
        //当左右边界和上下边界没有接触时
        while (l<=r && t<=b){
            //从左向右
            while (l<=r && t<=b && j<=r){
                list.add(matrix[i][j++]);
            }
            t++;
            i=t;
            j=r;
            //从上至下
            while (l<=r && t<=b && i<=b){
                list.add(matrix[i++][j]);
            }
            r--;
            i=b;
            j=r;
            //从右向左
            while (l<=r && t<=b && j>=l){
                list.add(matrix[i][j--]);
            }
            b--;
            i=b;
            j=l;
            //从下至上
            while (l<=r && t<=b && i>=t){
                list.add(matrix[i--][j]);
            }
            l++;
            i=t;
            j=l;
        }
        //返回结果
        return list;
    }
}
