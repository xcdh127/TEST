package codeTop;

/*给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
算法的时间复杂度应该为 O(log (m+n)) 。
示例 1：
输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：
输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
提示：
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/
public class Test4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int aStart = 0;
        int bStart = 0;
        //记录中点的值，初始化为-1
        int left=-1;
        int right=-1;
        //取数组一半的数字
        for (int i = 0; i <= len / 2; i++) {
            //将right赋值给left
            left=right;
            //当指针没有指到数组1的末尾时，并且指针直到数组2的末尾或者数组1的值小于数组2的值
            //将数组1中的值赋值给right
            if (aStart<m && (bStart>=n || nums1[aStart]<nums2[bStart])){
                right=nums1[aStart++];
            }
            //否则，将数组2的值赋值给right
            else {
                right=nums2[bStart++];
            }
        }
        //如果数组的长度为奇数，直接返回left的值
        if (len%2==1){
            return left/1.0;
        }
        //否则，返回left与right和的平均值
        else {
            return (left+right)/2.0;
        }
    }
}
