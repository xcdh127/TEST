package Leetcode;

import java.util.HashSet;
import java.util.Set;

/*给你一个字符串 word ，该字符串由数字和小写英文字母组成。
请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34"
将会变成 " 123  34 8  34" 。注意，剩下的这些整数为
（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
返回对 word 完成替换后形成的 不同 整数的数目。
只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
*/
public class Test138 {
    public int numDifferentIntegers(String word) {
        int n=word.length();
        //指向当前数字的位置
        int index=0;
        //记录不同的数字
        Set<String> set=new HashSet<>();
        //当指针没有到达字符串的末尾时，继续向后遍历
        while (index<n){
            //如果当前字符是数字时
            char ch=word.charAt(index);
            //记录下当前字符的位置
            int start=index;
            //如果当前字符是数字
            if (Character.isDigit(ch)){
                //当没有到达字符串的末尾时，并且当前字符是数字时，就继续向后遍历字符串
                while (index<n && Character.isDigit(word.charAt(index))){
                    index++;
                }
                //处理字符串,将字符串中的前导0去掉
                StringBuilder toEdit=new StringBuilder(word.substring(start,index));
                //当前字符串的长度大于1，并且字符串的首位是0
                //此时将前导0删除
                while (toEdit.length()>1 && toEdit.charAt(0)=='0'){
                    toEdit.deleteCharAt(0);
                }
                //当删除后的字符串长度大于0时，将字符串添加到结果集中
                if (toEdit.length()>0){
                    //将数字截取出来放进集合中
                    set.add(toEdit.toString());
                }
            }
            //如果不是数字就向后遍历字符串
            else {
                index++;
            }
        }
        //返回结果的大小
        return set.size();
    }
}
