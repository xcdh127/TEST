package HOT100;

import java.util.ArrayList;
import java.util.List;
/*给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
示例 1:
输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 示例 2:
输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
提示:
1 <= s.length, p.length <= 3 * 104
s 和 p 仅包含小写字母
*/
public class Test438 {
    public List<Integer> findAnagrams(String s, String p) {
        int lenS=s.length();
        int lenP=p.length();
        List<Integer> res=new ArrayList<>();
        if (lenP>lenS){
            return res;
        }
        int[] arr=new int[26];
        for (int i = 0; i < lenP; i++) {
            arr[s.charAt(i)-'a']++;
            arr[p.charAt(i)-'a']--;
        }
        if (allZero(arr)){
            res.add(0);
        }
        for (int i = lenP; i < lenS ; i++) {
            arr[s.charAt(i)-'a']++;
            arr[s.charAt(i-lenP)-'a']--;
            if (allZero(arr)){
                res.add(i-lenP+1);
            }
        }
        return res;
    }
    public boolean allZero(int[] arr){
        for (int num : arr) {
            if (num!=0){
                return false;
            }
        }
        return true;
    }
}

/*class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        int m=s.length();
        int n=p.length();
        if(n>m){
            return list;
        }
        //存放26个字母出现的次数
        int[] arr=new int[26];
        //遍历p字符串的长度
        for(int i=0;i<n;i++){
            arr[s.charAt(i)-'a']++;
            arr[p.charAt(i)-'a']--;
        }
        //遍历完字符串p之后，如果数组中的字母个数都为0，就说明0位置开始是异位词
        if(isAllZero(arr)){
            list.add(0);
        }
        //s字符串进入窗口的部分+1，滑出窗口的部分-1
        for(int i=n;i<m;i++){
            arr[s.charAt(i-n)-'a']--;
            arr[s.charAt(i)-'a']++;
            if(isAllZero(arr)){
                list.add(i-n+1);
            }
        }
        return list;
    }
    public boolean isAllZero(int[] arr){
        for(int num : arr){
            if(num!=0){
                return false;
            }
        }
        return true;
    }
}*/