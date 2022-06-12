package MeiTuan;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] line=sc.nextLine().split(" ");
        int n=Integer.parseInt(line[0]);
        int m=Integer.parseInt(line[1]);
        int[] arr=new int[n];
        String[] str=sc.nextLine().split(" ");
        //arr数组
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(str[i]);
        }
        //统计和
        int sum=0;
        for(int i=0;i<m;i++){
            String[] optsStr=sc.nextLine().split(" ");
            int len=optsStr.length;
            int[] opts=new int[len];
            for(int j=0;j<len;j++){
                opts[j]=Integer.parseInt(optsStr[j]);
            }
            if(len==3){
                int start=opts[1];
                int end=opts[2];
                for(int k=start-1;k<=end-1;k++){
                    sum+=arr[k];
                }
            }
            else if(len==4){
                int start=opts[1];
                int end=opts[2];
                for(int k=start-1;k<=end-1;k++){
                    arr[k]+=opts[3];
                }
            }
        }
        System.out.println(sum);
    }
}
