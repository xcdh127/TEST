package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*在 「力扣挑战赛」 开幕式的压轴节目 「无人机方阵」中，每一架无人机展示一种灯光颜色。
无人机方阵通过两种操作进行颜色图案变换：
1.调整无人机的位置布局
2.切换无人机展示的灯光颜色
给定两个大小均为 N*M 的二维数组 source 和 target 表示无人机方阵表演的两种颜色图案，
由于无人机切换灯光颜色的耗能很大，请返回从 source 到 target 最少需要多少架无人机切换灯光颜色。
注意： 调整无人机的位置布局时无人机的位置可以随意变动。
*/
/*输入：source = [[1,3],[5,4]], target = [[3,1],[6,5]]
输出：1
解释：
最佳方案为
将 [0,1] 处的无人机移动至 [0,0] 处；
将 [0,0] 处的无人机移动至 [0,1] 处；
将 [1,0] 处的无人机移动至 [1,1] 处；
将 [1,1] 处的无人机移动至 [1,0] 处，其灯光颜色切换为颜色编号为 6 的灯光；
因此从source 到 target 所需要的最少灯光切换次数为 1。
*/
public class Test176 {

    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        //记录target数组中的数字及其出现的次数
        Map<Integer,Integer> map=new HashMap<>();
        for (int[] t :target) {
            for (int num:t) {
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        //遍历与数组
        for (int[] s :source) {
            for (int num :s) {
                //如果map中包含这个颜色的飞机
                if (map.containsKey(num)){
                    //将其个数-1，此时这个位置飞机移动位置解决
                    map.put(num,map.get(num)-1);
                    //当map中的数字个数减小到0时
                    if (map.get(num)==0){
                        //将键值对删除
                        map.remove(num);
                    }
                }
            }
        }
        //返回map的大小，就是需要变化颜色的飞机
        int sum=0;
        //求map中的和
        for (Map.Entry<Integer, Integer> entry :map.entrySet()) {
            sum+=entry.getValue();
        }
        return sum;
    }
}

/*class Solution {
    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int n = source.length;
        int m = source[0].length;
        // 初始哈希表
        int[] nums = new int[10001];
        // 如果target中x出现的次数和source一样多，则nums[x] = 0;
        // 如果target中x出现的次数比source多，则nums[x] < 0;
        // 如果target中x出现的次数比source少，则nums[x] > 0。
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[source[i][j]]++;
                nums[target[i][j]]--;
            }
        }
        // 只需求nums[x]>0的数量即可
        int count = 0;
        for (int i = 1; i < 10001; i++) {
            if (nums[i] > 0) count+=nums[i];
        }
        return count;
    }
}
*/
