package Leetcode;

import java.util.*;

/*我们可以将一个句子表示为一个单词数组，例如，句子 "I am happy with leetcode"
可以表示为 arr = ["I","am",happy","with","leetcode"]
给定两个句子 sentence1 和 sentence2 分别表示为一个字符串数组，
并给定一个字符串对 similarPairs ，其中 similarPairs[i] = [xi, yi] 
表示两个单词 xi and yi 是相似的。
如果 sentence1 和 sentence2 相似则返回 true ，如果不相似则返回 false 。
两个句子是相似的，如果:
它们具有 相同的长度 (即相同的字数)
sentence1[i] 和 sentence2[i] 是相似的
请注意，一个词总是与它自己相似，也请注意，相似关系是不可传递的。
例如，如果单词 a 和 b 是相似的，单词 b 和 c 也是相似的，那么 a 和 c  不一定相似 。
*/
public class Test30 {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        //记录句子1的长度
        int m=sentence1.length;
        //记录句子2的长度
        int n=sentence2.length;
        //如果长度不相同直接返回false
        if (m!=n){
            return false;
        }
        //创建set集合，存放相单词对
        Set<String> set=new HashSet<>();
        //将相似单词对拼接在一起，存放到set中
        for (List<String> list:similarPairs) {
            set.add(list.get(0)+"&"+list.get(1));
        }
        //遍历两个字符串数组
        for (int i = 0; i < n; i++) {
            //当两个句子对应位置上的单词不相等，并且集合set中不包含当前位置两个单词拼接，就返回false
            if (!sentence1[i].equals(sentence2[i]) &&
                    !set.contains(sentence1[i]+"&"+sentence2[i]) &&
                    !set.contains(sentence2[i]+"&"+sentence1[i])){
                return false;
            }
        }
        //句子相似返回true
        return true;
    }
}
