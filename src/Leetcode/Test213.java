package Leetcode;
/*小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，
小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，
请返回 小A 猜对了几次？
输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
*/
/*输入：guess = [1,2,3], answer = [1,2,3]
输出：3
解释：小A 每次都猜对了。*/
public class Test213 {
    public int game(int[] guess, int[] answer) {
        //记录猜对次数
        int count=0;
        for (int i = 0; i < guess.length; i++) {
            //猜测与结果相等时，计数+1
            if (guess[i]==answer[i]){
                count++;
            }
        }
        //返回结果
        return count;
    }
}
