package Leetcode;
/*对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，
我们才认定 “t 能除尽 s”。
给定两个字符串 str1 和 str2 。
返回 最长字符串 x，要求满足 x 能除尽 str1 且 X 能除尽 str2 。
*/
/*输入：str1 = "ABCABC", str2 = "ABC"
输出："ABC"

输入：str1 = "ABABAB", str2 = "ABAB"
输出："AB"
示例 3：

输入：str1 = "LEET", str2 = "CODE"
输出：""

*/
public class Test112 {
    public static void main(String[] args) {
        String str1="ABCABC";
        String str2="ABC";
        System.out.println(gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        //如果两个字符串一前一后，一后一前相互拼接后，是不相同的说明这两个字符串中是没有公共子集的
        //直接返回空字符串
        if (!str1.concat(str2).equals(str2.concat(str1))){
            return "";
        }
        //获取两个字符串的长度
        int m=str1.length();
        int n=str2.length();
        //获取两个字符串长度的最大公约数
        int maxGYS=gcd(m,n);
        //截取出从最大公约数长度的字符串
        return str1.substring(0,maxGYS);
    }
    //计算两个数字的最大公约数
    public static int gcd(int a,int b){
        return a==0?b:gcd(b%a,a);
    }
}

/*class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }
}
*/
