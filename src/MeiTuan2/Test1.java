package MeiTuan2;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(sc.nextLine());
        }
            for(int i=0;i<n;i++){
                int num=arr[i];
                int num1=num;
                int count=0;
                while(num>0){
                    int yushu=num%10;
                    if(yushu==1){
                        count++;
                    }
                    num/=10;
                }
                if(num1%11==0 || count>=2){
                    System.out.println("yes");
                }
                else{
                    System.out.println("no");
                }
            }

        }

}
