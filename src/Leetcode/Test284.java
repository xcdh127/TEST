package Leetcode;
/*一个整数 num 的 k 美丽值定义为 num 中符合以下条件的 子字符串 数目：
子字符串长度为 k 。
子字符串能整除 num 。
给你整数 num 和 k ，请你返回 num 的 k 美丽值。
注意：
允许有 前缀 0 。
0 不能整除任何值。
一个 子字符串 是一个字符串里的连续一段字符序列。
示例 1：
输入：num = 240, k = 2
输出：2
解释：以下是 num 里长度为 k 的子字符串：
- "240" 中的 "24" ：24 能整除 240 。
- "240" 中的 "40" ：40 能整除 240 。
所以，k 美丽值为 2 。
*/
public class Test284 {
    public static void main(String[] args) {
        System.out.println(divisorSubstrings(240, 2));
    }
    public static int divisorSubstrings(int num, int k) {
       String numStr=String.valueOf(num);
       int count=0;
        for (int i = 0; i <=numStr.length()-k; i++) {
            String sub=numStr.substring(i,i+k);
            Integer n = Integer.valueOf(sub);
            if (n!=0 && num%n==0){
                count++;
            }
        }
        return count;
    }
}
