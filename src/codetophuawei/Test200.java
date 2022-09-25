package codetophuawei;

import java.util.LinkedList;
import java.util.Queue;

/*给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
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
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] isVisited = new boolean[m][n];
        //遍历所有位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //注意是字符1，符合开始搜索的条件时，开始搜索
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    //广度优先搜索
                    bfs(grid, i, j, isVisited);
                    //计数+1
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int i, int j, boolean[][] isVisited) {
        int m = grid.length;
        int n = grid[0].length;
        //队列放数组
        Queue<int[]> queue = new LinkedList<>();
        //方向数组
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        queue.offer(new int[]{i, j});
        //这个位置已经遍历过
        isVisited[i][j] = true;
        while (!queue.isEmpty()) {
            //弹出此时要处理的位置
            int[] temp = queue.poll();
            //遍历这个位置的四周
            for (int[] dir : dirs) {
                //行
                int row = temp[0] + dir[0];
                //列
                int col = temp[1] + dir[1];
                //行列在数组范围内并且这个位置没有访问过，并且这个值为1
                if (row >= 0 && row < m && col >= 0 && col < n && !isVisited[row][col] && grid[row][col] == '1') {
                    //将新位置放进队列中
                    queue.offer(new int[]{row, col});
                    //当前位置已经遍历
                    isVisited[row][col] = true;
                }
            }
        }
    }
}

class Solution80 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j] && grid[i][j] == '1') {
                    recur(grid, isVisited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void recur(char[][] grid, boolean[][] isVisited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        //将坐标(i,j)放进队列中
        queue.offer(new int[]{i, j});
        isVisited[i][j] = true;
        while (!queue.isEmpty()) {
            //从队列中弹出数组
            int[] temp = queue.poll();
            //遍历二维数组
            for (int[] dir : dirs) {
                //行
                int row = dir[0] + temp[0];
                //列
                int col = dir[1] + temp[1];
                //行大于等于0，列小于m ，并且当前位置没有搜索到，并且当前位置为1
                if (row >= 0 && row < m && col >= 0 && col < n && !isVisited[row][col] && grid[row][col] == '1') {
                    //将当前位置放进队列中
                    queue.offer(new int[]{row, col});
                    //标记当前位置为已遍历过
                    isVisited[row][col] = true;
                }
            }
        }
    }
}
