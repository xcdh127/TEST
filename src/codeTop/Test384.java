package codeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是等可能的。
实现 Solution class:
Solution(int[] nums) 使用整数数组 nums 初始化对象
int[] reset() 重设数组到它的初始状态并返回
int[] shuffle() 返回数组随机打乱后的结果
示例 1：
输入
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
输出
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
解释
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
提示：
1 <= nums.length <= 50
-106 <= nums[i] <= 106
nums 中的所有元素都是 唯一的
最多可以调用 104 次 reset 和 shuffle
*/
public class Test384 {
    int[] copyOf;
    int n;

    public Test384(int[] nums) {
        n = nums.length;
        //先拷贝原数组
        copyOf = Arrays.copyOf(nums, n);

    }

    //重新复制一份数组，返回
    public int[] reset() {
        return Arrays.copyOf(copyOf, n);
    }

    public int[] shuffle() {
        //将数组放进动态数组中
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(copyOf[i]);
        }
        //创建随机数
        Random random = new Random();
        //结果数组
        int[] res = new int[n];
        //当前位置为i
        int i = 0;
        //当链表的长度大于0时
        while (list.size() > 0) {
            //以当前链表的长度为初始值，获取一个随机数
            int index = random.nextInt(list.size());
            //将删除的节点，放进数组当中
            res[i++] = list.remove(index);
        }
        return res;
    }
}
