package Leetcode;
/*给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
商店里正在进行促销活动，如果你要买第 i 件商品，
那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 
且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格
*/

import java.util.Arrays;
import java.util.Stack;

/*
输入：prices = [8,4,6,2,3]
输出：[4,2,4,2,3]
解释：
商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
商品 3 和 4 都没有折扣。
*/
public class Test157 {
    public static void main(String[] args) {
        int[] arr=new int[]{8,4,6,2,3};
        System.out.println(Arrays.toString(finalPrices(arr)));
    }
    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack=new Stack<>();
        //获取物品的个数
        int n=prices.length;
        //存放距离当前时间最近的小于当前价格的天数
        int[] arr=new int[n];
        Arrays.fill(arr,-1);
        //当栈为空时，并且当前的数字大于栈顶元素的价格
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i]<=prices[stack.peek()]){
                //弹出当前栈顶元素
                int index=stack.pop();
                //将栈中的坐标位置设置为i，表明在index后的首个小于当前价格的位置
                arr[index]=i;
            }
            //将当前坐标添加到栈中
            stack.push(i);
        }
        //遍历价格数组
        for (int i = 0; i < n; i++) {
            //如果统计当前位置后是否有价格小于当前价格的天数
            //由于初始化-1，所以在不是-1的位置上的值就是折扣价
            //有则减掉优化下标的价值
            if (arr[i]!=-1){
                prices[i]=prices[i]-prices[arr[i]];
            }
        }
        //输出打折后的价格
        return prices;
    }
}
