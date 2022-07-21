package codeTop;

import java.util.LinkedList;
import java.util.Queue;

/*给你一个大小为 m x n 的二进制矩阵 grid 。
岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
岛屿的面积是岛上值为 1 的单元格的数目。
计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
示例 1：
输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
输出：6
解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
示例 2：
输入：grid = [[0,0,0,0,0,0,0,0]]
输出：0
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] 为 0 或 1
*/
public class Test695 {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int res=0;
        //记录访问与否的数组
        boolean[][] isVisited=new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //当前位置的值为1，并且当前位置没有访问到时
                if (grid[i][j]==1 && !isVisited[i][j]){
                    //获取所有的面积中，面积最大的面积
                    res=Math.max(res,recur(grid,i,j,isVisited));
                }
            }
        }
        //返回结果
        return res;
    }
    public int recur(int[][] grid,int i,int j,boolean[][] isVisited){
        int m=grid.length;
        int n=grid[0].length;
        //队列，存放数组位置
        Queue<int[]> queue=new LinkedList<>();
        //将要访问的前节点的四个方向
        int[][] dirs=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        //记录这一层的面积
        int res=0;
        //将当前位置放进队列中
        queue.offer(new int[]{i,j});
        //标记当前位置已经搜索过
        isVisited[i][j]=true;
        //当队列不为空时
        while (!queue.isEmpty()){
            //弹出队列首部的数组位置
            int[] temp=queue.poll();
            //元素个数+1
            res++;
            //遍历当前位置的四个方向
            for (int[] dir :dirs) {
                //行
                int row=temp[0]+dir[0];
                //列
                int col=temp[1]+dir[1];
                //当行和列都在矩阵内部，并且当前位置没有访问过，并且当前位置值为1
                if (row>=0 && row<m && col>=0 && col<n && !isVisited[row][col] && grid[row][col]==1){
                    //将当前位置添加到队列中
                    queue.offer(new int[]{row,col});
                    //将当前位置标记为已经访问过
                    isVisited[row][col]=true;
                }
            }
        }
        //返回这个区间的面积
        return res;
    }
}

/*class Solution {
public int maxAreaOfIsland(int[][] grid) {
int m=grid.length;
int n=grid[0].length;
int maxArea=0;
boolean[][] isVisited=new boolean[m][n] ;
for(int i=0;i<m;i++){
for(int j=0;j<n;j++){
if(!isVisited[i][j] && grid[i][j]==1){
int area=getArea(grid,isVisited,i,j);
maxArea=Math.max(maxArea,area);
}
}
}
return maxArea;
}
public int getArea(int[][] grid,boolean[][] isVisited,int i,int j){
int m=grid.length;
int n=grid[0].length;
Queue<int[]> queue=new LinkedList<int[]>();
queue.offer(new int[]{i,j});
isVisited[i][j]=true;
int res=0;
int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
while(!queue.isEmpty()){
res++;
int[] temp=queue.poll();
for(int[] dir : dirs){
int row=temp[0]+dir[0];
int col=temp[1]+dir[1];
if(row>=0 && row<m && col>=0 && col<n && !isVisited[row][col] && grid[row][col]==1){

queue.offer(new int[]{row,col});
isVisited[row][col]=true;
}
}
}
return res;
}
}*/
