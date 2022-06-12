package Leetcode;
/*集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个
数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
给定一个数组 nums 代表了集合 S 发生错误后的结果。
请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
*/
public class Test28 {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        //记录重复的数字
        int chongFu=0;
        //记录缺失的数字
        int queShi=0;
        //记录当前数组中数字状态的数组
        boolean[] arr=new boolean[n+1];
        for (int num:nums){
            //如果数组中的已经有这个数字了就将使用chongFu记录下这个重复的数字
            if (arr[num]){
                chongFu=num;
            }
            //如果数字暂时没有放进数组中，标志位值为true
            arr[num]=true;
        }
        //遍历数组
        for (int i=1;i<=n;i++){
            //如果数组中没有当前数字，此标记位为false，使用queShi来记录缺失的数字
            if (!arr[i]){
                queShi=i;
            }
        }
        //输出形式：重复数字 丢失数字
        return new int[]{chongFu,queShi};
    }
}
