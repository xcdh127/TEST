package Leetcode;
/*给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
0 <= i < j < k < arr.length
|arr[i] - arr[j]| <= a
|arr[j] - arr[k]| <= b
|arr[i] - arr[k]| <= c
其中 |x| 表示 x 的绝对值。
返回 好三元组的数量 。
*/
/*输入：arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
输出：4
解释：一共有 4 个好三元组：[(3,0,1), (3,0,1), (3,1,1), (0,1,1)] 。
*/
public class Test187 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        //记录数组的长度
        int n=arr.length;
        //记录三元组的个数
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j =i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    //遍历所有的三元组，统计符合太条件的三元组的个数
                    if (Math.abs(arr[i]-arr[j])<=a && Math.abs(arr[j]-arr[k])<=b && Math.abs(arr[i]-arr[k])<=c){
                        count++;
                    }
                }
            }
        }
        //返回结果
        return count;
    }
}
