package codetophuawei;

import java.util.ArrayList;
import java.util.List;

/*正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例 1：
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：
输入：n = 1
输出：["()"]
提示：
1 <= n <= 8
*/
public class Testoffer85 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recur(n, n, res, "");
        return res;
    }

    public void recur(int left, int right, List<String> res, String s) {
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        //当左括号剩余数量大于0时，就可以向字符串中添加左括号
        if (left > 0) {
            recur(left - 1, right, res, s + "(");
        }
        //最括号剩余数量小于右括号剩余数量时，向字符换中添加右括号
        if (left < right) {
            recur(left, right - 1, res, s + ")");
        }
    }
}
