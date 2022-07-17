package codeTop;

import java.util.HashMap;
import java.util.Map;

/*给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
 inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
示例 1:
输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]
示例 2:
输入: preorder = [-1], inorder = [-1]
输出: [-1]
提示:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder 和 inorder 均 无重复 元素
inorder 均出现在 preorder
preorder 保证 为二叉树的前序遍历序列
inorder 保证 为二叉树的中序遍历序列
*/
public class Test105 {
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        //将中序遍历存放到map中，方便找根节点位置
        for (int i = 0; i < n; i++) {
            map.put(inorder[i],i);
        }
        return recur(preorder,0,0,n-1);
    }

    public TreeNode recur(int[] preorder,int root,int l,int r){
        //当l>r时，返回null
        if (l>r){
            return null;
        }
        //根节点的位置
        int i=map.get(preorder[root]);
        //根节点
        TreeNode node =new TreeNode(preorder[root]);
        //构造左子树
        node.left=recur(preorder,root+1,l,i-1);
        //构建右子树，i-l为左子树节点个
        node.right=recur(preorder,root+i-l+1,i+1,r);
        return node;
    }
}
