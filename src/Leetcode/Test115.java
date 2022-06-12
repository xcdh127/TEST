package Leetcode;
/*给你一个字符串 s，返回 只含 单一字母 的子串个数 。*/
public class Test115 {
    public int countLetters(String s) {
        int n=s.length();
        int index=0;
        //计算总次数
        int res=0;
        while (index<n){
            //记录当前连续字符的个数
            int count=0;
            //取出当前字符
            char ch=s.charAt(index);
            //当前字符是ch时，继续将指针向后移动，并且累加连续字符的个数
            while (index<n && ch==s.charAt(index)){
                index++;
                count++;
            }
            //返回此连续字符中可以形成的连续子串的个数
            res+=(count+1)*count/2;
        }
        return res;
        /*int n=s.length();
        //记录所有的只有一种字符的子串
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                //当前子串只有一种字符，计数+1
                if (onlyOne(s.substring(i,j+1))){
                    count++;
                }
            }
        }
        //返回结果
        return count;*/
    }
    /*//判断字符串中是否只有一种字符
    public boolean onlyOne(String s){
        int n=s.length();
        int ch=s.charAt(0);
        int i=0;
        while (i<n && s.charAt(i)==ch){
            i++;
        }
        return i==n;
    }*/
}
