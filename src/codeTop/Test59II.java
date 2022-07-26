package codeTop;
/*给你一个正整数n ，生成一个包含 1 到n2所有元素，且元素按顺时针顺序螺旋排列的n x n 正方形矩阵 matrix 。
示例 1：
输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
示例 2：
输入：n = 1
输出：[[1]]
提示：
1 <= n <= 20
*/
public class Test59II {
    public int[][] generateMatrix(int n) {
        //存放结果的数组
        int[][] res=new int[n][n];
        //从1开始
        int index=1;
        //上边界
        int t=0;
        //下边界
        int b=n-1;
        //左边界
        int l=0;
        //右边界
        int r=n-1;
        while (t<=b && l<=r){
            //左上角
            int i=t;
            int j=l;
            while (j<=r && t<=b && l<=r){
                res[i][j++]=index++;
            }
            t++;
            //右上脚
            i=t;
            j=r;
            while (i<=b && t<=b && l<=r){
                res[i++][j]=index++;
            }
            r--;
            //右下脚
            i=b;
            j=r;
            while (j>=l && t<=b && l<=r){
                res[i][j--]=index++;
            }
            b--;
            //左下角
            i=b;
            j=l;
            while (i>=t && t<=b && l<=r){
                res[i--][j]=index++;
            }
            l++;
        }
        return res;
    }
}
