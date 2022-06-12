package Leetcode;
/*欢迎各位勇者来到力扣新手村，本次训练内容为「采集果实」。
在新手村中，各位勇者需要采集一些果实来制作药剂。time[i] 表示勇者每次采集 1～limit
颗第 i 种类型的果实需要的时间（即每次最多可以采集 limit 颗果实）。
当前勇者需要完成「采集若干批果实」的任务， fruits[j] = [type, num] 表示第 j
批需要采集 num 颗 type 类型的果实。采集规则如下：
按 fruits 给定的顺序依次采集每一批次
采集完当前批次的果实才能开始采集下一批次
勇者完成当前批次的采集后将清空背包（即多余的果实将清空）
请计算并返回勇者完成采集任务最少需要的时间。
示例 1：
输入：time = [2,3,2], fruits = [[0,2],[1,4],[2,1]], limit = 3
输出：10
解释：
由于单次最多采集 3 颗
第 0 批需要采集 2 颗第 0 类型果实，需要采集 1 次，耗时为 2*1=2
第 1 批需要采集 4 颗第 1 类型果实，需要采集 2 次，耗时为 3*2=6
第 2 批需要采集 1 颗第 2 类型果实，需要采集 1 次，耗时为 2*1=2
返回总耗时 2+6+2=10
*/
public class Test260 {
    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int needTime=0;
        for (int[] fruit :fruits) {
            int type=fruit[0];
            int num=fruit[1];
            needTime+=num%limit==0?(num/limit)*time[type]:(num/limit+1)*time[type];
        }
        return needTime;
    }
}
