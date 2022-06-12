package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*给你一个整数数组 nums ，它包含 2 * n 个整数。
你需要将 nums 划分成 n 个数对，满足：
每个元素 只属于一个 数对。
同一数对中的元素 相等 。
如果可以将 nums 划分成 n 个数对，请你返回 true ，否则返回 false 。
*/
/*输入：nums = [3,2,3,2,2,2]
输出：true
解释：
nums 中总共有 6 个元素，所以它们应该被划分成 6 / 2 = 3 个数对。
nums 可以划分成 (2, 2) ，(3, 3) 和 (2, 2) ，满足所有要求。
*/
public class Test172 {
    public boolean divideArray(int[] nums) {
        //map统计数组中的数字及其出现的次数
        Map<Integer,Integer> map=new HashMap<>();
        //遍历数组
        for (int num :nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //遍历键值对
        for (Map.Entry<Integer, Integer> entry :map.entrySet()) {
            //如果值为奇数，将直接返回false
            if (entry.getValue()%2==1){
                return false;
            }
        }
        //所有的数字出现次数都不为奇数时返回true
        return true;
    }
}
