package Leetcode;

import java.util.HashSet;
import java.util.Set;

/*
给你一个整数数组 arr， 对于元素 x ，只有当 x + 1 也在数组 arr 里时，才能记为 1 个数。
如果数组 arr 里有重复的数，每个重复的数单独计算。
*/
public class Test164 {
    public int countElements(int[] arr) {
        //将数组中的数字放进set集合中
        Set<Integer> set=new HashSet<>();
        //记录结果
        int count=0;
        //先将数字放进set集合中
        for (int num:arr) {
            set.add(num);
        }
        //遍历数组中的数字
        for (int num :arr) {
            //如果集合中包含num+1,则计数+1
            if (set.contains(num+1)){
                count++;
            }
            //放进当前数字
            set.add(num);
        }
        //返回结果
        return count;
    }
}
