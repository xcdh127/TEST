package Leetcode;
/*给你一个字符串 sequence ，
如果字符串 word 连续重复 k 次形成的字符串是 sequence 的一个子字符串，
那么单词 word 的 重复值为 k 。单词 word 的 最大重复值 是单词 word 
在 sequence 中最大的重复值。如果 word 不是 sequence 的子串，那么重复值 k 为 0 。
给你一个字符串 sequence 和 word ，请你返回 最大重复值 k 。
*/
public class Test127 {
    public int maxRepeating(String sequence, String word) {
        //记录将字符串word重复的次数
        int count=0;
        //将word保存在temp
        String temp=word;
        //当字符串word长度小于等于sequence的长度时
        while (word.length()<=sequence.length()){
            //判断sequence中是否包含此时拼接的word
            if (sequence.contains(word)){
                count++;
            }
            //继续拼接
            word=word+temp;
        }
        //返回重复次数
        return count;
    }
}
