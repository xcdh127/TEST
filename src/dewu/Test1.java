package dewu;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Node {
   int val;
     Node left;
     Node right;
     Node() {}
     Node(int val) { this.val = val; }
     Node(int val, Node left, Node right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class Test1 {
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
        Node root=buildTree(arr1,arr2);
        postOrder(root);
    }

    public static Node buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=inorder.length;
        //将中序遍历的元素及其下标存到map中
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return recur(map,preorder,0,0,n-1);
    }
    //前 ：根(root) 左 右
    //中 ：左 根(i) 右
    public static Node recur(Map<Integer,Integer> map,int[] preorder,int root,int l,int r){
        //当l>r时,返回null
        if(l>r){
            return null;
        }
        //获取根节点在中序遍历的位置
        int i=map.get(preorder[root]);
        //创建根节点
        Node node=new Node(preorder[root]);
        //为根节点创建左子树
        node.left=recur(map,preorder,root+1,l,i-1);
        //为根节点创建右子树
        node.right=recur(map,preorder,root+1+i-l,i+1,r);
        //返回根节点
        return node;
    }

    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
}
