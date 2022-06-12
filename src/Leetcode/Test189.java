package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*在 MATLAB 中，有一个非常有用的函数 reshape ，
它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
给你一个由二维数组 mat 表示的 m x n 矩阵，
以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
*/
/*
输入：mat = [[1,2],[3,4]], r = 2, c = 4
输出：[[1,2],[3,4]]*/
public class Test189 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] res=new int[r][c];
        //两个数组中的元素个数不相，返回原数组
        if (m*n!=r*c){
            return mat;
        }
        //存放原数组的所有数字
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(mat[i][j]);
            }
        }
        //指向链表当前数字的指针
        int index=0;
        //遍历链表，将数字放进结果数组中
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j]=list.get(index++);
            }
        }
        return res;
    }
}
