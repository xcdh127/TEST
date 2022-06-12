package Baidu;
import java.util.*;
public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line1=sc.nextLine().split(" ");
        int N=Integer.parseInt(line1[0]);
        int K=Integer.parseInt(line1[1]);
        int[][] arr=new int[N][N];
            for(int i=0;i<N;i++){
                String[] line2=sc.nextLine().split(" ");
                for(int j=0;j<N;j++){
                    arr[i][j]=Integer.parseInt(line2[j]);
                }
            }
            int len=N*K;
            int[][] res=new int[len][len];
            for(int i=0;i<len;i++){
                for(int j=0;j<len;j++){
                    if(arr[i/K][j/K]==1){
                        res[i][j]=1;
                    }
                }
            }
            for(int i=0;i<len;i++){
                for(int j=0;j<len;j++){
                    System.out.print(res[i][j]+" ");
                }
                System.out.println();
            }


    }
}

/*
1 1 1 0 0 0 1 1 1
1 1 1 0 0 0 1 1 1
1 1 1 0 0 0 1 1 1
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
1 1 1 0 0 0 1 1 1
1 1 1 0 0 0 1 1 1
1 1 1 0 0 0 1 1 1
* */
