package JianZHiOffer;
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
1 <= board.length <= 200
1 <= board[i].length <= 200
board 和 word 仅由大小写英文字母组成
*/
public class Test12 {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        char[] words=word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (recur(board,words,i,j,0,new boolean[m][n])){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean recur(char[][] board,char[] word,int i,int j,int index,boolean[][] isVisited){
        int m=board.length;
        int n=board[0].length;
        if (index==word.length){
            return true;
        }
        if (i<0 || i>=m || j<0 || j>=n || board[i][j]!=word[index] || isVisited[i][j]){
            return false;
        }
        isVisited[i][j]=true;
        boolean res=recur(board,word,i+1,j,index+1,isVisited) || recur(board,word,i,j+1,index+1,isVisited) ||
                recur(board,word,i-1,j,index+1,isVisited) || recur(board,word,i,j-1,index+1,isVisited);
        isVisited[i][j]=false;
        return res;
    }
}
