package Leetcode;
/*给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
*/
public class Test224 {
    public static void main(String[] args) {
        int[] arr=new int[]{2,5,1,3,4,7};
        System.out.println(shuffle(arr, 3));
    }
    public static int[] shuffle(int[] nums, int n) {
        int N=nums.length;
        int[] arr=new int[N];
        int i=0;
        int j=N/2;
        int index=0;
        while (i<n){
            arr[index++]=nums[i++];
            arr[index++]=nums[j++];
        }
        return arr;
    }
}
