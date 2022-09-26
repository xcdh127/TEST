package codetophuawei;

import java.util.ArrayList;
import java.util.List;

/*给你一个整数数组 nums ，按要求返回一个新数组 counts 。
数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
示例 1：
输入：nums = [5,2,6,1]
输出：[2,1,1,0]
解释：
5 的右侧有 2 个更小的元素 (2 和 1)
2 的右侧仅有 1 个更小的元素 (1)
6 的右侧有 1 个更小的元素 (1)
1 的右侧有 0 个更小的元素
示例 2：
输入：nums = [-1]
输出：[0]
示例 3：
输入：nums = [-1,-1]
输出：[0,0]
提示：
1 <= nums.length <= 105
-104 <= nums[i] <= 104
*/
public class Test315 {

}

class Solution88 {
    int[] index;
    int[] temp;
    int[] tempIndex;
    int[] res;

    public List<Integer> countSmaller(int[] nums) {

        List<Integer> list = new ArrayList<Integer>();

        index = new int[nums.length];
        temp = new int[nums.length];
        tempIndex = new int[nums.length];
        res = new int[nums.length];

        //首先保存当前数组中数字的下标
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            list.add(res[i]);
        }
        return list;
    }


    public void mergeSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        //当前区间的中点
        int m = (l + r) / 2;
        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);
        merge(a, l, m, r);
    }

    public void merge(int[] a, int l, int m, int r) {

        //定义双指针分别指向两个数组的首部
        int i = l;
        int j = m + 1;
        //定义指针p，指向排序数组的当前下标
        int p = l;
        while (i <= m && j <= r) {
            //当指针i指向的数字小于指针j指向的数字时,将这个位置的数字放进temp数组中;
            if (a[i] <= a[j]) {
                temp[p] = a[i];
                //将指针i位置的数字在a数组中的下标赋给tempIndex数组
                tempIndex[p] = index[i];
                //记录原数组index[i]位置的数字的右边有几个数字大于它
                res[index[i]] += (j - m - 1);
                i++;
                p++;
            } else {
                temp[p] = a[j];
                tempIndex[p] = index[j];
                j++;
                p++;
            }
        }

        while (i <= m) {
            temp[p] = a[i];
            tempIndex[p] = index[i];
            res[index[i]] += (j - m - 1);
            i++;
            p++;
        }

        while (j <= r) {
            temp[p] = a[j];
            tempIndex[p] = index[j];
            p++;
            j++;
        }

        //用temp数组更新a数组的l~r部分的数字，将更新后的数字在原数组中的位置更新为tempIndex的位置
        for (int k = l; k <= r; k++) {
            a[k] = temp[k];
            index[k] = tempIndex[k];
        }
    }
}