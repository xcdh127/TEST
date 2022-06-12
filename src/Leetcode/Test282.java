package Leetcode;
/*一次 位翻转 定义为将数字 x 二进制中的一个位进行 翻转 操作，即将 0 变成 1 ，或者将 1 变成 0 。
比方说，x = 7 ，二进制表示为 111 ，我们可以选择任意一个位（包含没有显示的前导 0 ）
并进行翻转。比方说我们可以翻转最右边一位得到 110 ，或者翻转右边起第二位得到 101 ，
或者翻转右边起第五位（这一位是前导 0 ）得到 10111 等等。
给你两个整数 start 和 goal ，请你返回将 start 转变成 goal 的 最少位翻转 次数。
示例 1：
输入：start = 10, goal = 7
输出：3
解释：10 和 7 的二进制表示分别为 1010 和 0111 。我们可以通过 3 步将 10 转变成 7 ：
- 翻转右边起第一位得到：1010 -> 1011 。
- 翻转右边起第三位：1011 -> 1111 。
- 翻转右边起第四位：1111 -> 0111 。
我们无法在 3 步内将 10 转变成 7 。所以我们返回 3 。
*/
public class Test282 {
    public static void main(String[] args) {
        System.out.println(minBitFlips(81, 87));
    }
    public static int minBitFlips(int start, int goal) {
        String s = Integer.toBinaryString(start);
        String s1 = Integer.toBinaryString(goal);
        System.out.println(s+" "+s1);
        int indexS=s.length()-1;
        int indedS1=s1.length()-1;
        int count=0;
        while (indexS>=0 && indedS1>=0){
            if (s.charAt(indexS--)!=s1.charAt(indedS1--)){
                count++;
            }
        }
        while (indexS>=0){
            if (s.charAt(indexS--)=='1'){
                count++;
            }
        }
        while (indedS1>=0){
            if (s1.charAt(indedS1--)=='1'){
                count++;
            }
        }
        return count;
    }
}
