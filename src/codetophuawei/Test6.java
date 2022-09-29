package codetophuawei;

import java.util.ArrayList;
import java.util.List;

/*将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
请你实现这个将字符串进行指定行数变换的函数：
ing convert(string s, int numRows);
示例 1：
输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
示例 2：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
示例 3：
输入：s = "A", numRows = 1
输出："A"
提示：
1 <= s.length <= 1000
s 由英文字母（小写和大写）、',' 和 '.' 组成
1 <= numRows <= 1000
*/
public class Test6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        //初始向上方遍历行
        int downWords = -1;
        //所在行标
        int row = 0;
        //字符串长度
        int n = s.length();
        List<StringBuilder> res = new ArrayList<>();
        //新建字符串长度和指定行数取较小者，每一行新建一个拼接字符串
        for (int i = 0; i < Math.min(numRows, n); i++) {
            res.add(new StringBuilder());
        }
        //遍历字符串，将字符串中的字符放在正确的行上
        for (int i = 0; i < n; i++) {
            //获取当前行的字符串
            res.get(row).append(s.charAt(i));
            //当到达第一行或者是最后一行时，向相反方向运行
            if (row == 0 || row == numRows - 1) {
                downWords = downWords == -1 ? 1 : -1;
            }
            //改变此时所在的行
            row += downWords;
        }
        //新建一个字符串，拼接list中的所有的字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder sb : res) {
            stringBuilder.append(sb);
        }
        return stringBuilder.toString();
    }
}


class Solution149 {
    public String convert(String s, int numRows) {
        int downWords = -1;
        int n = s.length();
        if (numRows == 1) {
            return s;
        }
        int row = 0;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, n); i++) {
            list.add(new StringBuilder());
        }
        for (int i = 0; i < n; i++) {
            list.get(row).append(s.charAt(i));
            if (row == 0 || row == numRows - 1) {
                downWords = downWords == -1 ? 1 : -1;
            }
            row += downWords;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < Math.min(numRows, n); i++) {
            res.append(list.get(i));
        }
        return res.toString();
    }
}