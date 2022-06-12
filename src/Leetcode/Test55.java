package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*「力扣挑战赛」心算项目的挑战比赛中，
要求选手从 N 张卡牌中选出 cnt 张卡牌，
若这 cnt 张卡牌数字总和为偶数，
则选手成绩「有效」且得分为 cnt 张卡牌数字总和。
给定数组 cards 和 cnt，
其中 cards[i] 表示第 i 张卡牌上的数字。
 请帮参赛选手计算最大的有效得分。
 若不存在获取有效得分的卡牌方案，则返回 0。
*/
public class Test55 {
    public int maxmiumScore(int[] cards, int cnt) {
        //将数组排序
        Arrays.sort(cards);
        int n=cards.length;
        //用于计算所有的奇数和
        List<Integer> odd=new ArrayList<>();
        //用于计算所有的偶数和
        List<Integer> even=new ArrayList<>();
        //将奇数和初始化为0
        odd.add(0);
        //将偶数和初始化为0
        even.add(0);
        //倒序遍历数组
        //倒序计算数组中的和
        for (int i = n-1; i >=0; i--) {
            //如果当前数字是奇数,累加求和放进数组中
            if (cards[i]%2==1){
                odd.add(odd.get(odd.size()-1)+cards[i]);
            }
            //如果当前数字是偶数，累加求和放进数组中
            else{
                even.add(even.get(even.size()-1)+cards[i]);
            }
        }
        //当前牌数
        int k=0;
        //记录结果的res
        int res=0;
        //k是当前选择的牌数
        while (k<=cnt){
            //当k小于奇数数组的个数，res-k小于偶数数组的个数，奇数数组中的数字+偶数数组中的数字
            //为偶数时，此时结果res在res和奇数数组+偶数数组的和中选最大值
            if (k<odd.size() && (cnt-k)<even.size() && (odd.get(k)+even.get(cnt-k))%2==0){
                res=Math.max(res,odd.get(k)+even.get(cnt-k));
            }
            //将奇数数组中的指针向后移动两位
            k+=2;
        }
        return res;
    }
}
/*排序后，逆序遍历求前1、2、3、4、5.。。个的奇数或者偶数的和放入到odd和even中
枚举k从0开始，每次+2
因为奇数的列表是这样的，如果cards=[1，2，3，4，5，6，7，8，9]，那么odd=[0，9，16，21，24，25]
所以odd选择的必须是偶数，偶数的下表是0，2，4，6.。。。。，所以k=0，k+=2；
如果k=2，可能会出现全是偶数的情况，如果cnt=1，这是返回even，不会进入循环，and=0，错误，不理解可以忽略这一步
所以再while循环中，只需要满足k和cnt-k分别不越界，并且相加是偶数就可以把最大值记录下来，直到不满足循环退出
返回计算结果*/
class Solution {
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int len = cards.length;
        List<Integer> odd = new ArrayList<>(), even = new ArrayList<>();
        odd.add(0); even.add(0);
        for(int i=len-1;i>=0;i--){
            if(cards[i]%2 == 1) odd.add(odd.get(odd.size()-1)+cards[i]);
            else even.add(even.get(even.size()-1)+cards[i]);
        }
        int k = 0;
        int ans = 0;
        while(k<=cnt){
            if(k<odd.size()&&(cnt-k)<even.size()&&(odd.get(k)+even.get(cnt-k))%2==0)
                ans = Math.max(ans, odd.get(k)+even.get(cnt-k));
            k+=2;
        }
        return ans;
    }
}
