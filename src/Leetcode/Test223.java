package Leetcode;

import java.util.*;

/*给你一个下标从 0 开始的整数数组 nums 和两个整数 key 和 k 。K 近邻下标 是 nums 中的一个下标 i ，
并满足至少存在一个下标 j 使得 |i - j| <= k 且 nums[j] == key 。
以列表形式返回按 递增顺序 排序的所有 K 近邻下标。
*/
/*输入：nums = [3,4,9,1,3,9,5], key = 9, k = 1
输出：[1,2,3,4,5,6]
解释：因此，nums[2] == key 且 nums[5] == key 。
- 对下标 0 ，|0 - 2| > k 且 |0 - 5| > k ，所以不存在 j 使得 |0 - j| <= k 且 nums[j] == key 。所以 0 不是一个 K 近邻下标。
- 对下标 1 ，|1 - 2| <= k 且 nums[2] == key ，所以 1 是一个 K 近邻下标。
- 对下标 2 ，|2 - 2| <= k 且 nums[2] == key ，所以 2 是一个 K 近邻下标。
- 对下标 3 ，|3 - 2| <= k 且 nums[2] == key ，所以 3 是一个 K 近邻下标。
- 对下标 4 ，|4 - 5| <= k 且 nums[5] == key ，所以 4 是一个 K 近邻下标。
- 对下标 5 ，|5 - 5| <= k 且 nums[5] == key ，所以 5 是一个 K 近邻下标。
- 对下标 6 ，|6 - 5| <= k 且 nums[5] == key ，所以 6 是一个 K 近邻下标。
因此，按递增顺序返回 [1,2,3,4,5,6] 。
*/
public class Test223 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        //set去重
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                //至少存在一个下标 j 使得 |i - j| <= k 且 nums[j] == key 。
                if (nums[j]==key && Math.abs(i-j)<=k){
                    if (!set.contains(i)){
                        list.add(i);
                        set.add(i);
                    }
                }
            }
        }
        //排序
        Collections.sort(list);
        return list;
    }
}
