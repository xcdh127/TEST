package huyu1;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Test1 {
    public static int ans;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] line1=sc.nextLine().split(" ");
        String[] line2=sc.nextLine().split(" ");
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        for(int i=0;i<n;i++){
            arr1[i]=Integer.parseInt(line1[i]);
            arr2[i]=Integer.parseInt(line2[i]);
        }
        Map<Integer,Integer> map=new HashMap<>();
        TreeNode root=buildTree(map,arr1,arr2);
        System.out.println(count(root));
    }


    public static TreeNode buildTree(Map<Integer,Integer> map,int[] inorder, int[] postorder) {

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return recur(map,postorder,inorder.length-1,0,inorder.length-1);


    }

    public static TreeNode recur(Map<Integer,Integer> map,int[] postorder,int root,int l,int r){
        if(l>r){
            return null;
        }
        int i=map.get(postorder[root]);
        TreeNode node=new TreeNode(postorder[root]);
        node.left=recur(map,postorder,root-(r-i)-1,l,i-1);
        node.right=recur(map,postorder,root-1,i+1,r);
        return node;
    }

    public static int count(TreeNode root){
        recuring(root);
        return ans-1;
    }
    public static int recuring(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=recuring(root.left);
        int right=recuring(root.right);
        ans=Math.max(ans,left+right+1);
        return 1+Math.max(left,right);
    }
}

