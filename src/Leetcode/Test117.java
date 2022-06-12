package Leetcode;
/*
给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。
我们希望按下述规则将 s 映射为一些小写英文字符：
字符（'a' - 'i'）分别用（'1' - '9'）表示。
字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
返回映射之后形成的新字符串。
题目数据保证映射始终唯一。
*/   //abcdefghijk
/*
输入：s = "10#11#12"
输出："jkab"
解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2"
输入：s = "1326#"
输出："acz"
*/
public class Test117 {
    public static void main(String[] args) {
        System.out.println(freqAlphabets("10#11#12"));
    }
    public static String freqAlphabets(String s) {
        //当前字符串长度
        int n=s.length();
        //指向字符串的末尾
        int index=n-1;
        //拼接字符串
        StringBuilder sb=new StringBuilder();
        while (index>=0){
            char ch=s.charAt(index);
            //当前字符是数字，将字符a加上此数字-1得到对应字符，指针向前指向
            if (Character.isDigit(ch)){
                sb.append((char)('a'+(ch-'0')-1));
                index--;
            }
            //当前字符是#，一定是两位数字，截取出数字，字符a加上num-1得到对应字符，指针指向前指向3位
            else {
                int num=Integer.parseInt(s.substring(index-2,index));
                sb.append((char)('a'+num-1));
                index-=3;
            }
        }
        //反转字符串
        sb.reverse();
        //删除字符串
        return sb.toString();
    }
}
