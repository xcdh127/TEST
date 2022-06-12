package Leetcode;

import java.net.Inet4Address;
import java.util.*;

/*给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 与这三个数组都不同的 数组，
且由 至少 在 两个 数组中出现的所有值组成。数组中的元素可以按 任意 顺序排列。
*/
/*输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
输出：[]
解释：不存在至少在两个数组中出现的值。*/
public class Test169 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        //定义三个set集合
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        Set<Integer> set3=new HashSet<>();
        //分别向set集合中添加数字
        for (int num :nums1) {
            set1.add(num);
        }
        for (int num :nums2) {
            set2.add(num);
        }
        for (int num :nums3) {
            set3.add(num);
        }
        //三个集合相互取交集，然后汇总
        //数组1 2 求交集
        Set<Integer> all12=new HashSet<>();
        all12.addAll(set1);
        all12.retainAll(set2);
        //数组1 3求交集
        Set<Integer> all13=new HashSet<>();
        all13.addAll(set1);
        all13.retainAll(set3);
        //数组2 3求交集
        Set<Integer> all23=new HashSet<>();
        all23.addAll(set2);
        all23.retainAll(set3);
        //汇总集合
        Set<Integer> all=new HashSet<>();
        all.addAll(all12);
        all.addAll(all13);
        all.addAll(all23);
        //结果数组
        List<Integer> res=new ArrayList<>(all);
        //返回
        return res;
    }
}
