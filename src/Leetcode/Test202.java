package Leetcode;

import java.util.Arrays;

/*在 n x n 的网格 grid 中，我们放置了一些与 x，y，z 三轴对齐的 1 x 1 x 1 立方体。
每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
现在，我们查看这些立方体在 xy 、yz 和 zx 平面上的投影。
投影 就像影子，将 三维 形体映射到一个 二维 平面上。从顶部、前面和侧面看立方体时，我们会看到“影子”。
返回 所有三个投影的总面积 。
*/
/*输入：[[1,2],[3,4]]
输出：17
解释：这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。*/
/*
[[1,2],[3,4]]
[[2]]
[[1,0],[0,2]]*/
public class Test202 {
    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,0},{0,2}};
        System.out.println(projectionArea(arr));
    }
    public static int projectionArea(int[][] grid) {
        int n=grid.length;
        int[] row=new int[n];
        int[] col=new int[n];
        int count=0;
        Arrays.fill(row,Integer.MIN_VALUE);
        Arrays.fill(row,Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //当前位置上有物品，俯视图面积+1
                if (grid[i][j]!=0){
                    count++;
                }
                //统计每一行的最大值
                row[i]=Math.max(row[i],grid[i][j]);
                //统计每一列的最大值
                col[j]=Math.max(col[j],grid[i][j]);
            }
        }
        //累加每一行，每一列的最大值
        for (int i = 0; i < n; i++) {
            count+=row[i];
            count+=col[i];
        }
        return count;
    }
}
