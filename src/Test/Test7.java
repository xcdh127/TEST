package Test;

import java.util.Arrays;

/*给你一个整数数组 nums ，你需要找出一个 连续子数组 ，
如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
请你找出符合题意的 最短 子数组，并输出它的长度。
*/
public class Test7 {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        //拷贝一份数组，并将拷贝后的数组进行升序排序
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
        //定义两个指针分别指向数组的首、尾
        int i=0;
        int j=n-1;
        //当拷贝后数组与原数组，从首元素开始对应元素一致时，i继续向后指向
        while (i<n && copy[i]==nums[i]) {
            i++;
        }
        //如果数组原来就有序，直接返回0
        if (i==n){
            return 0;
        }
        //当拷贝后的数组与原数组，从尾元素开始对应元素一致时，j继续向前指向
        while (j>=0 && copy[j]==nums[j]){
            j--;
        }
        //返回数组需要调整顺序部分的长度
        return j-i+1;
    }
}
