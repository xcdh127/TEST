package JianZHiOffer;

import java.util.Arrays;

/*把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
示例 1:
输入: 1
输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
示例 2:
输入: 2
输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
限制：
1 <= n <= 11
*/
public class Test66 {
    public double[] dicesProbability(int n) {
        double[] res=new double[6];
        Arrays.fill(res,1.0/6);
        for (int i = 2; i <=n ; i++) {
            //下一层的结果个数
            double[] temp=new double[5*i+1];
            //上一层的结果个数
            for (int j = 0; j < 5 * (i - 1)+1; j++) {
                //上一层的每一个数字对下一层的每一个数字的影响，累加影响
                for (int k = 0; k < 6; k++) {
                    temp[j+k]+=res[j]/6;
                }
            }
            res=temp;
        }
        return res;
    }
}
/*class Solution {
    public double[] dicesProbability(int n) {

double[] res=new double[6];
Arrays.fill(res,1.0/6);
for(int i=2;i<=n;i++){
double[] temp=new double[5*i+1];
for(int j=0;j<5*(i-1)+1;j++){
for(int k=0;k<6;k++){
temp[j+k]+=res[j]/6;
}
}
res=temp;
}
return res;
}
}
*/