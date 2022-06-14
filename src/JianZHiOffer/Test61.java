package JianZHiOffer;

import java.util.ArrayList;
import java.util.List;

/*输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
示例 1：
输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：
输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
限制：
1 <= target <= 10^5
*/
public class Test61 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res=new ArrayList<>();
        int i=1;
        int j=target/2+1;
        int sum=0;
        for (int k = 1; k <=j ; k++) {
            sum+=k;
            while (sum>target){
                sum-=i;
                i++;
            }
            if (sum==target){
                int[] arr=new int[k-i+1];
                int index=0;
                for (int l = i; l <=k ; l++) {
                    arr[index++]=l;
                }
                res.add(arr);
            }
        }
        return res.toArray(new int[0][]);
    }
}
