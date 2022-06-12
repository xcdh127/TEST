package Leetcode;
/*我们定制了一款特殊的键盘，所有的键都 排列在一行上 。
给定一个长度为 26 的字符串 keyboard ，来表示键盘的布局(索引从 0 到 25 )。
一开始，你的手指在索引 0 处。要输入一个字符，你必须把你的手指移动到所需字符的索引处。
手指从索引 i 移动到索引 j 所需要的时间是 |i - j|。
您需要输入一个字符串 word 。写一个函数来计算用一个手指输入需要多少时间。
*/
/*"abcdefghijklmnopqrstuvwxyz"
"cba"*/
public class Test114 {
    public static void main(String[] args) {
        String str1="abcdefghijklmnopqrstuvwxyz";
        String str2="cba";
        System.out.println(calculateTime(str1, str2));
    }
    public static int calculateTime(String keyboard, String word) {
        int[] arr=new int[26];
        //记录下键盘中每一个键的位置
        for (int i = 0; i < keyboard.length(); i++) {
            arr[keyboard.charAt(i)-'a']=i;
        }
        //遍历单词，统计移动的时间
        //首先统计从键盘开始打第一个字符时的所用的时间
        int time=arr[word.charAt(0)-'a'];
        //计算每个字符之间的时间差累加
        for (int i = 1; i < word.length(); i++) {
            time+=Math.abs(arr[word.charAt(i)-'a']-arr[word.charAt(i-1)-'a']);
        }
        //返回总时间
        return time;
    }
}
