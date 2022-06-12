package Leetcode;
/*由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I' 
如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D' 
给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
*/
/*
输入：s = "IDID"
输出：[0,4,1,3,2]
*/
public class Test101 {
    public static void main(String[] args) {
        System.out.println(diStringMatch("IDID"));
    }
    public static int[] diStringMatch(String s) {
        //字符串长度
        int n=s.length();
        //待排序数字，一个指针指向最小值
        int i=0;
        //一个指向最大值
        int j=n;
        //结果字符串
        int[] arr=new int[n+1];
        //遍历字符串
        for (int k = 0; k < n; k++) {
            //当遇到I时，将小指针指向的数字放到数组中，并向后移动一位
            if (s.charAt(k)=='I'){
                arr[k]=i++;
            }
            //当遇到D时，将大指针指向的数字放进数组中，并向后移动一位
            else {
                arr[k]=j--;
            }
        }
        //最后一位为i
        arr[n]=i;
        //返回结果数组
        return arr;
    }
}
