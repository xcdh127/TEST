package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*给你一个整数数组 nums ，该数组具有以下属性：
nums.length == 2 * n.
nums 包含 n + 1 个 不同的 元素
nums 中恰有一个元素重复 n 次
找出并返回重复了 n 次的那个元素。
*/
public class Test159 {
    public int repeatedNTimes(int[] nums) {
        int length=nums.length;
        //将数组中的数字出现的次数添加到map中
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //从map中寻找数组中出现了length/2次数的数字输出
        for (Map.Entry<Integer, Integer> entry :map.entrySet()) {
            if (entry.getValue()==length/2){
                return entry.getKey();
            }
        }
        //返回-1
        return -1;
    }
}
