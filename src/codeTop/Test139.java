package codeTop;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
示例 2：
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     注意，你可以重复使用字典中的单词。
示例 3：
输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
提示：
1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s 和 wordDict[i] 仅有小写英文字母组成
wordDict 中的所有字符串 互不相同
*/
public class Test139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        Set<String> set=new HashSet<>(wordDict);
        boolean[] dp=new boolean[n+1];
        //空字符串可以通过字典中的字符拼接出来
        dp[0]=true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                //截取出子字符串(j,i)
                String sub=s.substring(j,i);
                //如果字典中包含当前截取出的子字符串，并且dp[j]为true（字符串前j位置的字符可以通过字典拼接出来）
                if (set.contains(sub) && dp[j]){
                    //这样字符串前i位置也可以通过字典中的字符拼接出来
                    dp[i]=true;
                }
            }
        }
        //返回长度为n的字符串，能否由字典中的字符串拼接出来
        return dp[n];
    }
}
class Solution7 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <i ; j++) {
                String sub=s.substring(j,i);
                if (set.contains(sub) && dp[j]){
                    dp[i]=true;
                }
            }
        }
        return dp[n];
    }
}
