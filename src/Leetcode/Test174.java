
package Leetcode;

import java.util.*;

/*给你一个二维整数数组 nums ，其中 nums[i] 是由 不同
正整数组成的一个非空数组，按 升序排列 返回一个数组，
数组中的每个元素在 nums 所有数组 中都出现过。

[[7,34,45,10,12,27,13],[27,21,45,10,12,13]]
输出：
[45,10,12,27,13]
预期结果：
[10,12,13,27,45]
*/
public class Test174 {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i < nums[0].length; i++) {
            res.add(nums[0][i]);
        }
        //遍历每一个数组
        for (int i=1;i<nums.length;i++) {
            //将当前数组中的元素放进set集合中
            Set<Integer> set=new HashSet<>();
            for (int j=0;j<nums[i].length;j++) {
                set.add(nums[i][j]);
            }
            //保留res与set集合公共的元素
            res.retainAll(set);
        }
        //将集合排序输出
        Collections.sort(res);
        return res;
    }
}
