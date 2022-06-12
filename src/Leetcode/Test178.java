package Leetcode;
/*你的好友是一位健身爱好者。前段日子，他给自己制定了一份健身计划。现在想请你帮他评估一下这份计划是否合理。
他会有一份计划消耗的卡路里表，其中 calories[i] 给出了你的这位好友在第 i 天需要消耗的卡路里总量。
为了更好地评估这份计划，对于卡路里表中的每一天，你都需要计算他
「这一天以及之后的连续几天」 （共 k 天）内消耗的总卡路里 T：
如果 T < lower，那么这份计划相对糟糕，并失去 1 分； 
如果 T > upper，那么这份计划相对优秀，并获得 1 分；
否则，这份计划普普通通，分值不做变动。
请返回统计完所有 calories.length 天后得到的总分作为评估结果。
注意：总分可能是负数。
*/
/*输入：calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
输出：0
解释：calories[0], calories[1] < lower 而 calories[3], calories[4] > upper, 总分 = 0.
*/
/*输入：calories = [3,2], k = 2, lower = 0, upper = 1
输出：1
解释：calories[0] + calories[1] > upper, 总分 = 1.

*/
public class Test178 {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int n=calories.length;
        int score=0;
        //窗口左边界
        int i=0;

        //记录窗口和
        int sum=0;
        //窗口右边界
        for (int j = 0; j < n; j++) {
            //累加窗口和
            sum+=calories[j];
            //窗口形成
            if (j-i+1==k){
                if (sum>upper){
                    score++;
                }
                else if (sum<lower){
                    score--;
                }
                //缩小窗口
                sum-=calories[i];
                i++;
            }
        }
        //返回结果
        return score;
    }
}
