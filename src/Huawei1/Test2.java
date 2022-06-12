package Huawei1;
import java.util.Scanner;
public class Test2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        while (sc.hasNext()){
            String s=sc.nextLine();
            String[] line1=s.split("\\*");
            String[] line2=line1[1].split("=");
            int numA=Integer.parseInt(line1[0]);
            int numB=Integer.parseInt(line2[0]);
            int result=Integer.parseInt(line2[1]);
            if(result==numA*numB){
                System.out.println(0);
            }
            else {
                System.out.println(-1);
            }
        }
    }
}
/*
1
12*12=444

1
1*123=123

2
12*12=444
123*123=1

* */