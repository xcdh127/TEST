package HOT100;
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
        int m=nums1.length;
        int n=nums2.length;
        int len=m+n;
        int aStart=0;
        int bStart=0;
        //记录数组的中点
        int left=-1;
        int right=-1;
        //遍历数组一半次数
        for (int i = 0; i <= len / 2; i++) {
            //将right值赋值给left
            left=right;
            //当指针没有遍历完a数组，并且b数组已经遍历完毕或者是指向a数组的数字小于指向b数组的数字时
            if (aStart<m && (bStart>=n || nums1[aStart]<nums2[bStart])){
                //right指向a数组的值
                right=nums1[aStart++];
            }
            //right指向b数组的值
            else {
                right=nums2[bStart++];
            }
        }
        //返回中点位置的数字
        if (len%2==1){
            return right/1.0;
        }
        return (left+right)/2.0;
    }
}
/*class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int len=m+n;
        int aStart=0;
        int bStart=0;
        //记录数组中间数字
        int left=-1;
        int right=-1;
        //从0开始到两个数组总长度的一半
        for(int i=0;i<=len/2;i++){
            //将right赋值给left
            left=right;
            //当num1数字没有取完值时，并且num1当前值比num2小，right赋值
            //数组1当前数字，并且指针向后移动一位
            if(aStart<m && (bStart>=n || nums1[aStart]<nums2[bStart])){
                right=nums1[aStart++];
            }
            //数组1遍历完毕，或者num1的值大于num2的值，right赋值
            //数组2当前数字，并且指针向后移动一位
            else{
                right=nums2[bStart++];
            }
        }
        //如果长度为奇数，返回right
        if(len%2==1){
            return right/1.0;
        }
        //如果长度是偶数，返回left
        else{
            return (left+right)/2.0;
        }
    }
}*/




















