package Leetcode;
/*给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。
一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，
那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
返回使 s 变成 交替字符串 所需的 最少 操作数。
*/
public class Test134 {
    public int minOperations(String s) {
        //记录当前下标位置与当前字符的奇偶性相同的个数
        int count0=0;
        //记录当前下标位置与当前字符的奇偶性不相同的个数
        int count1=0;
        //遍历字符串统计
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)%2==i%2){
                count0++;
            }
            else {
                count1++;
            }
        }
        return Math.min(count0,count1);
    }
}
/*class Solution {
public:
    int minOperations(string s) {
        int count1 = 0 , count2 = 0 ;
        for ( int i = 0 ; i < s.size() ; i ++ )
        {
            if ( s[i] % 2 == i % 2 )
            {
                count1 ++ ;
            }
            else
            {
                count2 ++ ;
            }
        }
        return min( count1 , count2 ) ;
    }
};
*/