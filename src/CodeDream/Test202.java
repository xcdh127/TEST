package CodeDream;

import java.util.HashSet;
import java.util.Set;

/*编写一个算法来判断一个数 n 是不是快乐数。
「快乐数」 定义为：
对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程 结果为 1，那么这个数就是快乐数。
如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
示例 1：
输入：n = 19
输出：true
解释：
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
示例 2：
输入：n = 2
输出：false
提示：
1 <= n <= 231 - 1
*/
public class Test202 {
    public boolean isHappy(int n) {
        //记录这个数字是否出现过
        Set<Integer> set = new HashSet<>();
        while (true) {
            //获取下一个数字
            int next = getNext(n);
            //将下一个数字赋值给n
            n = next;
            //当next等于1时，返回true
            if (next == 1) {
                return true;
            }
            //当数字原来出现过时，返回false
            if (set.contains(next)) {
                return false;
            }
            //将当前数字添加到set集合中
            set.add(next);
        }
    }
    //获取下一个数字
    public int getNext(int n) {
        int next = 0;
        while (n > 0) {
            int yuShu = n % 10;
            next += yuShu * yuShu;
            n /= 10;
        }
        return next;
    }
}
