package Leetcode;
/*给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
完成所有替换操作后，请你返回这个数组。*/

import java.util.Stack;

/*输入：arr = [17,18,5,4,6,1]
输出：[18,6,6,6,1,-1]
解释：
- 下标 0 的元素 --> 右侧最大元素是下标 1 的元素 (18)
- 下标 1 的元素 --> 右侧最大元素是下标 4 的元素 (6)
- 下标 2 的元素 --> 右侧最大元素是下标 4 的元素 (6)
- 下标 3 的元素 --> 右侧最大元素是下标 4 的元素 (6)
- 下标 4 的元素 --> 右侧最大元素是下标 5 的元素 (1)
- 下标 5 的元素 --> 右侧没有其他元素，替换为 -1
*/
public class Test197 {
    public int[] replaceElements(int[] arr) {
        //数组的长度
        int n=arr.length;
        for (int i = 0; i < n-1; i++) {
            //记录当前位置后的最大值
            int max=Integer.MIN_VALUE;
            for (int j = i+1; j <n ; j++) {
                max=Math.max(arr[j],max);
            }
            //将当前位置使用最大值替换
            arr[i]=max;
        }
        //将最后一个位置填充-1
        arr[n-1]=-1;
        //将修改后的数组输出
        return arr;
    }
}
