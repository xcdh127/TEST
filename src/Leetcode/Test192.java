package Leetcode;
/*给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，
但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
*/
/*输入：grid =
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]
输出：16
解释：它的周长是上面图片中的 16 个黄色的边
输入：grid = [[1]]
输出：4
*/
public class Test192  {
    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,0}};
        System.out.println(islandPerimeter(arr));
    }
    public static int islandPerimeter(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        int[][] res=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //统计1出现的次数，以及相邻1的个数
                if (grid[i][j]==1){
                    count(grid,i,j,res);
                    count++;
                }
            }
        }
        //计算相邻边
        int len=0;
        for (int[] arr :res) {
            for (int num :arr) {
                len+=num;
            }
        }
        //有效的临边数
        int linBian=len/2;
        //1格子总数*4-2*临边数
        return count*4-2*linBian;
    }
    //统计该元素周围的相邻1个数
    public static void count(int[][] grid,int i,int j,int[][] res){
        int m=grid.length;
        int n=grid[0].length;
        int[][] dirs=new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
        for (int[] dir :dirs) {
            int row=dir[0]+i;
            int col=dir[1]+j;
            if (row>=0 && row<m && col>=0 && col<n && grid[row][col]==1){
                res[i][j]++;
            }
        }
    }
}
