package Leetcode;
/*给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，
计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
子字符串 是字符串中的一个连续字符序列。
*/
public class Test83 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n=s.length();
        //初始化结果为-1
        int res=-1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                //当两个字符相等时，返回两个字符之间的距离，取最大
                if (s.charAt(i)==s.charAt(j)){
                    res=Math.max(res,j-i-1);
                }
            }
        }
        //根据res正负输出
        return res<0?-1:res;
    }
}
