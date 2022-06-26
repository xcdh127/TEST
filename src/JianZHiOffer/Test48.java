package JianZHiOffer;

import java.util.Stack;
/*给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
示例 1:
输入：heights = [2,1,5,6,2,3]
输出：10
解释：最大的矩形为图中红色区域，面积为 10
示例 2：
输入： heights = [2,4]
输出： 4
提示：
1 <= heights.length <=105
0 <= heights[i] <= 104
*/
public class Test48 {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int maxArea=0;
        for (int i = 0; i < n; i++) {
            //当栈不为空，并且栈顶元素高度大于当前元素高度时，弹出栈顶元素，并计算最大面积
            while (stack.peek()!=-1 && heights[stack.peek()]>heights[i]){
                int temp=stack.pop();
                int high=heights[temp];
                int width=i-stack.peek()-1;
                int area=high*width;
                maxArea=Math.max(maxArea,area);
            }
            stack.push(i);
        }
        //当栈不为空时，返回最大面积
        while (stack.peek()!=-1){
            int temp=stack.pop();
            int high=heights[temp];
            int width=n-stack.peek()-1;
            int area=high*width;
            maxArea=Math.max(maxArea,area);
        }
        //返回最大面积
        return maxArea;
    }
}

/*    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int maxArea=0;
        for(int i=0;i<n;i++){
            while(stack.peek()!=-1 && heights[stack.peek()]>heights[i]){
                int temp=stack.pop();
                int high=heights[temp];
                int width=i-stack.peek()-1;
                int area=high*width;
                maxArea=Math.max(maxArea,area);
            }
            stack.push(i);
        }
        while(stack.peek()!=-1){
            int temp=stack.pop();
            int high=heights[temp];
            int width=n-stack.peek()-1;
            int area=high*width;
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }*/