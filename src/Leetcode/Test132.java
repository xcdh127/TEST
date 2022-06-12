package Leetcode;
/*给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
两个字符串 相似 的前提是它们都含有相同数目的元音
（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
如果 a 和 b 相似，返回 true ；否则，返回 false 。
*/
public class Test132{
    public boolean halvesAreAlike(String s) {
        int n=s.length();
        //对半拆分
        int lenBan=n/2;
        int countPrev=0;
        int countLast=0;
        //分别统计两个字符串中的元音
        for (int i = 0; i < lenBan; i++) {
            if (isYuanYin(s.charAt(i))){
                countPrev++;
            }
        }
        for (int i = lenBan; i < n; i++) {
            if (isYuanYin(s.charAt(i))){
                countLast++;
            }
        }
        return countLast==countPrev;
    }
    //判断元音
    public boolean isYuanYin(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A'
                || ch=='E' || ch=='I' || ch=='O' || ch=='U';
    }
}
