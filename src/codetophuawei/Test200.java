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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //注意是字符1
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    bfs(grid, i, j, isVisited);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int i, int j, boolean[][] isVisited) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        queue.offer(new int[]{i, j});
        isVisited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int[] dir : dirs) {
                int row = temp[0] + dir[0];
                int col = temp[1] + dir[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !isVisited[row][col] && grid[row][col] == '1') {
                    queue.offer(new int[]{row, col});
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
