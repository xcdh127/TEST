package HOT100;
/*有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。
如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
求所能获得硬币的最大数量。
示例 1：
输入：nums = [3,1,5,8]
输出：167
解释：
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
示例 2：
输入：nums = [1,5]
输出：10
提示：
n == nums.length
1 <= n <= 300
0 <= nums[i] <= 100
*/
public class Test312 {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        //赋值0-1和0+1位置处的数字为1
        arr[0]=1;
        arr[n+1]=1;
        //数组中的其余数字拷贝进来
        for (int i = 0; i < n; i++) {
            arr[i+1]=nums[i];
        }
        int[][] dp=new int[n+2][n+2];
        //长度为3的子数组开始搜索，直到搜索长度为n+2
        for (int len = 3; len <=n+2 ; len++) {
            //i表示区间左端点
            for (int i = 0; i <=n+2-len ; i++) {
                //j表示区间右端点
                int j=i+len-1;
                //res记录刺破区间i，j的最大得分
                int res=Integer.MIN_VALUE;
                //遍历区间i，j之间的所有取值，取最大值
                for (int k = i+1; k <j ; k++) {
                    res=Math.max(res,dp[i][k]+dp[k][j]+arr[i]*arr[j]*arr[k]);
                }
                //ij区间中刺破的最大值
                dp[i][j]=res;
            }
        }
        //返回区间0-n+1之间的刺破得分最大值
        return dp[0][n+1];
    }
}
/*class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        //为新数组赋值
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        int[][] dp=new int[n+2][n+2];
        //从长度为3的子数组开始搜索，直到搜索长度为n+2
        for(int len=3;len<=n+2;len++){
            //i表示区间的左端点
            for(int i=0;i<=n+2-len;i++){
                //j表示区间的右端点
                int j=i+len-1;
                //统计区间中的最大硬币个数
                int res=Integer.MIN_VALUE;
                //统计区间(i,j)之间的最大硬币个数
                for(int k=i+1;k<j;k++){
                    res=Math.max(res,dp[i][k]+dp[k][j]+arr[i]*arr[j]*arr[k]);
                }
                //将区间(i,j)之间的最大值赋值给dp[i][j]
                dp[i][j]=res;
            }
        }
        //返回区间(0,n+1)之间的最大值
        return dp[0][n+1];
    }
}*/
