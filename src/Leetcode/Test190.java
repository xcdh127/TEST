package Leetcode;
/*有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。
你也被给予三个整数 sr ,  sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行 上色填充 。
为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上
 像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应
 四个方向上 像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为 newColor 。
最后返回 经过上色渲染后的图像 。
*/
/*输入: image =
[[1,1,1],
 [1,1,0],
 [1,0,1]]，sr = 1, sc = 1, newColor = 2
输出:
[[2,2,2],
 [2,2,0],
 [2,0,1]]
解析: 在图像的正中间，(坐标(sr,sc)=(1,1)),在路径上所有符合条件的像素点的颜色都被更改成2。
注意，右下角的像素没有更改为2，因为它不是在上下左右四个方向上与初始点相连的像素点。
*/
public class Test190 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m=image.length;
        int n=image[0].length;
        boolean[][] isVisited=new boolean[m][n];
        recur(image,sr,sc,image[sr][sc],newColor,isVisited);
        return image;

    }

    public void recur(int[][] image,int i,int j,int orColor,int newColor,boolean[][] isVisited){
        //拿到图像的长宽
        int m=image.length;
        int n=image[0].length;
        //四个搜索方向
        int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        //当坐标不在矩阵内，或者这个位置上的颜色与初始颜色不同，或者这个位置已经搜索过
        //直接返回
        if (i<0 || i>=m || j<0 || j>=n || image[i][j]!=orColor || isVisited[i][j]){
            return;
        }
        //当这个位置在矩阵内，并且这个颜色与原始颜色相同，修改为新颜色
        if (i>=0 && i<m && j>=0 && j<n && image[i][j]==orColor){
            image[i][j]=newColor;
        }
        //将这个位置标记为已经访问过
        isVisited[i][j]=true;
        //遍历这个位置的上下左右四个相邻位置
        for (int[] dir :dirs) {
            int row=dir[0]+i;
            int col=dir[1]+j;
            //继续搜索相邻位置的颜色情况
            recur(image,row,col,orColor,newColor,isVisited);
        }
    }

}
