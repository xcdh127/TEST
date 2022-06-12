package Leetcode;
/*给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。*/
public class Test274 {
    public int subtractProductAndSum(int n) {
        long eveMutil=1;
        int eveSum=0;
        while (n>0){
            int yuShu=n%10;
            eveSum+=yuShu;
            eveMutil*=yuShu;
            n/=10;
        }
        return (int)(eveMutil-eveSum);
    }
}
