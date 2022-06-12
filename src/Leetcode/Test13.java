package Leetcode;

import java.util.Stack;

/*给定一个整数数组 temperatures 
，表示每天的温度，返回一个数组 answer ，
其中 answer[i] 是指在第 i 天之后，
才会有更高的温度。如果气温在这之后都不会升高，
请在该位置用 0 来代替。
*/
public class Test13 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] res=new int[n];
        //单调栈
        Stack<Integer> stack=new Stack<>();
        //遍历所有的数组中的元素
        for (int i = 0; i < n; i++) {
            //当栈不为空，并且当栈顶的温度值比当前温度低值
            //将当前位置的到达最高温度的位置修改为i-temp
            while (!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                int temp=stack.pop();
                res[temp]=i-temp;
            }
            //将当前位置当进栈中
            stack.push(i);
        }
        //返回到到最高温度的天数的数组
        return res;
    }
}
