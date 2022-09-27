package codetophuawei;

import java.util.Arrays;

/*给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。
每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
返回 承载所有人所需的最小船数 。
示例 1：
输入：people = [1,2], limit = 3
输出：1
解释：1 艘船载 (1, 2)
示例 2：
输入：people = [3,2,2,1], limit = 3
输出：3
解释：3 艘船分别载 (1, 2), (2) 和 (3)
示例 3：
输入：people = [3,5,3,4], limit = 5
输出：4
解释：4 艘船分别载 (3), (3), (4), (5)
提示：
1 <= people.length <= 5 * 104
1 <= people[i] <= limit <= 3 * 104
*/
public class Test881 {
    public int numRescueBoats(int[] people, int limit) {
        //因为船只最多能够容纳两个人，尽量在承载体重很重的人的时候带上体重比较轻的人
        int n = people.length;
        //先对人群排序
        Arrays.sort(people);
        //定义两个指针，一个指向最轻的人，一个指向最重的人
        int light = 0;
        int heavy = n - 1;
        int count = 0;
        //当两个指针没有相撞时，体重最重的指针一直向前指向
        //体重最轻的指针只有在体重之和小于等于limit时才会向后指向
        while (light <= heavy) {
            //当体重最轻的人和体重最重的人的体重和小于等于light时
            //体重最轻的指针向后指向一位
            if (people[light] + people[heavy] <= limit) {
                light++;
            }
            //体重最重的人指针向前指向
            heavy--;
            //用船数量+1
            count++;
        }
        return count;
    }
}


class Solution107 {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int light = 0, heavy = people.length - 1;
        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                ++light;
            }
            --heavy;
            ++ans;
        }
        return ans;
    }
}
