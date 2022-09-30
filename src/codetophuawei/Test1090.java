package codetophuawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*我们有一个 n 项的集合。给出两个整数数组 values 和 labels ，
第 i 个元素的值和标签分别是 values[i] 和 labels[i]。还会给出两个整数 numWanted 和 useLimit 。
从 n 个元素中选择一个子集 s :
子集 s 的大小 小于或等于 numWanted 。
s 中 最多 有相同标签的 useLimit 项。
一个子集的 分数 是该子集的值之和。
返回子集 s 的最大 分数 。
示例 1：
输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
输出：9
解释：选出的子集是第一项，第三项和第五项。
示例 2：
输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2
输出：12
解释：选出的子集是第一项，第二项和第三项。
示例 3：
输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1
输出：16
解释：选出的子集是第一项和第四项。
提示：
n == values.length == labels.length
1 <= n <= 2 * 104
0 <= values[i], labels[i] <= 2 * 104
1 <= numWanted, useLimit <= n
*/
public class Test1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Integer[] s = new Integer[n];
        for (int i = 0; i < n; i++) {
            s[i] = i;
        }
        //按照值的大小，从大到小排序
        Arrays.sort(s, (a, b) -> values[b] - values[a]);
        Map<Integer, Integer> map = new HashMap<>();
        //累加数字的和
        int ans = 0;
        //数字个数
        int sum = 0;
        for (int i = 0; i < n && sum < numWanted; i++) {
            int v = values[s[i]];
            int l = labels[s[i]];
            int show = map.getOrDefault(l, 0);
            //当前标签出现次数小于limit时，将值累加到ans中
            if (show < useLimit) {
                ans += v;
                //将当前标签出现的次数+1
                map.put(l, show + 1);
                //总共的数字+1
                sum++;
            }
        }
        return ans;
    }
}


class Solution160 {

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int len = values.length;
        Integer[] s = new Integer[len];
        for (int i = 0; i < s.length; i++) {
            s[i] = i;
        }
        Arrays.sort(s, (a, b) -> values[b] - values[a]);
        Map<Integer, Integer> cnts = new HashMap<>();
        int ans = 0, sum = 0;
        for (int i = 0; i < s.length && sum < numWanted; i++) {
            int v = values[s[i]], l = labels[s[i]];
            int show = cnts.getOrDefault(l, 0);
            if (show < useLimit) {
                ans += v;
                cnts.put(l, show + 1);
                sum++;
            }
        }
        return ans;
    }

}
