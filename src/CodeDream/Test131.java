package CodeDream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
回文串 是正着读和反着读都一样的字符串。
示例 1：
输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 2：
输入：s = "a"
输出：[["a"]]
提示：
1 <= s.length <= 16
s 仅由小写英文字母组成
*/
public class Test131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        LinkedList<String> subset = new LinkedList<>();
        recur(res, s, 0, subset);
        return res;
    }

    public void recur(List<List<String>> res, String s, int index, LinkedList<String> subset) {
        //当指针指向字符串的末尾时
        if (index == s.length()) {
            //向结果集中添加子集
            res.add(new LinkedList<>(subset));
            return;
        }
        //从index开始向后遍历字符串
        for (int i = index; i < s.length(); i++) {
            //如果从index开始到i+1结束的字符串是回文字符串时
            if (isHuiWen(s.substring(index, i + 1))) {
                //将此回文字符串放进子集中
                subset.addLast(s.substring(index, i + 1));
                //遍历字符串的i+1位置
                recur(res, s, i + 1, subset);
                //移除最后放进子集的回文串
                subset.removeLast();
            }
        }
    }

    //判断是否是回文
    public boolean isHuiWen(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

class Solution9 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        LinkedList<String> subset = new LinkedList<String>();
        recur(res, s, 0, subset);
        return res;
    }

    public void recur(List<List<String>> res, String s, int index, LinkedList<String> subset) {
        if (index == s.length()) {
            res.add(new LinkedList<String>(subset));
            return;
        }

        if (index < s.length()) {
            for (int i = index; i < s.length(); i++) {
                if (isHuiWen(s.substring(index, i + 1))) {
                    subset.add(s.substring(index, i + 1));
                    recur(res, s, i + 1, subset);
                    subset.removeLast();
                }
            }
        }
    }

    public boolean isHuiWen(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}