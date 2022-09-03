package Jianzhioffer02;

/*在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
示例 1:
输入: [7,5,6,4]
输出: 5
限制：
0 <= 数组长度 <= 50000
*/
public class Test51 {
    int[] temp;

    public int reversePairs(int[] nums) {
        int n = nums.length;
        temp = new int[n];
        //归并排序数组，并且求出逆序数个数
        int res = recur(nums, 0, n - 1);
        return res;

    }

    public int recur(int[] nums, int l, int r) {
        //当子数组的个数为1时，返回逆序个数为0
        if (l >= r) {
            return 0;
        }
        //取区间的中点
        int m = l + (r - l) / 2;
        //将区间一分为二，求出逆序数的个数
        int res = recur(nums, l, m) + recur(nums, m + 1, r);
        //指向左边数组的指针
        int i = l;
        //指向右边数组的指针
        int j = m + 1;
        //将l到r位置的数组拷贝到临时数组中
        for (int k = l; k <= r; k++) {
            temp[k] = nums[k];
        }
        //遍历临时数组，将指针指向的较小的数字放进排序数组中
        //当某一边的数组直到末尾，就移动另外一边的指针
        for (int k = l; k <= r; k++) {
            if (i == m + 1) {
                nums[k] = temp[j++];
            } else if (j == r + 1) {
                nums[k] = temp[i++];
            }
            //当i指针处的数字小于等于j指针处的数字时，将较小的数字赋值给排序数组
            else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            }
            //当i指针指向的数字大于j指针指向的数字时，统计逆序数字的个数，将较小的数字放进排序数组中
            //逆序数增加的个数为m-i+1
            else {
                nums[k] = temp[j++];
                res += m - i + 1;
            }
        }
        return res;
    }
}

class Solution34 {
    int[] temp;
    int[] nums;

    public int reversePairs(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        temp = new int[n];
        return recur(nums, 0, n - 1);
    }

    public int recur(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int m = l + (r - l) / 2;
        int res = recur(nums, l, m) + recur(nums, m + 1, r);
        for (int k = l; k <= r; k++) {
            temp[k] = nums[k];
        }
        int i = l;
        int j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i == m + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == r + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] > temp[j]) {
                //较小者j指针指向的数字，放进nums数组中
                nums[k] = temp[j];
                //统计逆序个数，中点位置下标-i位置+1
                res += m - i + 1;
                //较小者的指针向后移动一位
                j++;
            } else {
                //较小者i指向的数字，放进数组中
                nums[k] = temp[i];
                //较小者的指针向后移动一位
                i++;
            }
        }
        return res;
    }
}