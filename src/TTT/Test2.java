package TTT;

public class Test2 {
}

class Solution {
    public static void main(String[] args) {
        int[] a={3,2,2,3};
        System.out.println(removeElement(a, 3));


    }
    public static int removeElement(int[] nums, int val) {
        int n=nums.length;
        int slow=0;
        for(int fast=0;fast<n;fast++){
            //当值不等于要删除的元素时，放在数组的首位向后一次排序
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }

}