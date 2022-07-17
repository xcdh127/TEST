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
public class Test912 {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        quickSort(nums,0,n-1);
        return nums;
    }

    public void quickSort(int[] nums,int l,int r){
        int n=nums.length;
        if (l>=r){
            return;
        }
        int i=l;
        int j=r;
        int p=l;
        while (i<j){
            while (i<j && nums[j]>=nums[p]){
                j--;
            }
            while (i<j && nums[i]<=nums[p]){
                i++;
            }
            swap(nums,i,j);
        }
        p=i;
        swap(nums,l,p);
        quickSort(nums,l,p-1);
        quickSort(nums,p+1,r);
    }

    public void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
/*class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        quickSort(nums,0,n-1);
        return nums;
    }

    public void quickSort(int[] nums,int l,int r){
        if(l>r){
            return ;
        }
        int i=l;
        int j=r;
        //设定哨兵节点为数组中的第一个数字
        int p=l;
        //当i<j时，继续将数组中的数字与哨兵进行比较
        while(i<j){
            //比哨兵大的数字放到哨兵的右边
            while(i<j && nums[j]>=nums[p]){
                j--;
            }
            //比哨兵小的数字放到哨兵的左边
            while(i<j && nums[i]<=nums[p]){
                i++;
            }
            //交换数组i位置与数组j位置上的数字
            swap(nums,i,j);
        }
        //将哨兵的位置更新为新的i位置
        p=i;
        //交换数组中哨兵位置与数组中的l的位置
        swap(nums,l,p);
        //排哨兵的左边区间的值
        quickSort(nums,l,p-1);
        //排哨兵的右边区间的值
        quickSort(nums,p+1,r);
    }
    //交换数组中两个位置上的数字
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}*/