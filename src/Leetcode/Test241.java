package Leetcode;
/*给你一个整数 n，请你返回
任意 一个由 n 个 各不相同 的整数组成的数组，
并且这 n 个数相加和为 0 。*/
public class Test241 {
    public int[] sumZero(int n) {
        int[] arr=new int[n];
        int index=0;
        if (n%2==0){
            for (int i = 1; i <=n/2 ; i++) {
                arr[index++]=i;
                arr[index++]=-i;
            }
        }
        else {
            arr[index++]=0;
            for (int i = 1; i <=n/2; i++) {
                arr[index++]=i;
                arr[index++]=-i;
            }
        }
        return arr;
    }
}
