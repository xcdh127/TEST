package Leetcode;
/*未知 整数数组 arr 由 n 个非负整数组成。
经编码后变为长度为 n - 1 的另一个整数数组 encoded ，
其中 encoded[i] = arr[i] XOR arr[i + 1] 。
例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
*/
/*输入：encoded = [1,2,3], first = 1
输出：[1,0,2,1]
解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
*/
public class Test220 {
    public int[] decode(int[] encoded, int first) {
        int n=encoded.length;
        //新建原数组
        int[] arr=new int[n+1];
        //将第一个数字放进原数组中
        arr[0]=first;
        for (int i = 1; i <= n; i++) {
            //原数组的各位是原数组的前一位异或当前编码位置
            arr[i]=arr[i-1]^encoded[i-1];
        }
        //返回原数组
        return arr;
    }
}
