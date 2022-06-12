package Leetcode;

import java.util.HashSet;
import java.util.Set;

/*给你一个由一些多米诺骨牌组成的列表 dominoes。
如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
*/

/*[[1,2],[1,2],[1,1],[1,2],[2,2]]*/
/*
[[1,2],[2,1],[3,4],[5,6]]*/
public class Test160 {
    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}};
        System.out.println(numEquivDominoPairs(arr));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        //记录相同多米诺的数量
        int count=0;
        //统计牌中二元组的和
        int[] arr=new int[100];
        //遍历所有的多米诺骨牌
        for (int[] domino: dominoes){
            //将多米诺牌计数成数字，将大数字放在前面
            int sum=domino[0]<domino[1]?domino[0]*10+domino[1]:domino[1]*10+domino[0];
            //累加当前数字出现的次数
            count+=arr[sum];
            //将sum出现的次数+1
            arr[sum]++;
        }
        return count;
    }
}
/*class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }
}
*/
