package Leetcode;
/*给你一个 n * n 的网格 grid ，上面放置着一些 1 x 1 x 1 的正方体。
每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。
请你返回最终这些形体的总表面积。
注意：每个形体的底面也需要计入表面积中。
*/
/*
输入：grid = [[1,2],[3,4]]
输出：34*/
/**/
public class Test218 {
    public int surfaceArea(int[][] grid) {
        if (grid==null || grid.length<1 || grid[0].length<1) return 0;
        //统计立方体数
        int blocks=0;
        //统计被其他面盖住的面数
        int cover=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                blocks+=grid[i][j];
                cover+=grid[i][j]>1?grid[i][j]-1:0;
                if (i>0){
                    cover+=Math.min(grid[i-1][j],grid[i][j]);
                }
                if (j>0){
                    cover+=Math.min(grid[i][j-1],grid[i][j]);
                }
            }

        }
        //总面数*6-覆盖掉的面数
        return blocks*6-cover*2;
    }
}

/*class Solution {
    public int surfaceArea(int[][] grid) {
        if(grid == null || grid.length < 1 || grid[0].length < 1) return 0;
        //统计所有的立方体数量
        int blocks = 0;
        //统计有多少个面被其他面盖住，那么就在所有的立方体的表面积上减去被盖住的面数×2（因为盖住一个面需要另一个面来盖，所以会损失2个面）；
        int cover = 0;
        for(int i = 0;i < grid.length;++i) {
            for(int j = 0; j < grid[0].length;++j) {
                blocks += grid[i][j];
               //这个是统计当前格子中因为堆叠而盖住了几个面
                cover += grid[i][j] > 1 ? grid[i][j] -1 : 0;
                if(i > 0) {
                    //看看上一行同一列盖住了多少个面
                    cover += Math.min(grid[i-1][j],grid[i][j]);
                }
                if(j > 0) {
                    //看看同一行前一列盖住了几个面
                    cover += Math.min(grid[i][j-1],grid[i][j]);
                }
            }
        }
        return blocks * 6 - cover * 2;
    }
}*/