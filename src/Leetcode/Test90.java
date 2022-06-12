package Leetcode;
/*小扣在秋日市集发现了一款速算机器人。
店家对机器人说出两个数字（记作 x 和 y），请小扣说出计算指令：
"A" 运算：使 x = 2 * x + y；
"B" 运算：使 y = 2 * y + x。
在本次游戏中，店家说出的数字为 x = 1 和 y = 0，
小扣说出的计算指令记作仅由大写字母 A、B 组成的字符串 s，
字符串中字符的顺序表示计算顺序，请返回最终 x 与 y 的和为多少。
*/
public class Test90 {
    public int calculate(String s) {
        int len=s.length();
        int x=1;
        int y=0;
        //遍历所有字符，按照规则进行运算
        for (int i = 0; i < len; i++) {
            if (s.charAt(i)=='A'){
                x=2*x+y;
            }
            else {
                y=2*y+x;
            }
        }
        //返回两数之和
        return x+y;
    }
}
