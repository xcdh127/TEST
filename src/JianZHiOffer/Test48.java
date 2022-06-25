package JianZHiOffer;

import java.util.Stack;

public class Test48 {
    public int largestRectangleArea(int[] heights) {
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
    }
}
