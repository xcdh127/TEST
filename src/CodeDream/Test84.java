package CodeDream;

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
public class Test84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        //栈底放置元素-1
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            //当栈顶元素不为空，并且当前元素的高度小于栈顶元素时，弹出栈顶元素
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                int temp = stack.pop();
                //高度
                int hight = heights[temp];
                //宽度：当前位置的下标-弹出位置的下标-1
                int width = i - stack.peek() - 1;
                //面积
                int area = hight * width;
                //记录最大面积
                maxArea = Math.max(area, maxArea);
            }
            //将栈中的位置添加到栈中
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int temp = stack.pop();
            //高度
            int hight = heights[temp];
            //宽度：数字的长度-弹出位置的下标-1
            int width = n - stack.peek() - 1;
            //面积
            int area = hight * width;
            //记录最大面积
            maxArea = Math.max(area, maxArea);
        }
        //返回最大值
        return maxArea;
    }
}

class Solution31 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                int temp = stack.pop();
                int high = heights[temp];
                int width = i - stack.peek() - 1;
                int area = high * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int temp = stack.pop();
            int high = heights[temp];
            int width = n - stack.peek() - 1;
            int area = high * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
