package codetophuawei;

import java.util.*;

/*给你一个字符串 s ，请你去除字符串中重复的字母，
使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
示例 1：
输入：s = "bcabc"
输出："abc"
示例 2：
输入：s = "cbacdcbc"
输出："acdb"
提示：
1 <= s.length <= 104
s 由小写英文字母组成
*/
public class Test316 {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        boolean[] isVisited = new boolean[26];
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            //当前字符
            char ch = s.charAt(i);
            //如果栈中没有当前字符
            if (!isVisited[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (arr[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        isVisited[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                isVisited[ch - 'a'] = true;
                sb.append(ch);
            }
            arr[ch - 'a'] -= 1;
        }
        return sb.toString();
    }
}


class Solution82 {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                //字符窜长度大于0，并且当前字符小于字符串的最后一个字符
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    //最后一个字符个数大于0时
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        //标记此位置为没有访问过
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        //删除掉最后一个字符
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                //标记这字符出现过
                vis[ch - 'a'] = true;
                //向字符串中添加此字符
                sb.append(ch);
            }
            //此字符的个数-1
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }
}
