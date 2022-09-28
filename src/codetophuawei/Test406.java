package codetophuawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj]
是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
示例 1：
输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
解释：
编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
示例 2：
输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
提示：
1 <= people.length <= 2000
0 <= hi <= 106
0 <= ki < people.length
题目数据确保队列可以被重建
*/
public class Test406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            //当个子一样高时，根据排位正序排列
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            //当格个子不一样高时，按照个子递减排序
            else {
                return b[0] - a[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        //按照人在队列中的位置进行排序
        for (int[] p : people) {
            //使用向数组特定位置添加元素的方式添加元素
            res.add(p[1], p);
        }
        return res.toArray(new int[0][]);
    }
}


class Solution124 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            //身高相同按照排名和正序排序
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            //身高不同，按照身高逆序排序
            else {
                return b[0] - a[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            //按照排名向list中添加元素
            list.add(p[1], p);
        }
        return list.toArray(new int[0][]);
    }
}