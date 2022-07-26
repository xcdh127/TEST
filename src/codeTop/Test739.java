package codeTop;

import java.util.Stack;

/*给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
示例 1:
输入: temperatures = [73,74,75,71,69,72,76,73]
输出:[1,1,4,2,1,1,0,0]
示例 2:
输入: temperatures = [30,40,50,60]
输出:[1,1,1,0]
示例 3:
输入: temperatures = [30,60,90]
输出: [1,1,0]
提示：
1 <=temperatures.length <= 105
30 <=temperatures[i]<= 100
*/
public class Test739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        //单调栈
        Stack<Integer> stack=new Stack<>();
        //结果数组
        int[] res=new int[n];
        //遍历数组中的每一个元素
        for (int i = 0; i < n; i++) {
            //当栈不为空，并且栈顶的温度小于当前温度时，弹出栈顶的位置，用当前位置减去栈顶的位置，将栈顶位置需要多久才能到达离他最近的比他温度高的天气
            while (!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                //弹出栈顶的下标
                int index=stack.pop();
                //将相差的天数放到结果位置处
                res[index]=i-index;
            }
            //将当前位置的下标添加到栈中
            stack.push(i);
        }
        //返回结果
        return res;
    }
}
