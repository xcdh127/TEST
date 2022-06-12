package Leetcode;
/*给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
输出: 2
* */
/*三角形的面积S=(x1y2-x1y3+x2y3-x2y1+x3y1-x2y2)。*/
/*1/2[x1(y2-y3)+x2(y3-y1)+x3(y1-y2)]*/
public class Test204 {
    public double largestTriangleArea(int[][] points) {
        int n=points.length;
        double maxArea=0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                //
                for (int k = j+1; k < n; k++) {
                    maxArea=Math.max(getMax(points[i][0],points[i][1],points[j][0],points[j][1],points[k][0],points[k][1]),maxArea);
                }
            }
        }
        return maxArea;
    }

    public double getMax(int x1,int y1,int x2,int y2,int x3,int y3){
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }
}
