package Leetcode;

import java.util.HashSet;
import java.util.Set;

/*爱丽丝和鲍勃拥有不同总数量的糖果。给你两个数组 aliceSizes 和 bobSizes ，
aliceSizes[i] 是爱丽丝拥有的第 i 盒糖果中的糖果数量，bobSizes[j] 是鲍勃拥有的第 j 盒糖果中的糖果数量。
两人想要互相交换一盒糖果，这样在交换之后，他们就可以拥有相同总数量的糖果。
一个人拥有的糖果总数量是他们每盒糖果数量的总和。
返回一个整数数组 answer，其中 answer[0] 是爱丽丝必须交换的糖果盒中的糖果的数目，
answer[1] 是鲍勃必须交换的糖果盒中的糖果的数目。如果存在多个答案，
你可以返回其中 任何一个 。题目测试用例保证存在与输入对应的答案。
*/
public class Test34 {
    /*sumA-x+y=sumB+x-y   --> x=(numA-numB)/2*/
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA=0;
        int sumB=0;
        //先求两个数组的和
        for (int num :aliceSizes) {
            sumA+=num;
        }
        for (int num :bobSizes) {
            sumB+=num;
        }
        //固定值
        int Num=(sumA-sumB)/2;
        Set<Integer> set=new HashSet<>();
        //遍历a数组，将所有的数字放进set中
        for (int num :aliceSizes) {
            set.add(num);
        }
        //遍历b数组，判断有没有x=(numA-numB)/2,有就返回
        for (int num :bobSizes) {
            if (set.contains(num+Num)){
                return new int[]{num+Num,num};
            }
        }
        return new int[0];
    }
}
