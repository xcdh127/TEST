package Leetcode;
/*给定一个包含小写英文字母的字符串 s 以及一个矩阵 shift，
其中 shift[i] = [direction, amount]：
direction 可以为 0 （表示左移）或 1 （表示右移）。
amount 表示 s 左右移的位数。
左移 1 位表示移除 s 的第一个字符，并将该字符插入到 s 的结尾。
类似地，右移 1 位表示移除 s 的最后一个字符，并将该字符插入到 s 的开头。
对这个字符串进行所有操作后，返回最终结果。
*/
/*输入：s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
输出："efgabcd"
解释：
[1,1] 表示右移 1 位。 "abcdefg" -> "gabcdef"
[1,1] 表示右移 1 位。 "gabcdef" -> "fgabcde"
[0,2] 表示左移 2 位。 "fgabcde" -> "abcdefg"
[1,3] 表示右移 3 位。 "abcdefg" -> "efgabcd"
*/
public class Test122 {

    public String stringShift(String s, int[][] shift) {
        int n=s.length();
        StringBuilder sb=new StringBuilder(s);
        int count=0;
        for (int i = 0; i < shift.length; i++) {
            //对字符串长度求余数得到实际移动的位数
            count=shift[i][1]%n;
            //左移字符串
            if (shift[i][0]==0 && shift[i][1]>0){
                //从count到字符串末尾的字符+从开头到count-1的子字符串
                sb=new StringBuilder(sb.substring(count)+sb.substring(0,count));
            }
            //右移字符串
            else {
                //从n-count位置的字符串开始到末尾的字符+从开头到n-count-1位置的子字符串
                sb=new StringBuilder(sb.substring(n-count)+sb.substring(0,n-count));
            }
        }
        return sb.toString();
    }

}
/*class Solution {
    public String stringShift(String s, int[][] shift) {
        int n = s.length();
        int count = 0;
        for(int i = 0;i < shift.length;++i){
            count = shift[i][1] % n;
            if(shift[i][0] == 0 && shift[i][1] > 0){
               s = s.substring(count)+ s.substring(0,count);
            }else{
                s = s.substring(n - count) + s.substring(0,n - count);
            }

        }
        return s;
    }
}
*/