package codetophuawei;

import java.util.Stack;

/*给定一个整数数组 asteroids，表示在同一行的行星。
对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。
每一颗行星以相同的速度移动。
找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。
两颗移动方向相同的行星，永远不会发生碰撞。
示例 1：
输入：asteroids = [5,10,-5]
输出：[5,10]
解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
示例 2：
输入：asteroids = [8,-8]
输出：[]
解释：8 和 -8 碰撞后，两者都发生爆炸。
示例 3：
输入：asteroids = [10,2,-5]
输出：[10]
解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
提示：
2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
*/
public class Test735 {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            //当栈不为空，并且栈顶元素是向右运动的，并且此时栈顶行星小于向左飞行的行星时，弹出栈顶元素
            //就是向右飞行的行星被撞击坏了
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroids[i]) {
                stack.pop();
            }
            //当栈顶不为空，并且栈顶元素大于0，向右运动的行星等于向左运动的行星时，将向右运动的行星删除
            if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() == -asteroids[i]) {
                stack.pop();
            }
            //入栈情况，当栈为空，或者 栈顶的行星是向左运动的，或者 当前行星是向右运行的，直接将行星放进栈中
            else if (stack.isEmpty() || stack.peek() < 0 || asteroids[i] > 0) {
                stack.push(asteroids[i]);
            }
        }
        //将栈中还存在的元素输出成数组
        return stack.stream().mapToInt(i -> i).toArray();
    }
}

class Solution85 {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<Integer>();
        for (int num : asteroids) {

            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -num) {

                stack.pop();

            }

            if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() == -num) {

                stack.pop();
            } else if (stack.isEmpty() || stack.peek() < 0 || num > 0) {

                stack.push(num);
            }

        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
