package JianZHiOffer;
/*输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
[[1,2,3],
 [4,5,6],
 [7,8,9]]
示例 2：
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Test29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0){
        return new int[0];
           }
        int m=matrix.length;
        int n=matrix[0].length;

        //顶
        int t=0;
        //底
        int b=m-1;
        //左
        int l=0;
        //右
        int r=n-1;

        int[] res=new int[m*n];
        int index=0;
        while (t<=b && l<=r){
            int i=t;
            int j=l;
            while (t<=b && l<=r && j<=r){
                res[index++]=matrix[i][j++];
            }
            //顶向下缩一行
            t++;
            i=t;
            j=r;
            while (t<=b && l<=r && i<=b){
                res[index++]=matrix[i++][j];
            }
            //右边向左缩一列
            r--;
            i=b;
            j=r;
            while (t<=b && l<=r && j>=l){
                res[index++]=matrix[i][j--];
            }
            //底向上缩一行
            b--;
            i=b;
            j=l;
            while (t<=b && l<=r && i>=t){
                res[index++]=matrix[i--][j];
            }
            l++;
        }
        return res;
    }
}
