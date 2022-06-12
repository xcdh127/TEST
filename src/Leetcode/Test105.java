package Leetcode;
/*
字符串可以用 缩写 进行表示，缩写 的方法是将任意数量的
不相邻 的子字符串替换为相应子串的长度。
例如，字符串 "substitution" 可以缩写为（不止这几种方法）：
"s10n" ("s ubstitutio n")
"sub4u4" ("sub stit u tion")
"12" ("substitution")
"su3i1u2on" ("su bst i t u ti on")
"substitution" (没有替换子字符串)
下列是不合法的缩写：
"s55n" ("s ubsti tutio n"，两处缩写相邻)
"s010n" (缩写存在前导零)
"s0ubstitution" (缩写是一个空字符串)
给你一个字符串单词 word 和一个缩写 abbr ，判断这个缩写是否可以是给定单词的缩写。
子字符串是字符串中连续的非空字符序列。
*/
public class Test105 {
    public static void main(String[] args) {
        String word="internationalization";
        String abbr="i12iz4n";
        System.out.println(validWordAbbreviation(word, abbr));


    }

    /*
"internationalization"
"i12iz4n"*/
    public static boolean validWordAbbreviation(String word, String abbr) {
        int len=word.length();
        //当缩写字符第一个0时，直接返回false
        if (abbr.charAt(0)=='0'){
            return false;
        }
        //指向word开头
        int i=0;
        //指向abbr开头
        int j=0;
        while (i<len && j<abbr.length()){
            //如果abbr当前字符是字母，判断当前字母是不是对应相等
            if (Character.isLetter(abbr.charAt(j))){
                if (word.charAt(i)!=abbr.charAt(j)){
                    return false;
                }
                //两个指针向后指向一位
                i++;
                j++;
            }
            //如果abbr当前字符是数字
            else if(Character.isDigit(abbr.charAt(j))){
                //开头数字的字符，如果是0直接返回false
                char ch=abbr.charAt(j);
                if (ch=='0'){
                    return false;
                }
                //记录此时省略的字符个数
                int num=0;
                //当前字符是数字时，就继续拼接数字
                while (j<abbr.length() && Character.isDigit(abbr.charAt(j))){
                    num=num*10+(abbr.charAt(j)-'0');
                    j++;
                }
                //此时j已经指向下一个字符
                //将i指针向后指num个位置
                i+=num;
            }
        }
        //如果所有的字符都对应相等就返回true
        //当两个指针同时指向字符串的末尾时，才返回true
        if (i==len && j==abbr.length()){
            return true;
        }
        //否则返回false
        return false;
    }

}
