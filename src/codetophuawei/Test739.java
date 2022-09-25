package codetophuawei;

import java.util.Stack;

/*给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，
下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
示例 1:
输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]
示例 2:
输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]
示例 3:
输入: temperatures = [30,60,90]
输出: [1,1,0]
提示：
1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
*/
public class Test739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            //当栈不为空 或者 栈顶温度 小于 当前温度时
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                //弹出当前坐标
                int temp = stack.pop();
                res[temp] = i - temp;
            }
            //将当前下标放进栈中
            stack.push(i);
        }
        //返回结果
        return res;
    }
}
