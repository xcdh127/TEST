package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*给定一个字符串数组
wordDict 和两个已经存在于该数组中的不同的字符串 word1 和 word2 。
返回列表中这两个单词之间的最短距离。*/
public class Test85 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int n=wordsDict.length;
        //list1存放在wordsDict中出现的word1的次数
        List<Integer> list1=new ArrayList<>();
        //list2存放在wordsDict中出现的word2的次数
        List<Integer> list2=new ArrayList<>();
        for (int i = 0; i <n; i++) {
            if (wordsDict[i].equals(word1)) {
                list1.add(i);
            }
            else if (wordsDict[i].equals(word2)){
                list2.add(i);
            }
        }
        //对两个字符出现的次数排序
        Collections.sort(list1);
        Collections.sort(list2);
        //记录最小的差值
        int minDiff=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        while (i<list1.size() && j<list2.size()){
            if (Math.abs(list1.get(i)-list2.get(j))<=minDiff){
                minDiff=Math.min(minDiff,Math.abs(list1.get(i)-list2.get(j)));
                j++;
            }
            else {
                i++;
            }
        }
        return minDiff;
    }
}
