package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*给你一个整数数组 nums 。
如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
返回好数对的数目。
*/
public class Test165 {
    public int numIdenticalPairs(int[] nums) {
        //记录数组中数字出现次数的map
        Map<Integer,Integer> map=new HashMap<>();
        //遍历数组，统计出现次数
        for (int num :nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //记录种类数
        int count=0;
        //遍历map中的所有键值对
        for (Map.Entry<Integer, Integer> entry :map.entrySet()) {
            //取出所有的值
            int num=entry.getValue();
            //相同数字好书对求和公式
            count+=(num-1)*num/2;
        }
        //返回结果
        return count;
    }
}
