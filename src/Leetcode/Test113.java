package Leetcode;
/*
给你一个字符串 s ，请你删去其中的所有元音字母 'a'，'e'，'i'，'o'，'u'，并返回这个新字符串。
 */
public class Test113 {
    public String removeVowels(String s) {
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        //遍历字符串中所有的字符
        for (int i = 0; i < n; i++) {
            //当前字符不是要删除的字符时，将当前字符添加到sb中
            if (!toDelete(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        //返回结果
        return sb.toString();
    }
    //当前字符是元音字母时，删除这些字符
    public boolean toDelete(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}
