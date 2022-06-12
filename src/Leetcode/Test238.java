package Leetcode;

import java.util.ArrayList;
import java.util.List;
/*给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
每次「迁移」操作将会引发下述活动：
位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
请你返回 k 次迁移操作后最终得到的 二维网格。
*/
public class Test238 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        for (int t = 0; t < k; t++) {
            int[][] arr=new int[m][n];
            //迁移第一步
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n - 1; j++) {
                    arr[i][j+1]=grid[i][j];
                }
            }
            //迁移第二步
            for (int i = 0; i < m-1; i++) {
                arr[i+1][0]=grid[i][n-1];
            }
            //迁移第三步
            arr[0][0]=grid[m-1][n-1];

            grid=arr;
        }
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list=new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
            res.add(list);
        }
        return res;
    }
}
/*class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        // Repeat the transform k times.
        for (;k > 0; k--) {
            // We'll write the transform into a new 2D array.
            int[][] newGrid = new int[grid.length][grid[0].length];

            // Case #1: Move everything not in the last column.
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length - 1; col++) {
                    newGrid[row][col + 1] = grid[row][col];
                }
            }

            // Case #2: Move everything in last column, but not last row.
            for (int row = 0; row < grid.length - 1; row++) {
                newGrid[row + 1][0] = grid[row][grid[0].length - 1];
            }

            // Case #3: Move the bottom right.
            newGrid[0][0] = grid[grid.length - 1][grid[0].length - 1];

            // Update grid to be the transformed grid.
            grid = newGrid;
        }

        // Copy the grid into a list for returning.
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> listRow = new ArrayList<>();
            result.add(listRow);
            for (int v : row) listRow.add(v);
        }

        return result;
    }
}
*/