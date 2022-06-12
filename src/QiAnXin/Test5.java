package QiAnXin;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val=val;
    }
}
public class Test5 {
    public static void main(String[] args) {


    }

    public static TreeNode reBuild(TreeNode root){
        ArrayList<Integer> res=new ArrayList<>();
        TreeNode cur=root;
        Stack<TreeNode> stack=new Stack();
        while(!stack.isEmpty() && cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            res.add(cur.val);
            cur=cur.right;
        }
        int[] arr=res.stream().mapToInt(Integer::intValue).toArray();
        int n=arr.length;
        Arrays.sort(arr);
        return build(arr,0,n-1);
    }


    public static TreeNode build(int[] arr,int i,int j){
            int n=arr.length;
            if(i>=j){
                return null;
            }
            int m=(i+j)/2;
            TreeNode node=new TreeNode(arr[m]);
            node.left=build(arr,i,m-1);
            node.right=build(arr,m+1,j);
            return node;
    }
}
