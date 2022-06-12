package Leetcode;
/*给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ，
 [x, y] 表示横坐标为 x、纵坐标为 y 的点。请你来判断，这些点是否在该坐标系中属于同一条直线上。
*/
public class Test236 {
    public boolean checkStraightLine(int[][] coordinates) {
        int n=coordinates.length;
        int dx=coordinates[0][0];
        int dy=coordinates[0][1];
        for (int i = 0; i < n; i++) {
            //将所有的坐标都减去第一个坐标的横纵坐标
            coordinates[i][0]-=dx;
            coordinates[i][1]-=dy;
        }
        //dy1/dx1 == dy2/dx2
        int A=coordinates[1][1];
        int B=-coordinates[1][0];
        for (int i = 2; i <n ; i++) {
            int x=coordinates[i][0];
            int y=coordinates[i][1];
            //如果不等于0，说明没有在同一条直线上
            if (A*x+B*y!=0){
                return false;
            }
        }
        //所有的点都在同一条直线上
        return true;
    }
}

/*class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
        int n = coordinates.length;
        for (int i = 0; i < n; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }
        int A = coordinates[1][1], B = -coordinates[1][0];
        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if (A * x + B * y != 0) {
                return false;
            }
        }
        return true;
    }
}
*/