package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*给你一个下标从 0 开始的字符串 words ，其中 words[i] 由小写英文字符组成。
在一步操作中，需要选出任一下标 i ，从 words 中 删除 words[i] 。
其中下标 i 需要同时满足下述两个条件：
0 < i < words.length
words[i - 1] 和 words[i] 是 字母异位词 。
只要可以选出满足条件的下标，就一直执行这个操作。
在执行所有操作后，返回 words 。可以证明，
按任意顺序为每步操作选择下标都会得到相同的结果。
字母异位词 是由重新排列源单词的字母得到的一个新单词，
所有源单词中的字母通常恰好只用一次。例如，"dacb" 是 "abdc" 的一个字母异位词。
*/
public class Test256 {
    public List<String> removeAnagrams(String[] words) {
        int n=words.length;
        List<String> res=new ArrayList<>();
        String prev="";
        for (int i = 0; i < words.length; i++) {
            //将字符串变成字符数组
            char[] ch=words[i].toCharArray();
            Arrays.sort(ch);
            String s=String.valueOf(ch);
            if (s.equals(prev))continue;
            res.add(words[i]);
            //将当前字符串赋值给指向前一个字符串
            prev=s;
        }
        return res;
    }
}


/*class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        String pre = " ";
        for (int i = 0; i < words.length; ++i) {
            char[] cs = words[i].toCharArray();
            Arrays.sort(cs);
            String s = String.valueOf(cs);
            if (i >= 1 && s.equals(pre)) continue;
            ans.add(words[i]);
            pre = s;
        }
        return ans;
    }
}
*/