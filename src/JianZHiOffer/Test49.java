package JianZHiOffer;

import java.util.Stack;

/*给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
示例 1：
输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
输出：6
解释：最大矩形如上图所示。
示例 2：
输入：matrix = []
输出：0
示例 3：
输入：matrix = [["0"]]
输出：0
示例 4：
输入：matrix = [["1"]]
输出：1
示例 5：
输入：matrix = [["0","0"]]
输出：0
提示：
rows == matrix.length
cols == matrix[0].length
1 <= row, cols <= 200
matrix[i][j] 为 '0' 或 '1'
*/
/*[
["1","0","1","0","0"],
["1","0","1","1","1"],
["1","1","1","1","1"],
["1","0","0","1","0"]]*/
public class Test49 {
    public int maximalRectangle(char[][] matrix) {
         int m=matrix.length;
         int n=matrix[0].length;
         int[] hight=new int[n];
         int maxArea=0;
        for (char[] mat: matrix) {
            for (int i = 0; i < mat.length; i++) {
                if (mat[i]=='0'){
                    hight[i]=0;
                }
                else {
                    hight[i]+=1;
                }
            }
            maxArea=Math.max(maxArea,getMax(hight));
        }
        return maxArea;
    }

    public int getMax(int[] hight){
        int n=hight.length;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int maxArea=0;
        for (int i = 0; i < n; i++) {
             while (stack.peek()!=-1 && hight[stack.peek()]>hight[i]){
                 int temp=stack.pop();
                 int high=hight[temp];
                 int width=i-stack.peek()-1;
                 int area=high*width;
                 maxArea=Math.max(area,maxArea);
             }
             //将当前下标放进栈中
             stack.push(i);
        }
        while (stack.peek()!=-1){
            int temp=stack.pop();
            int high=hight[temp];
            int width=n-stack.peek()-1;
            int area=high*width;
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
}

/*class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[] arr=new int[n];
        int maxArea=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    arr[j]+=1;
                }
                else{
                    arr[j]=0;
                }
            }
            int area=getArea(arr);
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }

    public int getArea(int[] height){
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int n=height.length;
        int maxArea=0;
        for(int i=0;i<n;i++){
            while(stack.peek()!=-1 && height[stack.peek()]>height[i]){
                int temp=stack.pop();
                int high=height[temp];
                int width=i-stack.peek()-1;
                int area=width*high;
                maxArea=Math.max(area,maxArea);
            }
            stack.push(i);
        }
        while(stack.peek()!=-1){
            int temp=stack.pop();
            int high=height[temp];
            int width=n-stack.peek()-1;
            int area=width*high;
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
}*/
