package xiaohongshu;
import java.util.*;
//public class Test3 {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int N=sc.nextInt();
//        int[] a=new int[210];
//        int[] b=new int[210];
//
//        for(int i=0;i<N;i++){
//            a[i]=sc.nextInt();
//        }
//
//        for(int i=0;i<N;i++){
//            b[i]=a[i];
//        }
//        int[][][] dp=new int[210][210][210];
//        int total=1;
//        for(int i=1;i<=N;i++){
//            if(){}
//        }
//        System.out.println(f(1, N, 0, dp, a, b));
//
//
//    }
//    public static int pingFang(int d){
//        return d*d;
//    }
//
//    public static int f(int x,int y,int l,int[][][] dp,int[] a,int[] b){
//        int tt=pingFang(b[y]+l);
//        if(x==y){
//            return tt;
//        }
//        if(dp[x][y][l]!=0)return dp[x][y][l];
//        int m=f(x,y-1,0,dp,a,b)+tt;
//        for(int i=x;i<y-1;i++){
//            if(a[i]==a[y]){
//                m=Math.max(m,f(x,i,l+b[y],dp,a,b)+f(i+1,y-1,0,dp,a,b));
//            }
//        }
//        return dp[x][y][l]=m;
//    }
//}
