package SanLiuLing;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] line=sc.nextLine().split(" ");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(line[i]);
        }
        int up=0;
        int down=0;
        int grade=50;
        for(int i=0;i<n;i++){
            int level=arr[i];
            if(level==100-grade){
                grade=grade;
            }
            else if(level<100-grade){
                int add;
                if((100-grade-level)%10==0){
                    add=(100-grade-level)/10;
                }
                else{
                    add=((100-grade-level)/10)+1;
                }
                grade=grade+add;
                up++;
            }
            else if(level>100-grade){
                int des;
                if((level+100-grade)%10==0){
                    des=(level+100-grade)/10;
                }
                else{
                    des=((level+100-grade)/10)+1;
                }
                grade=grade-des;
                down++;
            }
        }
        System.out.print(up+" "+ down);
    }
}
