package codeTop;
/*给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
假设环境不允许存储 64 位整数（有符号或无符号）。
示例 1：
输入：x = 123
输出：321
示例 2：
输入：x = -123
输出：-321
示例 3：
输入：x = 120
输出：21
示例 4：
输入：x = 0
输出：0
提示：
-231 <= x <= 231 - 1
*/
public class Test7 {
    public int reverse(int x) {
        //记录符号
        int sign=1;
        //构成数字的边界值
        int boundary=Integer.MAX_VALUE/10;
        //当值小于0时，符号为-号，将x值置为正数
        if (x<0){
            sign=-1;
            x=-x;
        }
        //结果为0
        int res=0;
        while (x>0){
            //算出最后一位数字
            int yuShu=x%10;
            //当res没要到达边界时，继续构造数字
            if (res<boundary || res==boundary && yuShu<=7){
                res=res*10+yuShu;
            }
            //如果数字超过边界，返回0
            else {
                return 0;
            }
            //将数字整除10
            x/=10;
        }
        //返回带上符号的结果
        return res*sign;
    }
}
class Solution13 {
    public int reverse(int x) {
        int sign=1;
        if(x<0){
            sign=-1;
            x=-x;
        }
        int res=0;
        int boundary=Integer.MAX_VALUE/10;
        while(x>0){
            int yuShu=x%10;
            if(res<boundary || (res==boundary && yuShu<=7)){
                res=res*10+yuShu;
            }
            else{
                return 0;
            }
            x/=10;
        }
        return res*sign;
    }

}