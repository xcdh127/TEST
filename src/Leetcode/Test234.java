package Leetcode;

import java.util.HashSet;
import java.util.Set;

/*在某个数组 arr 中，值符合等差数列的数值规律：在 0 <= i < arr.length - 1 的前提下，
arr[i+1] - arr[i] 的值都相等。
我们会从该数组中删除一个 既不是第一个 也 不是最后一个的值，得到一个新的数组  arr。
给你这个缺值的数组 arr，返回 被删除的那个数 。
*/
public class Test234 {
    public static void main(String[] args) {
        int[] arr=new int[]{15,13,12};
        System.out.println(missingNumber(arr));
    }
    public static int missingNumber(int[] arr) {
        int n=arr.length;
        int diff=(arr[n-1]-arr[0])/n;
        int index=0;
        for (int i = 0; i < n-1; i++) {
            if (arr[i+1]-arr[i]!=diff){
                return arr[i]+diff;
            }
        }
        return -1;
    }
}
/* for (; i < arrSize - 1; ++i) {
        if (arr[i + 1] - arr[i] != diff) {
            break;
        }
    }

    return arr[i] + diff;
*/