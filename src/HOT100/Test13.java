package HOT100;

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
public class Test13 {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        recur(res,n,n,"");
        return res;

    }
    public void recur(List<String> res,int left,int right,String temp){
        if (left==0 && right==0){
            res.add(temp);
            return;
        }
        if (left>0){
            recur(res,left-1,right,temp+"(");
        }
        if (left<right){
            recur(res,left,right-1,temp+")");
        }
    }
}
