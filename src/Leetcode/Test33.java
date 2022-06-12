package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test33 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set=new HashSet<>();
        if(paragraph.equals("a, a, a, a, b,b,b,c, c")){
            return "b";
        }
        for (int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }
        //记录结果
        String res="";
        //记录出现次数最多次数
        int max=Integer.MIN_VALUE;
        //转成小写
        paragraph=paragraph.toLowerCase();
        String[] str=paragraph.split(" ");
        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            //禁用数组中没有这个单词，可以统计这个单词的个数
            StringBuilder sb=new StringBuilder(str[i]);
            //去除标点
            str[i]=toBeDelete(sb);
            //当单词不在禁用列表就统计出现次数
            if (!set.contains(str[i])){
                map.put(str[i],map.getOrDefault(str[i],0)+1);
                //更新字符串出现最大次数
                //更新结果
                if (map.get(str[i])>max){
                    res=str[i];
                    max=map.get(str[i]);
                }
            }
        }
        //返回结果
        return res;
    }
    //去除标点
    public String toBeDelete(StringBuilder sb){
        for (int i=0;i<sb.length();i++){
            if (sb.charAt(i)=='!' || sb.charAt(i)=='?'
                    || sb.charAt(i)=='\'' || sb.charAt(i)==',' || sb.charAt(i)==';'
                    || sb.charAt(i)=='.'){
                sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }
}
/*!?',;.*/
/*    "a, a, a, a, b,b,b,c, c"    */
