package Huawei1;
import java.util.Scanner;
public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //小时数
        int n=Integer.parseInt(sc.nextLine());
        //水果店数
        int m=Integer.parseInt(sc.nextLine());
        int[][] arr=new int[m][3];
        int[] res=new int[n+1];
        for(int i=1;i<=n;i++){
            res[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<m;i++){
            String[] line=sc.nextLine().split(" ");
            //开始时间
            arr[i][0]=Integer.parseInt(line[0]);
            //结束时间
            arr[i][1]=Integer.parseInt(line[1]);
            //价格
            arr[i][2]=Integer.parseInt(line[2]);
        }
        //遍历数组
        for(int i=0;i<m;i++){
            for(int j=arr[i][0];j<=arr[i][1];j++){
                if(res[j]>arr[i][2]){
                        res[j]=arr[i][2];
                }
                }
            }
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=res[i];
        }
        System.out.println(sum);
    }
}

/*
*
4
6
2 3 10
2 4 20
1 3 15
1 4 25
3 4 8
1 4 16

5
3
1 2 30
1 5 20
3 5 10

* */