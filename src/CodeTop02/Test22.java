package CodeTop02;

import java.util.ArrayList;
import java.util.List;

/*数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例 1：
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：
输入：n = 1
输出：["()"]
提示：
1 <= n <= 8
*/
public class Test22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recur(res, n, n, "");
        return res;
    }

    public void recur(List<String> res, int left, int right, String s) {
        //左右括号不剩余时，记录结果
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        //左括号剩余数量大于0时
        if (left > 0) {
            recur(res, left - 1, right, s + "(");
        }
        //左括号剩余数量小于右括号时
        if (left < right) {
            recur(res, left, right - 1, s + ")");
        }
    }
}
