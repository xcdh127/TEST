package Jianzhioffer02;

/*给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母不允许被重复使用。
例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
示例 1：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
示例 2：
输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
提示：
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board 和 word 仅由大小写英文字母组成
*/
public class Test12 {
    int m;
    int n;
    char[] ch;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        this.m = m;
        this.n = n;
        ch = word.toCharArray();
        //记录当前位置是否遍历过的数组
        boolean[][] isVisited = new boolean[m][n];
        //从每一个位置开始深度优先遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //如果此位置可以拼接出要找的单词，返回true
                if (recur(board, ch, 0, isVisited, i, j)) {
                    return true;
                }
            }
        }
        //找不到返回false
        return false;
    }

    public boolean recur(char[][] board, char[] word, int index, boolean[][] isVisited, int i, int j) {
        //如果所有的字符都能找到，返回true
        if (index == word.length) {
            return true;
        }
        //当超出矩阵的边界，或者当前位置已经遍历过了，或者当前位置的字符等于当前要搜索的字符时，返回false
        if (i < 0 || i >= m || j < 0 || j >= n || isVisited[i][j] || word[index] != board[i][j]) {
            return false;
        }
        //标记(i,j)位置访问过
        isVisited[i][j] = true;
        //遍历下一个位置
        boolean res = recur(board, word, index + 1, isVisited, i + 1, j)
                || recur(board, word, index + 1, isVisited, i, j + 1)
                || recur(board, word, index + 1, isVisited, i - 1, j)
                || recur(board, word, index + 1, isVisited, i, j - 1);
        //标记(i,j)位置没有访问过
        isVisited[i][j] = false;
        //返回res
        return res;
    }
}

class Solution38 {
    int m;
    int n;
    char[] ch;

    public boolean exist(char[][] board, String word) {

        this.m = board.length;
        this.n = board[0].length;
        this.ch = word.toCharArray();
        boolean[][] isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (recur(board, ch, i, j, 0, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean recur(char[][] board, char[] ch, int i, int j, int index, boolean[][] isVisited) {
        if (index == ch.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= m || j >= n || isVisited[i][j] || board[i][j] != ch[index]) {
            return false;
        }
        isVisited[i][j] = true;
        boolean res = recur(board, ch, i + 1, j, index + 1, isVisited) || recur(board, ch, i - 1, j, index + 1, isVisited) ||
                recur(board, ch, i, j - 1, index + 1, isVisited) || recur(board, ch, i, j + 1, index + 1, isVisited);
        isVisited[i][j] = false;
        return res;
    }
}
