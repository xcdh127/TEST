package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，
请你返回一个长度为 2 的列表 answer ，其中：
answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
注意：列表中的整数可以按 任意 顺序返回。
*/

/*输入：nums1 = [1,2,3], nums2 = [2,4,6]
输出：[[1,3],[4,6]]
解释：
对于 nums1 ，nums1[1] = 2 出现在 nums2 中下标 0 处，
然而 nums1[0] = 1 和 nums1[2] = 3 没有出现在 nums2 中。因此，answer[0] = [1,3]。
对于 nums2 ，nums2[0] = 2 出现在 nums1 中下标 1 处，
然而 nums2[1] = 4 和 nums2[2] = 6 没有出现在 nums2 中。因此，answer[1] = [4,6]。
*/
public class Test173 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        //新建两个set集合
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        //分别粗存放两个数组中的元素
        for (int num :nums1) {
            set1.add(num);
        }
        for (int num :nums2) {
            set2.add(num);
        }
        //求出两个集合交集
        Set<Integer> inner=new HashSet<>();
        //将集合1全部添加到一个新集合中
        inner.addAll(set1);
        //将集合1和2中都有的保留
        inner.retainAll(set2);
        //将set1删除所有两个交集之间的元素，剩下的是set1独有的
        set1.removeAll(inner);
        //将set2删除所有两个交集之间的元素，剩下的是set2独有的
        set2.removeAll(inner);
        //结果集合
        List<List<Integer>> res=new ArrayList<>();
        //向结果中添加数组1中独有的元素
        res.add(new ArrayList<>(set1));
        //向结果中添加数组2中独有的元素
        res.add(new ArrayList<>(set2));
        //返回结果
        return res;
    }
}
