package codeTop;
/*给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
示例 1：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
示例 2：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
输出：true
示例 3：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
输出：false
提示：
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board 和 word 仅由大小写英文字母组成
进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
*/
public class Test79 {
    public boolean exist(char[][] board, String word) {
        char[] ch=word.toCharArray();
        int m=board.length;
        int n=board[0].length;
        boolean[][] isVisited=new boolean[m][n];
        //试探数组的每一个位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //如果当前位置，搜索到了字符串，返回true
                if (recur(board,ch,i,j,0,isVisited)){
                    return true;
                }
            }
        }
        //搜索不到，返回false
        return false;
    }

    public boolean recur(char[][] board,char[] word,int i,int j,int index,boolean[][] isVisited){
        //行
        int m=board.length;
        //列
        int n=board[0].length;
        //当所有的字符都找到了，返回true
        if (index==word.length){
            return true;
        }
        //若超出数组范围，或者当前位置遍历过，或者当前位置的字符不是要找的字符，返回false
        if (i<0 || i>=m || j<0 || j>=n || isVisited[i][j] || word[index]!=board[i][j]){
            return false;
        }
        //标记当前位置遍历过了
        isVisited[i][j]=true;
        //在四个方向上遍历，只要有一个方向上的字符对上就返回true
        boolean res=recur(board,word,i+1,j,index+1,isVisited) ||
                recur(board,word,i-1,j,index+1,isVisited) ||
                recur(board,word,i,j+1,index+1,isVisited) ||
                recur(board,word,i,j-1,index+1,isVisited);
        //消掉刚刚遍历的标记
        isVisited[i][j]=false;
        //返回结果
        return res;
    }
}
