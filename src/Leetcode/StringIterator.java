package Leetcode;
/*设计并实现一个迭代压缩字符串的数据结构。给定的压缩字符串的形式是，
每个字母后面紧跟一个正整数，
表示该字母在原始未压缩字符串中出现的次数。
设计一个数据结构，它支持如下两种操作： next 和 hasNext。
next() - 如果原始字符串中仍有未压缩字符，则返回下一个字符，否则返回空格。
hasNext() - 如果原始字符串中存在未压缩的的字母，则返回true，否则返回false。
*/
class StringIterator {
    //待处理的字符串
    String res;
    //当前指向字符串的位置，初始的num值
    int ptr=0,num=0;
    //初始化字符ch
    char ch=' ';
    public StringIterator(String compressedString) {
        res=compressedString;
    }
    public char next() {
        //如果没有下一位字符，则返回空
        if (!hasNext()){
            return ' ';
        }
        //当num==0时，表明此时已经将前一个字符打印完毕
        //开始打印下一个字符，需要取出当前的字符，并且拿到将当前的字符需要重复的次数
        if (num==0){
            //拿到字符
            ch=res.charAt(ptr++);
            //计算出当前字符需要重复的次数
            while (ptr<res.length() && Character.isDigit(res.charAt(ptr))){
                num=num*10+(res.charAt(ptr++)-'0');
            }
        }
        //当字符个数不为0时，将继续输出ch字符
        num--;
        return ch;

    }
    public boolean hasNext() {
        //当前指针没有指到sb字符串的末尾时就表明当前字符还存在未压缩的字符
        return ptr!=res.length() || num!=0;
    }
}
/*
public class StringIterator {
    String res;
    int ptr = 0, num = 0;
    char ch = ' ';
    public StringIterator(String s) {
        res = s;
    }
    public char next() {
        if (!hasNext())
            return ' ';
        if (num == 0) {
            ch = res.charAt(ptr++);
            while (ptr < res.length() && Character.isDigit(res.charAt(ptr))) {
                num = num * 10 + res.charAt(ptr++) - '0';
            }
        }
        num--;
        return ch;
    }
    public boolean hasNext() {
        return ptr != res.length() || num != 0;
    }
}
*/
