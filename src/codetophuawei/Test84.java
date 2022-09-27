package codetophuawei;

import java.util.Stack;

/*给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
示例 1:
输入：heights = [2,1,5,6,2,3]
输出：10
解释：最大的矩形为图中红色区域，面积为 10
示例 2
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
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            //当栈顶元素不为-1了，并且栈顶元素的高度大于等于当前元素的高度时
            //维系单调递增的栈结构
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                //弹出栈顶元素
                int temp = stack.pop();
                //取出弹出栈的高度
                int high = heights[temp];
                //计算两个柱子之间的宽度
                int width = i - stack.peek() - 1;
                //计算围成的面积
                int area = high * width;
                //记录最大的面积
                maxArea = Math.max(maxArea, area);
            }
            //当栈为空或者是栈顶的元素高度小于当前元素的高度，维系单调递增的栈结构
            stack.push(i);
        }
        //遍历完数组之后，如果栈顶元素不为-1，继续处理栈中的元素
        while (stack.peek() != -1) {
            //弹出栈顶元素的位置
            int temp = stack.pop();
            //获取栈顶元素的高度
            int high = heights[temp];
            //计算两个柱子之间的宽度
            int width = n - stack.peek() - 1;
            //计算面积
            int area = high * width;
            //记录最大面积
            maxArea = Math.max(maxArea, area);
        }
        //返回最大值
        return maxArea;
    }
}


class Solution109 {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);

        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {

            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {

                int temp = stack.pop();
                int high = heights[temp];
                int length = i - stack.peek() - 1;
                int area = high * length;
                maxArea = Math.max(area, maxArea);
            }

            stack.push(i);
        }

        while (stack.peek() != -1) {

            int temp = stack.pop();
            int high = heights[temp];
            int length = n - stack.peek() - 1;
            int area = high * length;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;

    }
}