package codeTop;

import java.util.Arrays;

/*给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
必须在不使用库的sort函数的情况下解决这个问题。
示例 1：
输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
示例 2：
输入：nums = [2,0,1]
输出：[0,1,2]
提示：
n == nums.length
1 <= n <= 300
nums[i] 为 0、1 或 2
进阶：
你可以不使用代码库中的排序函数来解决这道题吗？
你能想出一个仅使用常数空间的一趟扫描算法吗？
*/
public class Test75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < n; i++) {
            /*[2(p0,p1),0,2,1,1,0]
             * [0,2(p0,p1),2,1,1,0]
             * [0,1(p0),2(p1),2,1,0]
             * [0,1(p0),1(p1),2,2,0]
             * [0,1(p0),2(p1),1,2,0]
             * [0,0(p0),2(p1),1,2,1]
             * [0,0(p0),1(p1),1,2,2]
             * */
            //当前数字为0时，交换数组i和p0位置的两个数字
            //将数字0，交换到p0指针的位置
            if (nums[i] == 0){
                swap(nums,i,p0);
                //当指针p0在指针p1之前时,将当前位置上的数字与p1指针位置上的数字进行交换
                if (p0<p1){
                    swap(nums,i,p1);
                }
                //p0指针和p1指针都向后指向一位
                p0++;
                p1++;
            }
            //当前数字为1时，交换数组i和p1位置的两个数字
            else if (nums[i] == 1) {
                swap(nums,i,p1);
                p1++;
            }
        }
    }
    //交换数组中的两个位置
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}

class Solution19 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}