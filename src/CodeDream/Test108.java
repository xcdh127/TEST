package CodeDream;

/*给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
示例 1：
输入：nums = [-10,-3,0,5,9]
输出：[0,-3,9,-10,null,5]
解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
示例 2
输入：nums = [1,3]
输出：[3,1]
解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
提示：
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 按 严格递增 顺序排列
*/
public class Test108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return recur(nums, 0, n - 1);
    }

    public TreeNode recur(int[] nums, int l, int r) {
        //当l大于r时，返回null
        if (l > r) {
            return null;
        }
        //取数组中点位置
        int m = l + (r - l) / 2;
        //以数组中点值，新建节点
        TreeNode root = new TreeNode(nums[m]);
        //为新建节点创建左节点
        root.left = recur(nums, l, m - 1);
        //为新建节点创建右节点
        root.right = recur(nums, m + 1, r);
        //返回新建节点
        return root;
    }
}
