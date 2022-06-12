package Leetcode;
/*给你两个长度相同的整数数组 target 和 arr 。
每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。
如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。
*/
public class Test63 {
    public boolean canBeEqual(int[] target, int[] arr) {
        //用于记录数组中出现的数字的次数
        int[] array=new int[1001];
        //遍历数组target时，此时出现的数字在数组中对应+1
        for (int i = 0; i < target.length; i++) {
            array[target[i]]++;
        }
        //遍历数组arr时，此时出现的数字在数组中对应-1
        for (int i = 0; i < arr.length; i++) {
            array[arr[i]]--;
        }
        //遍历一遍统计数组，如果有数字个数没有清零，那就不可能通过旋转使得
        //两个数组一样
        for (int num : array) {
            if (num!=0){
                return false;
            }
        }
        //否则可以
        return true;
    }
}
