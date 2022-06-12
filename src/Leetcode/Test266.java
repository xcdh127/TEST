package Leetcode;
/*矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
矩形的上下边平行于 x 轴，左右边平行于 y 轴。
如果相交的面积为 正 ，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
给出两个矩形 rec1 和 rec2 。如果它们重叠，返回 true；否则，返回 false 。
*/
/*输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
输出：true*/
public class Test266 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return Math.min(rec1[2],rec2[2])>Math.max(rec1[0],rec2[0]) &&
                Math.min(rec1[3],rec2[3])>Math.max(rec1[1],rec2[1]);
    }

}

/* return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/rectangle-overlap/solution/ju-xing-zhong-die-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
