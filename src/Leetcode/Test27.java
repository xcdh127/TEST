package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*给定两个字符串 s 和 t ，它们只包含小写字母。
字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
请找出在 t 中被添加的字母。*/
public class Test27 {
    public char findTheDifference(String s, String t) {
        int m=s.length();
        int n=t.length();
        Map<Character,Integer> map=new HashMap<>();
        //将t中的字符以及出现的次数放进map中
        for (int i=0;i<n;i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        for (int i=0;i<m;i++){
            //如果字符串s中的字符在字符串t中出现就是将这个字符从map中的个数-1
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                //如果map中这个字符出现的次数是0次就将这个键从map中删除
                if (map.get(s.charAt(i))==0){
                    map.remove(s.charAt(i));
                }
            }
        }
        //遍历map，最后剩下的就是多出来的那个字符
        for (Map.Entry<Character,Integer> entry:map.entrySet()){
            return entry.getKey();
        }
        return ' ';
    }
}
