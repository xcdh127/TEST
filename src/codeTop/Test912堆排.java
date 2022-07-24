package codeTop;

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
public class Test912堆排 {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        //临时数组
        int[] temp = new int[n];
        //归并排序
        mergeSort(nums,temp,0,n-1);
        //返回排序后的数组
        return nums;
    }

    public void mergeSort(int[] nums, int[] temp, int l, int r) {
        if (l >= r) {
            return;
        }
        //取中点
        int m=l+(r-l)/2;
        //mergeSort左半数组
        mergeSort(nums,temp,l,m);
        //mergeSort右半数组
        mergeSort(nums,temp,m+1,r);
        //将当前nums添加到temp临时数组中
        for (int k = l; k <= r; k++) {
            temp[k]=nums[k];
        }
        //指针i指向数组的开始位置
        int i=l;
        //指针j指向数组的后半部分的起始位置
        int j=m+1;
        for (int k = l; k <= r; k++) {
            //当指针i指向前半数组的末尾时，将指针j指向的数字放进排序数组中
            if (i==m+1){
                nums[k]=temp[j];
                j++;
            }
            //当指针j指向后半部分数组的末尾时，将指针i指向数组
            else if (j == r + 1) {
                nums[k]=temp[i];
                i++;
            }
            //当两个指针都没有指向数组的首位置时
            else if (temp[i] < temp[j]) {
                nums[k]=temp[i];
                i++;
            }
            else {
                nums[k]=temp[j];
                j++;
            }
        }
    }
}
/*class Solution {
int[] temp;
public int[] sortArray(int[] nums) {
int n=nums.length;
this.temp=new int[n];
mergeSort(nums,0,n-1);
return nums;
}
public void mergeSort(int[] nums,int l,int r){
if(l>=r){
return ;
}
int m=(l+r)/2;
mergeSort(nums,l,m);
mergeSort(nums,m+1,r);
//记录临时数组
for(int k=l;k<=r;k++){
temp[k]=nums[k];
}
//定义两个指针分别指向两个子数组
//前半个数组的首部
int i=l;
//后半个数组的首部
int j=m+1;
for(int k=l;k<=r;k++){
if(i==m+1){
nums[k]=temp[j];
j++;
}
else if(j==r+1){
nums[k]=temp[i];
i++;
}
else if(temp[i]<temp[j]){
nums[k]=temp[i];
i++;
}
else if(temp[i]>=temp[j]){
nums[k]=temp[j];
j++;
}
}
}
}*/
