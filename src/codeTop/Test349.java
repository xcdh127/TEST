package codeTop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
解释：[4,9] 也是可通过的
提示：
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
*/
public class Test349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        //set集合
        Set<Integer> set=new HashSet<>();
        //将数组1添加到set中
        for (int num :nums1) {
            set.add(num);
        }
        //将数组2中数组1有的数字，添加到set1中
        Set<Integer> set1=new HashSet<>();
        for (int num :nums2) {
            if (set.contains(num)){
                set1.add(num);
            }
        }
        //返回set1中的数字
        return set1.stream().mapToInt(i->i).toArray();
    }
}
