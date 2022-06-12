package Leetcode;

import java.util.Arrays;

/*学校打算为全体学生拍一张年度纪念照。根据要求，
学生需要按照 非递减 的高度顺序排成一行。
排序后的高度情况用整数数组 expected 表示，
其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
给你一个整数数组 heights ，表示 当前学生站位
的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
返回满足 heights[i] != expected[i] 的 下标数量 。
*/
public class Test59 {
    public int heightChecker(int[] heights) {
        //记录多少的学生不符合预期
        int count=0;
        int n=heights.length;
        //从原数组拷贝一份数组
        int[] copyOf = Arrays.copyOf(heights, n);
        //对元数组进行排序
        Arrays.sort(heights);
        for (int i = 0; i < n; i++) {
            //当原数组与拷贝后的数组元素不相等时，累加1
            if (heights[i]!=copyOf[i]){
                count++;
            }
        }
        return count;
    }
}
