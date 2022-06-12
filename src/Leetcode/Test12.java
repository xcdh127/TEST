package Leetcode;
/*给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
回文字符串 是正着读和倒过来读一样的字符串。
子字符串 是字符串中的由连续字符组成的一个序列。
具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
*/
public class Test12 {
    public int countSubstrings(String s) {
        int n=s.length();
        //统计回文的总个数
        int count=0;
        //从字符串的始末位置开始统计形成回文的个数
        //形成回文的个数有两种方式：
        //（1）奇数长度的回文(此时中心字符就是s(i),s(i+1))
        //（2）偶数长度的回文(此时中心字符就是s(i))
        for (int i = 0; i < n; i++) {
            count+=countHuiWen(s,i,i);
            count+=countHuiWen(s,i,i+1);
        }
        //最后返回总的回文个数
        return count;
    }
    //函数的作用就是将从中间向两边开始统计回文个数
    public int countHuiWen(String s,int start,int end){
        //字符串的长度
        int n=s.length();
        //记录形成回文的个数
        int count=0;
        //从字符start和end开始统计回文的个数
        //当start和end位置的字符和end位置的字符是相同的，就将start向前移动
        //将end位置向后移动，并且此处记录一下形成回文的个数
        while(start>=0 && end<n && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
            count++;
        }
        //返回次轮形成回文的个数
        return count;
    }
}
