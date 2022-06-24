package HOT100;
/*给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，
使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
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
public class Test30 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        //指针p0和指针p1指向数组首元素
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < n; i++) {
            //当i指向数字0时，交换i和p0上的数字
            if (nums[i] == 0) {
                swap(nums, i, p0);
                //如果p0<p1,交换p0和p1上的数字
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                //p0和p1分别向后指一位
                p0++;
                p1++;
            }
            //当i位置上的数字是1时，交换i与p1上的数字
            else if (nums[i]==1){
                swap(nums,i,p1);
                //p1向后移动一位
                p1++;
            }
        }
    }
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
/*class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int p0=0;
        int p1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                swap(nums,i,p0);
                if(p0<p1){
                    swap(nums,i,p1);
                }
                p0++;
                p1++;
            }
            else if(nums[i]==1){
                swap(nums,i,p1);
                p1++;
            }
        }
    }
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}*/
