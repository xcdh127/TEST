package Leetcode;
/*给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：
如果存在，请返回 true ；否则，返回 false 。*/
public class Test245 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n=arr.length;
        for (int i = 0; i < n - 2; i++) {
            if (arr[i]%2==1 && arr[i+1]%2==1 && arr[i+2]%2==1){
                return true;
            }
        }
        return false;
    }
}
