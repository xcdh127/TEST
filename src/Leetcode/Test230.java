package Leetcode;

import java.util.HashMap;
import java.util.Map;

/*给出一个按 非递减 顺序排列的数组 nums，和一个目标数值 target。
假如数组 nums 中绝大多数元素的数值都等于 target，则返回 True，否则请返回 False。
所谓占绝大多数，是指在长度为 N 的数组中出现必须 超过 N/2 次。
*/
public class Test230 {
    public boolean isMajorityElement(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int num :nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        if (!map.containsKey(target))return false;
        return map.get(target)>n/2;
    }
}
