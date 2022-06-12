package Leetcode;

import java.util.HashSet;
import java.util.Set;

/*给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。
如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
请你返回 words 数组中 一致字符串 的数目。
*/
public class Test129 {
    public int countConsistentStrings(String allowed, String[] words) {
        //存放可以使用的字符
        Set<Character> set=new HashSet<>();
        int n=allowed.length();
        for (int i = 0; i < n; i++) {
            set.add(allowed.charAt(i));
        }
        //记录符合条件的字符串
        int count=0;
        for (int i = 0; i < words.length; i++) {
            //打标记，记录非法字符
            boolean flag=true;
            //拿到当前字符串
            String s=words[i];
            for (int j = 0; j < s.length(); j++) {
                //当前字符非法，跳出，并打标记
                if (!set.contains(s.charAt(j))){
                    flag=false;
                    break;
                }
            }
            //合法计数
            if (flag)count++;
        }
        //返回计数
        return count;
    }
}
