package CodeDream;

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
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        //空字符串可以通过字典中的字符串拼接形成
        dp[0] = true;
        //外层循环遍历数组
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                //取出当前字串
                String substring = s.substring(j, i);
                //如果字典中存在当前子字符串，并且字符串从下标0开始到j结尾都存在于字典中
                //那么字符串从0开始到i结束的位置都存在于字典中
                if (set.contains(substring) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        //返回长度为n的字符串可以用字典中的字母拼接而成
        return dp[n];
    }
}
