package codeTop;
/*在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
示例 1:
输入: [7,5,6,4]
输出: 5
限制：
0 <= 数组长度 <= 50000
*/
public class TestOffer51 {
    int[] temp;
    int[] nums;
    public int reversePairs(int[] nums) {
        int n=nums.length;
        this.nums=nums;
        temp=new int[n];
        return recur(nums,0,n-1);
    }

    public int recur(int[] nums,int l,int r){
        //当l>=r时，此时逆序个数为0
        if (l>=r){
            return 0;
        }
        //求出中点m
        int m=l+(r-l)/2;
        //将当前数组拆分成左右两段，分别求出两段数组的逆序个数
        int res=recur(nums,l,m)+recur(nums,m+1,r);
        //将数组l～r的数字，放进数组当中
        for (int k = l; k <= r ; k++) {
            temp[k]=nums[k];
        }
        //i指向前一段数组的左端点
        int i=l;
        //j指向后一段数组的右端点
        int j=m+1;
        //归并排序的过程中，统计逆序个数
        for (int k = l; k <= r; k++) {
            //当指针i指到数组的末尾时
            if (i==m+1){
                //将j指向的数字，放进数组中
                nums[k]=temp[j];
                j++;
            }
            //当指针j指向数组的末尾时
            else if (j == r + 1) {
                //将指针i指向的数字，放进数组中
                nums[k]=temp[i];
                i++;
            }
            //当指针i指向的数字大于指针j指向的数字时
            else if (temp[i] > temp[j]) {
                //较小者j指针指向的数字，放进nums数组中
                nums[k]=temp[j];
                //统计逆序个数，（中点位置下标-i位置+1），这就是此时逆序的个数
                res+=m-i+1;
                //较小者的指针向后移动一位
                j++;
            }
            else {
                //较小者i指向的数字，放进数组中
                nums[k]=temp[i];
                //较小者的指针向后移动一位
                i++;
            }
        }
        //返回逆序数的个数
        return res;
    }
}
class Solution9 {
    int[] temp;
    public int reversePairs(int[] nums) {
        int n=nums.length;
        temp=new int[n];
        return recur(nums,0,n-1);
    }

    public int recur(int[] nums,int l,int r){
        int n=nums.length;
        if (l>=r) {
            return 0;
        }
        int m=(l+r)/2;
        int res=recur(nums,l,m)+recur(nums,m+1,r);
        for (int k = l; k <=r ; k++) {
            temp[k]=nums[k];
        }
        int i=l;
        int j=m+1;
        for (int k = l; k <=r ; k++) {
            if (i==m+1){
                nums[k]=temp[j];
                j++;
            }
            else if (j==r+1){
                nums[k]=temp[i];
                i++;
            }
            else if (temp[i]>temp[j]){
                nums[k]=temp[j];
                res+=m-i+1;
                j++;
            }
            else {
                nums[k]=temp[i];
                i++;
            }
        }
        return res;
    }
}