public class Test1 {
    public static void main(String[] args) {
        int energy = 10;
        int[][] arr = new int[][]{{1, 1}, {2, 3}, {3, 5}, {5, 10}, {7, 9}, {8, 10}};
        System.out.println(maxScore(arr, energy));
    }

    public static int maxScore(int[][] actions, int energy) {
        //获取物品的个数，初始化价值为0
        int wlen = actions.length, value0 = 0;
        //dp背包的意义是消耗能量为energy的能力获取的最大价值
        int[][] dp = new int[wlen + 1][energy + 1];
        for (int i = 0; i <= wlen; i++) {
            dp[i][0] = value0;
        }
        //外层遍历物品，内层遍历背包容量
        for (int i = 1; i <= wlen; i++) {
            for (int j = 1; j <= energy; j++) {
                //当容量小于物品重量树时
                if (j < actions[i - 1][0]) {
                    //不将物品放进背包
                    dp[i][j] = dp[i - 1][j];
                }
                //将物品放进
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - actions[i - 1][0]] + actions[i - 1][1]);
                }
            }
        }
        return dp[actions.length][energy];
    }
}
