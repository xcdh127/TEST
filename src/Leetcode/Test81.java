package Leetcode;

import java.util.ArrayList;
import java.util.List;

/*给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
返回一个整数数组 answer ，其中 answer.length == s.length
且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
*/
public class Test81 {
    public int[] shortestToChar(String s, char c) {
        //存放所有的值为c的字符在数组中的位置
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==c){
                list.add(i);
            }
        }
        //结果数组
        int[] arr=new int[s.length()];
        //遍历结果数组
        for (int i = 0; i < s.length(); i++) {
            //记录当前位置的最小差值
            int diff=Integer.MAX_VALUE;
            //遍历记录c出现位置的数组
            for (int index :list) {
                diff=Math.min(diff,Math.abs(index-i));
            }
            //记录i位置的结果
            arr[i]=diff;
        }
        //返回
        return arr;
    }
}
