package codetophuawei;

/*给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，
返回在甲板 board 上放置的 战舰 的数量。
战舰 只能水平或者垂直放置在 board 上。换句话说，
战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以是任意大小。
两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
示例 1：
输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
输出：2
示例 2：
输入：board = [["."]]
输出：0
提示：
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] 是 '.' 或 'X'
*/
public class Test419 {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //遇到X时，将所有相邻的X都变成. ，包括横向和纵向
                if (board[i][j] == 'X') {
                    board[i][j] = '.';
                    for (int k = i + 1; k < m && board[k][j] == 'X'; k++) {
                        board[k][j] = '.';
                    }
                    for (int k = j + 1; k < n && board[i][k] == 'X'; k++) {
                        board[i][k] = '.';
                    }
                    count++;
                }
            }
        }
        return count;
    }
}


class Solution162 {
    public int countBattleships(char[][] board) {


        int count = 0;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'X') {

                    board[i][j] = '.';
                    for (int k = i + 1; k < m && board[k][j] == 'X'; k++) {

                        board[k][j] = '.';

                    }

                    for (int k = j + 1; k < n && board[i][k] == 'X'; k++) {

                        board[i][k] = '.';

                    }
                    count++;

                }
            }

        }
        return count;
    }
}