package codeTop;
/*给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
示例 1：
输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,4,7,5,3,6,8,9]
示例 2：
输入：mat = [[1,2],[3,4]]
输出：[1,2,3,4]
提示：
m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
-105 <= mat[i][j] <= 105
*/
public class Test498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        //结果数组
        int[] res=new int[m*n];
        int index=0;
        //遍历方向标记
        boolean flag=true;
        //遍历所有行列之和i（0～m+n）
        for (int i = 0; i < m + n; i++) {
            //行的上限
            int pm=flag?m:n;
            //列的上限
            int pn=flag?n:m;
            //x没有到达上限就是i，到了上限就是pm-1
            int x=i<pm?i:pm-1;
            //y取i-x
            int y=i-x;
            //当没有到达数组边界时
            while (x>=0 && y<pn){
                //将数组对应的位置放进res中
                res[index++]=flag?mat[x][y]:mat[y][x];
                x--;
                y++;
            }
            //反转遍历方向
            flag=!flag;
        }
        //返回结果
        return res;
    }
}
class Solution5 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[] res=new int[m*n];
        int index=0;
        boolean flag=true;
//每一趟的和i
        for(int i=0;i<m+n;i++){
//根据标记flag确定x与y的上限
            int pm=flag?m:n;
            int pn=flag?n:m;
//起始坐标
            int x=i<pm?i:pm-1;
            int y=i-x;
//一趟结束的条件
            while(x>=0 && y<pn){
                res[index++]=flag?mat[x][y]:mat[y][x];
                x--;
                y++;
            }
            flag=!flag;
        }
        return res;
    }
}