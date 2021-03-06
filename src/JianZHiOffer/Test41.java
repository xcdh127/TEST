package JianZHiOffer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;
import java.util.Map;

/*数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
示例 1:
输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
限制：
1 <= 数组长度 <= 50000
*/
public class Test41 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num :nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet() ){
            if (entry.getValue()>nums.length/2){
                return entry.getKey();
            }
        }
        return -1;
    }
}
