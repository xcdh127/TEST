package codetophuawei;

import java.util.LinkedList;
import java.util.Queue;

/*在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
示例 1：
输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
输出：4
示例 2：
输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
输出：-1
解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
示例 3：
输入：grid = [[0,2]]
输出：0
解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] 仅为 0、1 或 2
*/
public class Test994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //将腐烂的橘子放进队列中
        Queue<int[]> queue = new LinkedList<>();
        //记录好橘子的数量
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //将腐烂的橘子作为基准辐射好橘子
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                //遇到好橘子，记录好橘子的数量
                else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        //方向数组
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        //记录腐败的时间
        int recur = 0;
        //当队列不为空时
        while (!queue.isEmpty()) {
            boolean flag = false;
            //拿到当前层的所有节点
            int size = queue.size();
            //遍历弹出这一层的全部节点
            for (int i = 0; i < size; i++) {
                //待处理的节点
                int[] temp = queue.poll();
                //四周的节点符合条件，就腐败好橘子
                for (int[] dir : dirs) {
                    int row = dir[0] + temp[0];
                    int col = dir[1] + temp[1];
                    if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1) {
                        //辐射坏橘子
                        grid[row][col] = 2;
                        //坏橘子放进队列
                        queue.offer(new int[]{row, col});
                        //好橘子个数-1
                        count--;
                        //有橘子腐烂将标志位更新为true
                        flag = true;
                    }
                }
            }
            //有新橘子腐败，就将时间+1
            if (flag) {
                recur++;
            }
        }
        //如果最后还剩下新橘子就返回-1，否则腐败完毕后就返回腐败的最短用时
        return count > 0 ? -1 : recur;
    }
}


class Solution100 {
    public static int orangesRotting(int[][] grid) {
        int min = 0, count = 0; // 分钟数
        Queue<int[]> queue = new LinkedList<>();// 存储腐烂的橘子
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1) count++;
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            boolean flag = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll(); // 把每一轮腐烂的先遍历掉
                assert point != null;
                int x = point[0], y = point[1];
                // 四个方向遍历开始
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    // 邻居是新鲜的橘子
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2; // 变成腐烂的橘子
                        count--; // 新鲜橘子减一
                        queue.offer(new int[]{nx, ny}); // 放进腐烂的队列
                        flag = true;
                    }
                }
            }
            if (flag) min++;
        }
        return count == 0 ? min : -1;
    }
}