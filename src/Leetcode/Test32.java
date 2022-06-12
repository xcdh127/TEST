package Leetcode;

import java.util.HashSet;
import java.util.Set;

/* 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。 stones 
中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
*/
public class Test32 {
    public int numJewelsInStones(String jewels, String stones) {
        char[] ch=jewels.toCharArray();
        int n=ch.length;
        //存放宝石种类
        Set<Character> set=new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(ch[i]);
        }
        char[] ch1=stones.toCharArray();
        int count=0;
        //判断宝石，统计数量
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(ch1[i])){
                count++;
            }
        }
        //返回总数量
        return count;
    }
}
