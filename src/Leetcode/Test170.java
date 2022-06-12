package Leetcode;

import java.util.HashSet;
import java.util.Set;

/*对一个大小为 n x n 的矩阵而言，如果其每一行和每一列都包含从 1 到 n 的 全部 整数（含 1 和 n），
则认为该矩阵是一个 有效 矩阵。
给你一个大小为 n x n 的整数矩阵 matrix ，请你判断矩阵是否为一个有效矩阵：
如果是，返回 true ；否则，返回 false 。
*/
/*输入：matrix = [[1,2,3],[3,1,2],[2,3,1]]
输出：true
解释：在此例中，n = 3 ，每一行和每一列都包含数字 1、2、3 。
因此，返回 true 。
[[1,2,3],
 [3,1,2],
 [2,3,1]]
*/
public class Test170 {
    public boolean checkValid(int[][] matrix) {
        //求出数组的长度
        int m=matrix.length;
        //求出每行每列应该的值
        int num=0;
        for (int i = 1; i <=m ; i++) {
            num+=i;
        }
        //逐行检查
        for (int i = 0; i < m; i++) {
            int sum=0;
            //创建set集合，去除重复数字
            Set<Integer> set=new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                //如果集合中包含之前的数字，直接返回false
                if (set.contains(matrix[i][j])){
                    return false;
                }
                //求此列的和
                sum+=matrix[i][j];
                //向set集合中添加当前数字
                set.add(matrix[i][j]);
            }
            //如果和不正确，返回false
            if (sum!=num){
                return false;
            }
        }
        //逐列检查
        for (int i = 0; i < m; i++) {
            int sum=0;
            Set<Integer> set=new HashSet<>();
            for (int j = 0; j < m; j++) {
                //如果集合中包含之前的数字，直接返回false
                if (set.contains(matrix[i][j])){
                    return false;
                }
                //求此列的和
                sum+=matrix[j][i];
                //向set集合中添加当前数字
                set.add(matrix[i][j]);
            }
            //如果和不正确，返回false
            if (sum!=num){
                return false;
            }
        }
        //检查通过，返回true
        return true;
    }
}
