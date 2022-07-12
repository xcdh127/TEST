package codeTop;

import java.util.LinkedList;
import java.util.Queue;

/*给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
示例 1：
输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1
示例 2：
输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] 的值为 '0' 或 '1'
*/
public class Test200 {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        //记录当前位置是否遍历过
        boolean[][] isVisited=new boolean[m][n];
        //记录岛屿个数
        int count=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //当前位置没有遍历过，并且当前位置上的字符是'1'，进行广度优先搜索
                //记录能都进行广度优先搜索的次数
                if (!isVisited[i][j] && grid[i][j]=='1'){
                    recur(grid,i,j,isVisited);
                    count++;
                }
            }
        }
        return count;
    }

    public void recur(char[][] grid,int i,int j,boolean[][] isVisited){
        int m=grid.length;
        int n=grid[0].length;
        //当前位置的周围四个方向
        int[][] dirs=new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        //广度优先搜索使用队列
        Queue<int[]> queue=new LinkedList<>();
        //将i，j位置上的元素添加到队列
        queue.offer(new int[]{i,j});
        //标记此位置遍历过
        isVisited[i][j]=true;
        //当队列不为空时
        while (!queue.isEmpty()){
            //弹出队列顶部元素
            int[] temp=queue.poll();
            //遍历当前位置的四周
            for (int[] dir:dirs) {
                //行
                int row=dir[0]+temp[0];
                //列
                int col=dir[1]+temp[1];
                //当行大于等于0，并且小于m，列大于等于0，并且小于n，并且此位置没有遍历过，并且当前位置的字符是'1'
                //将当前位置的元素放进队列，并且标记已经遍历过
                if (row>=0 && row<m && col>=0 && col<n && !isVisited[row][col] && grid[row][col]=='1'){
                    queue.offer(new int[]{row,col});
                    isVisited[row][col]=true;
                }
            }
        }
    }
}
