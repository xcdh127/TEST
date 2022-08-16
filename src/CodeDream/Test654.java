package CodeDream;

/*给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
创建一个根节点，其值为 nums 中的最大值。
递归地在最大值 左边 的 子数组前缀上 构建左子树。
递归地在最大值 右边 的 子数组后缀上 构建右子树。
返回 nums 构建的 最大二叉树 。
示例 1：
输入：nums = [3,2,1,6,0,5]
输出：[6,3,5,null,2,0,null,null,1]
解释：递归调用如下所示：
- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
        - 空数组，无子节点。
        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
            - 空数组，无子节点。
            - 只有一个元素，所以子节点是一个值为 1 的节点。
    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
        - 只有一个元素，所以子节点是一个值为 0 的节点。
        - 空数组，无子节点。
示例 2：
输入：nums = [3,2,1]
输出：[3,null,2,null,1]
提示：
1 <= nums.length <= 1000
0 <= nums[i] <= 1000
nums 中的所有整数 互不相同
*/
public class Test654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        return recur(nums, 0, n);
    }

    //寻找区间l到r之间的最大值的位置
    public int findMax(int[] nums, int l, int r) {
        //假设数组中最大值的位置是l
        int maxIndex = l;
        //在区间l到r-1之间遍历数组，寻找最大值的位置
        for (int i = l; i < r; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        //返回最大值的位置
        return maxIndex;
    }

    //递归建树
    public TreeNode recur(int[] nums, int l, int r) {
        //当l大于等于r时返回null
        if (l >= r) {
            return null;
        }
        //获取数组l到r-1位置的最大值位置
        int maxIndex = findMax(nums, l, r);
        //创建根节点
        TreeNode root = new TreeNode(nums[maxIndex]);
        //构建左子树
        root.left = recur(nums, l, maxIndex);
        //构建右子树
        root.right = recur(nums, maxIndex + 1, r);
        //返回根节点
        return root;
    }
}

class Solution4 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    public TreeNode construct(int[] nums, int l, int r) {
        if (l == r)
            return null;
        int max_i = max(nums, l, r);
        TreeNode root = new TreeNode(nums[max_i]);
        root.left = construct(nums, l, max_i);
        root.right = construct(nums, max_i + 1, r);
        return root;
    }

    public int max(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i < r; i++) {
            if (nums[max_i] < nums[i])
                max_i = i;
        }
        return max_i;
    }
}

