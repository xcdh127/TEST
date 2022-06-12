package Leetcode;
/*给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有 非空子字符串 中找出 值最大的奇数 ，
并以字符串形式返回。如果不存在奇数，则返回一个空字符串 "" 。
子字符串 是字符串中的一个连续的字符序列。
*/
/*输入：num = "35427"
输出："35427"
解释："35427" 本身就是一个奇数。*/
public class Test145 {
    public String largestOddNumber(String num) {
        int n=num.length();
        //从最后一个字符开始判断是否是奇数
        int index=n-1;
        //当指针没有指向字符串的首位置时，将字符串的从头开始截取，此时就是最大的奇数
        while (index>=0){
            if (index>=0 && num.charAt(index)%2==1){
                return num.substring(0,index+1);
            }
            //指针向前指向
            index--;
        }
        //没有奇数位置，返回空字符串
        return "";
    }
}
