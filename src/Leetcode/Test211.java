package Leetcode;
/*给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
输出：true
解释：
在上述矩阵中, 其对角线为:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
各条对角线上的所有元素均相同, 因此答案是 True 。

[[1,2,3,4],
 [5,1,2,3],
 [9,5,1,2]]

*/
public class Test211 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        //定义一个map存放所有的正对角线的下标差值
        //具有相同下标差值的数字在同一条对角线上
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //如果map中存在这个差值，并且这个数字与map中的数字不相同
                //返回false
                if (map.containsKey(j-i)){
                    if (map.get(j-i)!=matrix[i][j]){
                        return false;
                    }
                }
                //如果之前不存在这个差值，就将键值对放进map中
                else {
                    map.put(j-i,matrix[i][j]);
                }
            }
        }
        //如果对角线上的数字都相同，返回true
        return true;
    }
}
