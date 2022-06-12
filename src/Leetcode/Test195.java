package Leetcode;
/*给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回 true，否则返回 false。
形式上，如果可以找出索引 i + 1 < j 且满足 
(arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1]
== arr[j] + arr[j + 1] + ... + arr[arr.length - 1]) 就可以将数组三等分。
*/
/*输入：arr = [0,2,1,-6,6,-7,9,1,2,0,1]
输出：true
解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1

[1,-1,1,-1]
*/
public class Test195 {
    public static void main(String[] args) {
        int[] arr=new int[]{1,-1,1,-1};
        System.out.println(canThreePartsEqualSum(arr));

    }
    public static boolean canThreePartsEqualSum(int[] arr) {
        int n=arr.length;
        //记录前缀和
        int[] pre=new int[n+1];
        pre[0]=0;
        for (int i = 1; i <=n ; i++) {
            pre[i]=pre[i-1]+arr[i-1];
        }
        //遍历所有所有的i j 三段和相等
        for (int i = 1; i <= n-2; i++) {
            for (int j = i+1; j <= n-1; j++) {
                if (pre[i]==pre[j]-pre[i] && pre[n]-pre[j]==pre[i]){
                    return true;
                }
            }
        }
        return false;
    }
}
