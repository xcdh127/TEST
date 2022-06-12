package Leetcode;
/*给你一个由若干单词组成的句子 sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
例如，单词 "apple" 变为 "applema" 。
如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
例如，单词 "goat" 变为 "oatgma" 。
根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
返回将 sentence 转换为山羊拉丁文后的句子。
*/
public class Test109 {
    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] str = sentence.split(" ");
        //遍历处理数组
        for (int i = 0; i < str.length; i++) {
            sb.append(exeStr(str[i],i)+" ");
        }
        //删除最后的空格
        sb.deleteCharAt(sb.length()-1);
        //输出结果
        return sb.toString();
    }
    //判断是否是元音字母(包括阿大写和小写)
    public boolean isYuanYIin(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O'
                || ch=='U';
    }

    public String exeStr(String s,int index){
        //记录辅音开头的字符
        char ch = ' ';
        //记录辅音
        boolean flag = false;
        StringBuilder sb=new StringBuilder();
        //判断字符串首部的字符是否元音
        for (int j = 0; j < s.length(); j++) {
            //处理字符串的首字符
            if (j==0){
                //如果首字符是辅音字符
                if (!isYuanYIin(s.charAt(j))){
                    ch=s.charAt(j);
                    flag=true;
                }
                //元音字符
                else {
                    sb.append(s.charAt(j));
                }
            }
            else{
                sb.append(s.charAt(j));
            }

        }
        //辅音添加最后首字符
        if (flag){
            sb.append(ch);
        }
        sb.append("ma");
        //添加当前字符串索引+1个a字符
        for (int i=0;i<=index;i++){
            sb.append("a");
        }
        return sb.toString();
    }
}
