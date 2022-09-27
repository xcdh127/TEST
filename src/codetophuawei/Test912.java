package codetophuawei;

/*给你一个整数数组 nums，请你将该数组升序排列。
示例 1：
输入：nums = [5,2,3,1]
输出：[1,2,3,5]
示例 2：
输入：nums = [5,1,1,2,0,0]
输出：[0,0,1,1,2,5]
提示：
1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104
*/
public class Test912 {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        quickSort(nums, 0, n - 1);
        return nums;
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l > r) {
            return;
        }
        int i = l;
        int j = r;
        int p = l;
        while (i < j) {
            while (i < j && nums[p] <= nums[j]) {
                j--;
            }
            while (i < j && nums[p] >= nums[i]) {
                i++;
            }
            swap(nums, i, j);
        }
        p = i;
        swap(nums, p, l);
        quickSort(nums, l, p - 1);
        quickSort(nums, p + 1, r);
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}


class Solution119 {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        recur(nums, 0, n - 1);
        return nums;
    }

    public void recur(int[] nums, int l, int r) {
        if (l > r) {
            return;
        }
        int i = l;
        int j = r;
        int p = l;
        while (i < j) {
            while (i < j && nums[j] >= nums[p]) {
                j--;
            }
            while (i < j && nums[i] <= nums[p]) {
                i++;
            }
            swap(nums, i, j);
        }
        p = i;
        swap(nums, l, p);
        recur(nums, l, p - 1);
        recur(nums, p + 1, r);
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
