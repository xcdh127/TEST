package Leetcode;
/*给定一个整数数组  nums，处理以下类型的多个查询:
计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
实现 NumArray 类：
NumArray(int[] nums) 使用数组 nums 初始化对象
int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，
包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
*/
class NumArray {
    int[] pre;
    public NumArray(int[] nums) {
        int n=nums.length;
        //初始化前缀和数组
        pre=new int[n+1];
        pre[0]=0;
        //将数组累加值，填入前缀和数组
        for (int i = 1; i <=n ; i++) {
            pre[i]=pre[i-1]+nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        //前缀和两个区间和相减[0,right]-[0,left-1]
        return pre[right+1]-pre[left];
    }
}

