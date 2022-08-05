package CodeDream;

import java.util.HashSet;
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
        //集合1
        Set<Integer> set1 = new HashSet<>();
        //集合2
        Set<Integer> set2 = new HashSet<>();
        //将数组1中的数字，放进set1中
        for (int num : nums1) {
            set1.add(num);
        }
        //将既在数组2中的数字，又在数组1的数字放进set2中
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        //返回两个数组中都含有的数字
        return set2.stream().mapToInt(i -> i).toArray();
    }
}
