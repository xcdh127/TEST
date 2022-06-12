package Leetcode;
/*给你一个字符串数组 words（下标 从 0 开始 计数）。
在一步操作中，需先选出两个 不同 下标 i 和 j，其中 words[i] 是一个非空字符串，
接着将 words[i] 中的 任一 字符移动到 words[j] 中的 任一 位置上。
如果执行任意步操作可以使 words 中的每个字符串都相等，返回 true ；否则，返回 false 。
*/
/*输入：words = ["abc","aabc","bc"]
输出：true
解释：将 words[1] 中的第一个 'a' 移动到 words[2] 的最前面。
使 words[1] = "abc" 且 words[2] = "abc" 。
所有字符串都等于 "abc" ，所以返回 true 。
*/
public class Test144 {
    public boolean makeEqual(String[] words) {
        int[] arr=new int[26];
        //统计所有不同的字符串中字符出现的次数
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                arr[words[i].charAt(j)-'a']++;
            }
        }
        //遍历字符串中的每一个字符出现的次数，如果不能够被长度整除就说明这个字符不能平均分配给各个字符串
        //返回false
        for (int num :arr) {
            if (num%words.length!=0){
                return false;
            }
        }
        //如果都能够平均分配，返回true
        return true;
    }
}
/*class Solution {
    public boolean makeEqual(String[] words) {
        int[] count=new int[26];
        for(String word:words){for(int i=0;i<word.length();i++){count[word.charAt(i)-'a']++;}}
        for(int c:count){if(c%words.length!=0){return false;}}
        return true;
    }
}*/