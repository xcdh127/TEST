package TTT;

public class Test9 {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=0;
        while(right<n){
            //当前数字时偶数时，将其交换到数组的前半部分
            if(nums[right]%2==0){
                swap(nums,left,right);
                //前半部分后半部分分界线向后移动一位
                left++;
            }
            //当前位置向后移动一位
            right++;
        }
        return nums;
    }
    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
/*905. 按奇偶排序数组
给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，
后跟所有奇数元素。返回满足此条件的 任一数组 作为答案。*/