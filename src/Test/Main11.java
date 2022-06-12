package Test;

import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        if(num%2==1){
            //输出上半个三角形
            for(int i=0;i<num/2+1;i++){
                for(int j=num/2+1;j>i+1;j--){
                    System.out.print(" ");
                }
                for(int j=0;j<2*i+1;j++){
                    System.out.print("*");
                }
                System.out.println();
            }
            //输出下半个三角形
            for(int i=num/2+1;i<num;i++){
                for(int j=0;j<i-num/2;j++) {
                    System.out.print(" ");
                }
                for(int j=0;j<2*num-1-2*i;j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
