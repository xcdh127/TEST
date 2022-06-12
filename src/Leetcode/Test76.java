package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
*/
public class Test76 {
    public String reverseVowels(String s) {
        //用于拼接字符串
        StringBuilder sb=new StringBuilder();
        //将元音字母存放到list中
        int n=s.length();
        List<Character> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //如果当前字符是元音字母，就将当前字符添加到元音数组中
            if (isYuanYin(s.charAt(i))){
                list.add(s.charAt(i));
            }
        }
        //将字符串中的元音字符反转
        //指向元音数组的指针
        int index=0;
        Collections.reverse(list);
        for (int i = 0; i < n; i++) {
            //当前字符是元音辞字符时
            //将当前元音数组指向的字符放进sb中
            if (isYuanYin(s.charAt(i))){
                sb.append(list.get(index++));
            }
            //如果当前字符是非元音字符就将这个字符放进sb中
            else{
                sb.append(s.charAt(i));
            }
        }
        //返回字符串
        return sb.toString();
    }
    //判断当前字符是不是元音字符
    public boolean isYuanYin(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E'
                || c=='I' || c=='O' || c=='U';
    }
}
