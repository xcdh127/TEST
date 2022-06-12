package Leetcode;
/*一个字符串的所有字符都是一样的，被称作等值字符串。
举例，"1111" 和 "33" 就是等值字符串。
相比之下，"123"就不是等值字符串。
规则：给出一个数字字符串s，将字符串分解成一些等值字符串，
如果有且仅有一个等值子字符串长度为2，其他的等值子字符串的长度都是3.
如果能够按照上面的规则分解字符串s，就返回真，否则返回假。
子串就是原字符串中连续的字符序列。
*/
/*输入: s = "000111000"
输出: false
解释:  s只能被分解长度为3的等值子字符串。
输入: s = "00011111222"
输出: true
解释: s 能被分解为 ["000","111","11","222"].
输入: s = "01110002223300"
输出: false
解释: 一个不能被分解的原因是在开头有一个0.
*/
public class Test146 {
    public static void main(String[] args) {
        System.out.println(isDecomposable("66666666666677722"));
    }
    public static boolean isDecomposable(String s) {
        int i=0;
        int two=0;
        while (i<s.length()){
            //从i的下一个位置开始遍历字符串，查看字符是否相等，相等的话就向后指向
            int j=i+1;
            while (j<s.length() && s.charAt(j)==s.charAt(i)){
                j++;
            }
            //此时相同的字符的个数是1
            if ((j-i)%3==1){
                return false;
            }
            //当此时字符串余数为2时，统计连续个数为2的字符串
            if ((j-i)%3==2){
                two++;
            }
            //i指向j的位置
            i=j;
        }
        return two==1;
    }

}
/*class Solution {
    public boolean isDecomposable(String s) {
        int i = 0, two = 0;
        while (i < s.length()) {
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) j++;
            if ((j - i) % 3 == 1) return false;
            if ((j - i) % 3 == 2) two++;
            i = j;
        }
        return two == 1;
    }
}
*/