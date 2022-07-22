package codeTop;
/*给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
示例 1:
输入: [2,2,1]
输出: 1
示例2:
输入: [4,1,2,1,2]
输出: 4
*/
public class Test136 {
    public int singleNumber(int[] nums) {
        int n=nums.length;
        //求数组中的抑或值xor
        int xor=0;
        //全组数组求取抑或值
        for (int num :nums) {
            xor^=num;
        }
        //返回抑或值
        return xor;
    }
}
