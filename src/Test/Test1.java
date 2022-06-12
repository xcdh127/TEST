package Test;
/*两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
给你两个整数 x 和 y，计算并返回它们之间的汉明距离。*/
public class Test1 {
    public static void main(String[] args) {
        System.out.println(hammingDistance(3, 6));
    }
    public static int hammingDistance(int x, int y) {
        int count=0;
        for (int i = 0; i < 32; i++) {
            //取出各对应位置的bit位的值进行比较
            int bitX=(x>>i)&1;
            int bitY=(y>>i)&1;
            //不相等则结果+1
            if (bitX!=bitY) {
                count++;
            }
        }
        return count;
    }
}
