package codeTop;

import java.util.Deque;
import java.util.LinkedList;

/*给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
请注意，返回的 规范路径 必须遵循下述格式：
始终以斜杠 '/' 开头。
两个目录名之间必须只有一个斜杠 '/' 。
最后一个目录名（如果存在）不能 以 '/' 结尾。
此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
返回简化后得到的 规范路径 。
示例 1：
输入：path = "/home/"
输出："/home"
解释：注意，最后一个目录名后面没有斜杠。
示例 2：
输入：path = "/../"
输出："/"
解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。
示例 3：
输入：path = "/home//foo/"
输出："/home/foo"
解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
示例 4：
输入：path = "/a/./b/../../c/"
输出："/c"
提示：
1 <= path.length <= 3000
path 由英文字母，数字，'.'，'/' 或 '_' 组成。
path 是一个有效的 Unix 风格绝对路径。
*/
public class Test71 {
    public String simplifyPath(String path) {
        //双端队列
        Deque<String> queue = new LinkedList<>();
        int n = path.length();
        //遍历数组
        for (int i = 1; i < n;) {
            //当前字符是/时，向后遍历一位
            if (path.charAt(i) == '/' && ++i >= 0) {
                continue;
            }
            //截取出两个/之间的目录项
            int j = i + 1;
            while (j < n && path.charAt(j) != '/') {
                j++;
            }
            String temp = path.substring(i, j);
            //目录项为..时
            if (temp.equals("..")) {
                //当队列不为空时，弹出最后添加到队列的目录
                if (!queue.isEmpty()) {
                    queue.pollLast();
                }
            }
            //如果目录项不等于.，将此目录项添加到队列的末尾
            else if (!temp.equals(".")) {
                queue.offerLast(temp);
            }
            //将j赋值给i
            i = j;
        }
        //拼接字符串
        StringBuilder sb = new StringBuilder();
        //当队列不为空时
        while (!queue.isEmpty()) {
            //拼接 / 和从头开始弹出的目录项
            sb.append("/" + queue.pollFirst());
        }
        //返回简化后的目录
        return sb.length() == 0 ? "/" : sb.toString();
    }
}

class Solution37 {
    public String simplifyPath(String path) {

        Deque<String> queue = new LinkedList<String>();
        int n = path.length();
        for (int i = 1; i < n; ) {

            if (path.charAt(i) == '/' && ++i >= 0) {

                continue;
            }
            int j = i + 1;
            while (j < n && path.charAt(j) != '/') {

                j++;
            }
            String temp = path.substring(i, j);

            if (temp.equals("..")) {

                if (!queue.isEmpty()) {

                    queue.pollLast();
                }

            } else if (!temp.equals(".")) {

                queue.addLast(temp);
            }
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {

            sb.append("/" + queue.pollFirst());
        }
        return sb.length() == 0 ? "/" : sb.toString();


    }
}