package JianZHiOffer;
/*写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
示例:
输入: a = 1, b = 1
输出: 2
提示：
a, b 均可能是负数或 0
结果不会溢出 32 位整数
*/
public class Test71 {
    public int add(int a, int b) {
        //1000
        //0101
        //异或1101
        //1000
        //0101
        //相与后左移0000
        while (b!=0){
            int temp=a;
            //异或是不进位加法
            a=a^b;
            //相与后左移是进位
            b=(temp&b)<<1;
        }
        return a;
    }
}
/*class Solution {
    public int add(int a, int b) {
    	while(b!=0){
    		int temp=a;
    		a=a^b;
    		b=(b&temp)<<1;
    	}
    	return a;
    }
}*/
