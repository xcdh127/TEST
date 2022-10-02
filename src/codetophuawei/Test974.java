package codetophuawei;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的（连续、非空） 子数组 的数目。
子数组 是数组的 连续 部分。
示例 1：
输入：nums = [4,5,0,-2,-3,1], k = 5
输出：7
解释：
有 7 个子数组满足其元素之和可被 k = 5 整除：
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
示例 2:
输入: nums = [5], k = 9
输出: 0
提示:
1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
2 <= k <= 104
*/
public class Test974 {
    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{1}, 1));
    }

    public static int subarraysDivByK(int[] nums, int k) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111");
            }
        });
        executorService.shutdown();
        int n = nums.length;
        int count = 0;
        int sum = 0;
        int[] map = new int[k];
        map[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum = sum + nums[i - 1];
            int key = (sum % k + k) % k;
            count += map[key];
            map[key]++;
        }
        return count;
    }
}


class Solution166 {
    public int subarraysDivByK(int[] A, int K) {
        int N = A.length, sum = 0, ans = 0;
        int[] map = new int[K];
        map[0] = 1;
        for (int i = 1; i <= N; i++) {
            sum = sum + A[i - 1];
            int key = (sum % K + K) % K;
            ans += map[key];
            map[key]++;
        }
        return ans;
    }
}
