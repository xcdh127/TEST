package JianZHiOffer;

import java.util.HashMap;
import java.util.Map;

/*输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。

假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 

示例 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
示例 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

限制：

0 <= 节点个数 <= 5000

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Test07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i],i);
        }
        return recur(map,preorder,0,0,n-1);
    }
    public TreeNode recur(Map<Integer,Integer> map, int[] preorder,int root,int l,int r){
        if (l>r){
            return null;
        }
        //根节点在中序遍历中的位置
        int index=map.get(preorder[root]);
        //创建新节点
        TreeNode node=new TreeNode(preorder[root]);
        node.left=recur(map,preorder,root+1,l,index-1);
        node.right=recur(map,preorder,root+1+index-l,index+1,r);
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
