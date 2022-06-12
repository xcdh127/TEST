package JianZHiOffer;
/*输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
参考以下这颗二叉搜索树：
     5
    / \
   2   6
  / \
 1   3
示例 1：
输入: [1,6,3,2,5]
输出: false
示例 2：
输入: [1,3,2,6,5]
输出: true
提示：
数组长度 <= 1000
*/
public class Test35 {
    public boolean verifyPostorder(int[] postorder) {
        int n=postorder.length;
        return recur(postorder,0,n-1);
    }

    public boolean recur(int[] postorder,int l,int r){
        if (l>=r){
            return true;
        }
        int i=l;
        //从左遍历到右，寻找第一个大于r位置的数字（根节点），也就是根节点的右子树的分界点
        while (postorder[i]<postorder[r]){
            i++;
        }
        //位置p就是右子树的起始节点
        int p=i;
        //开始检查右子树，如果右子树节点大于根节点，下标向右移动一位
        while (postorder[i]>postorder[r]){
            i++;
        }
        //判断当前子树是否合规(当前右子树都大于根节点)  检查左子树   检查右子树
        return i==r && recur(postorder,l,p-1) && recur(postorder,p,r-1);
    }
}
/*class Solution {
	int[] postorder;
    public boolean verifyPostorder(int[] postorder) {
    	this.postorder=postorder;
    	return recur(0,postorder.length-1);
    }
    public boolean recur(int l,int r){
    	if(l>=r){
    		return true;
    	}
    	int i=l;
    	while(postorder[i]<postorder[r]){
    		i++;
    	}
    	int p=i;
    	while(postorder[i]>postorder[r]){
    		i++;
    	}
    	return i==r && recur(l,p-1) && recur(p,r-1);

    }


}*/