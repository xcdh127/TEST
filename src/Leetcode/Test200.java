package Leetcode;
/*给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。

矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。*/

import java.util.ArrayList;
import java.util.List;

/*输入：matrix =
[[1,2,3],
 [4,5,6],
 [7,8,9]]
输出：
[[1,4,7],
 [2,5,8],
 [3,6,9]]*/

/*输入：matrix =
[[1,2,3],
 [4,5,6]]
输出：
[[1,4],
 [2,5],
 [3,6]]*/
public class Test200 {
    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,2,3},{4,5,6}};
        System.out.println(transpose(arr));
    }
    public static int[][] transpose(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        //新建一个二维数组，以原数组的列数为行数
        //以原数组的行数为列数
        int[][] arr=new int[n][m];
        //记录新数组的行下标
        int row=0;
        for (int j = 0; j < n ;j++) {
            //记录新数组的列下标
            int col=0;
            for (int i = 0; i < m; i++) {
                //按照列遍历原数数组，放进新数组中按照行存放
                //存放完之后，将列值+1
                arr[row][col++]=matrix[i][j];
            }
            //存放完此列之后，将继续行值row+1
            row++;
        }
        //返回新数组
        return arr;
    }
}
