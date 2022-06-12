package Leetcode;
/*有一个特殊打字机，它由一个 圆盘 和一个 指针 组成， 圆盘上标有小写英文字母 'a' 到 'z'。
只有 当指针指向某个字母时，它才能被键入。指针 初始时 指向字符 'a' 。
每一秒钟，你可以执行以下操作之一：

将指针 顺时针 或者 逆时针 移动一个字符。
键入指针 当前 指向的字符。
给你一个字符串 word ，请你返回键入 word 所表示单词的 最少 秒数 。
*/
/*输入：word = "abc"
输出：5
解释：
单词按如下操作键入：
- 花 1 秒键入字符 'a' in 1 ，因为指针初始指向 'a' ，故不需移动指针。
- 花 1 秒将指针顺时针移到 'b' 。
- 花 1 秒键入字符 'b' 。
- 花 1 秒将指针顺时针移到 'c' 。
- 花 1 秒键入字符 'c' 。
*/
public class Test151 {
    public int minTimeToType(String word) {
        int[] arr=new int[26];
        //记录总的移动次数
        int count=0;
        //记录前一个字符
        count=Math.min(Math.abs(26-Math.abs(97-word.charAt(0))),Math.abs(97-word.charAt(0)))+1;
        for (int i = 1; i < word.length(); i++) {
            //统计相邻两个字母之间的距离
            int temp=Math.abs(word.charAt(i-1)-word.charAt(i));
            //判断是顺时针，还是逆时针旋转，然后在加一卜打印操作
            count+=Math.min(26-temp,temp)+1;
        }
        //返回结果
        return count;
    }
}

/*
class Solution {
    public int minTimeToType(String word) {
        byte[] bytes = word.getBytes();
        int seconds = Math.min(26 - Math.abs(97 - bytes[0]), Math.abs(97 - bytes[0])) + 1;
        for (int i = 1; i < bytes.length; i++) {
            int tmp = Math.abs(bytes[i - 1] - bytes[i]);
            seconds += Math.min(26 - tmp, tmp) + 1;
        }
        return seconds;
    }
}*/
