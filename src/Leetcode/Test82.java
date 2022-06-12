package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*给定一个字符串 s，统计并返回具有相同数量 0 和 1 的非空
（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
重复出现（不同位置）的子串也要统计它们出现的次数。
*/
public class Test82 {
    public int countBinarySubstrings(String s) {
        //记录当前字符串中的连续字符的个数
        List<Integer> counts=new ArrayList<>();
        //头指针
        int ptr=0;
        int n=s.length();
        //当没有遍历到字符串的最后时
        while (ptr<n){
            //ptr处的字符
            char c=s.charAt(ptr);
            //统计相同的连续字符的数量
            int count=0;
            //当指针没有到字符的末尾，并且指针处的值是字符c时
            //指针向后指向，并且计数+1
            while (ptr<n && s.charAt(ptr)==c){
                ++ptr;
                ++count;
            }
            //将当前连续字符出现次数放进counts数组中
            counts.add(count);
        }
        //记录结果
        int res=0;
        //相邻的两个连续个数取取小累加
        //从第二位开始向后遍历，连续字符次数数组
        for (int i = 1; i < counts.size(); i++) {
            res+=Math.min(counts.get(i),counts.get(i-1));
        }
        //返回结果
        return res;
    }
}

/*class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<Integer>();
        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }
}
*/
