package Leetcode;
/*存在一种仅支持 4 种操作和 1 个变量 X 的编程语言：
++X 和 X++ 使变量 X 的值 加 1
--X 和 X-- 使变量 X 的值 减 1
最初，X 的值是 0
给你一个字符串数组 operations ，这是由操作组成的一个列表，返回执行所有操作后， X 的 最终值 。
*/
public class Test91 {
    public int finalValueAfterOperations(String[] operations) {
        int num=0;
        int n=operations.length;
        //遍历字符串，当遇到X--或者--X将数字值-1
        //当遇到X++或者++操作符将数字值+1
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("--X") || operations[i].equals("X--")){
                num--;
            }
            else {
                num++;
            }
        }
        //返回结果
        return num;
    }
}
